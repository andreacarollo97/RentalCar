package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.entity.Prenotazione;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PrenotazioneDaoImpl implements PrenotazioneDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Prenotazione> getPrenotazione() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Prenotazione > cq = cb.createQuery(Prenotazione.class);
        Root < Prenotazione > root = cq.from(Prenotazione.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List <Prenotazione> getPrenotazioniConfermate(Integer userId) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Prenotazione > cq = cb.createQuery(Prenotazione.class);
        Root < Prenotazione > root = cq.from(Prenotazione.class);
        cq.select(root).where(cb.and(cb.equal(root.get("user").get("id"),userId),cb.equal(root.get("stato"),1)));
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deletePrenotazione(int id) {
        Session session = sessionFactory.getCurrentSession();
        Prenotazione prenotazione = session.byId(Prenotazione.class).load(id);
        session.delete(prenotazione);
    }

    @Override
    public void savePrenotazione(Prenotazione thePrenotazione) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (thePrenotazione.getId() != null){
            currentSession.update(thePrenotazione);
        } else {
            currentSession.save(thePrenotazione);
        }
    }

    @Override
    public Prenotazione getPrenotazione(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Prenotazione thePrenotazione = currentSession.get(Prenotazione.class, theId);
        return thePrenotazione;
    }

    @Override
    public List <Auto> getAutoByPrenotazioni(LocalDate dateStart, LocalDate dateEnd) {



        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Prenotazione > cq = cb.createQuery(Prenotazione.class);
        Root < Prenotazione > root = cq.from(Prenotazione.class);
        cq.select(root).where(cb.and(cb.lessThan(root.get("dateStart"),dateEnd),cb.greaterThan(root.get("dateEnd"),dateStart)));
        Query query = session.createQuery(cq);
        List < Prenotazione > results = query.getResultList();

        List<Integer> iDautoPrenotate = new ArrayList<>();

        for (Prenotazione prenotazione : results){
            Integer autoId = prenotazione.getAuto().getId();
            iDautoPrenotate.add(autoId);
        }


        CriteriaBuilder cb1 = session.getCriteriaBuilder();
        CriteriaQuery<Auto> cr = cb1.createQuery(Auto.class);
        Root<Auto> root1 = cr.from(Auto.class);
        if (iDautoPrenotate.size() == 0){
            cr.select(root1);
        }
        else {
            cr.select(root1).where(cb1.not(cb1.in(root1.get("id")).value(iDautoPrenotate)));
        }
        Query query1 = session.createQuery(cr);
        List <Auto> autoLibere = query1.getResultList();

        return autoLibere;
    }

}