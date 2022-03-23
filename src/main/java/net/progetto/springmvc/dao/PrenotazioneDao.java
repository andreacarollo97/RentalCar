package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.entity.Prenotazione;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneDao {

    List <Prenotazione> getPrenotazione();

    List <Prenotazione> getPrenotazioniConfermate(Integer userId);

    void savePrenotazione(Prenotazione thePrenotazione);

    Prenotazione getPrenotazione(int theId);

    void deletePrenotazione(int theId);

    List <Auto> getAutoByPrenotazioni(LocalDate dateStart, LocalDate dateEnd);

}