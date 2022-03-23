package net.progetto.springmvc.service;


import net.progetto.springmvc.dao.PrenotazioneDao;

import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.entity.Prenotazione;
import net.progetto.springmvc.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Autowired
    private PrenotazioneDao prenotazioneDao;

    @Autowired
    private UserService userService;

    @Autowired
    private AutoService autoService;




    @Override
    @Transactional
    public List <Prenotazione> getPrenotazione() {
        return prenotazioneDao.getPrenotazione();
    }

    @Override
    @Transactional
    public List <Prenotazione> getPrenotazioniConfermate() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
        return prenotazioneDao.getPrenotazioniConfermate(user.getId());
    }

    @Override
    @Transactional
    public List <Auto> getAutoList(LocalDate dateStart, LocalDate dateEnd) {
        return prenotazioneDao.getAutoByPrenotazioni(dateStart,dateEnd);
    }

    @Override
    @Transactional
    public void savePrenotazione(Integer autoId, LocalDate dateStart, LocalDate dateEnd) {

        Prenotazione prenotazioneEntity = new Prenotazione();

        prenotazioneEntity.setDateStart(dateStart);
        prenotazioneEntity.setDateEnd(dateEnd);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByUsername(username);
        prenotazioneEntity.setUser(user);

        Auto auto = autoService.getAuto(autoId);
        prenotazioneEntity.setAuto(auto);


        prenotazioneDao.savePrenotazione(prenotazioneEntity);
    }

    @Override
    @Transactional
    public void confermaPrenotazione(Integer id, Integer autoId, LocalDate dateStart, LocalDate dateEnd, int stato, String username) {

        Prenotazione prenotazioneEntity = new Prenotazione();

        prenotazioneEntity.setDateStart(dateStart);
        prenotazioneEntity.setDateEnd(dateEnd);
        prenotazioneEntity.setId(id);
        prenotazioneEntity.setStato(stato);



        User user = userService.getUserByUsername(username);
        prenotazioneEntity.setUser(user);

        Auto auto = autoService.getAuto(autoId);
        prenotazioneEntity.setAuto(auto);


        prenotazioneDao.savePrenotazione(prenotazioneEntity);
    }


    @Override
    @Transactional
    public Prenotazione getPrenotazione(int theId) {
        return prenotazioneDao.getPrenotazione(theId);
    }

    @Override
    @Transactional
    public void deletePrenotazione(int theId) {
        prenotazioneDao.deletePrenotazione(theId);
    }


}