package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.Auto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AutoDaoImpl implements AutoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List <Auto> getAuto() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery < Auto > cq = cb.createQuery(Auto.class);
        Root < Auto > root = cq.from(Auto.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteAuto(int id) {
        Session session = sessionFactory.getCurrentSession();
        Auto auto = session.byId(Auto.class).load(id);
        session.delete(auto);
    }

    @Override
    public void saveAuto(Auto theAuto) {
        Session currentSession = sessionFactory.getCurrentSession();
        if (theAuto.getId() != null){
            currentSession.update(theAuto);
        } else {
            currentSession.save(theAuto);
        }
    }

    @Override
    public Auto getAuto(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Auto theAuto = currentSession.get(Auto.class, theId);
        return theAuto;
    }
}