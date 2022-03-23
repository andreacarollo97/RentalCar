package net.progetto.springmvc.service;

import net.progetto.springmvc.dto.AutoDto;
import net.progetto.springmvc.dto.PrenotazioneDto;
import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.entity.Prenotazione;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneService {

    List <Prenotazione> getPrenotazione();

    List <Prenotazione> getPrenotazioniConfermate();

    void savePrenotazione(Integer autoId, LocalDate dateStart, LocalDate dateEnd) throws ParseException;

    void confermaPrenotazione(Integer id, Integer autoId, LocalDate dateStart, LocalDate dateEnd, int stato, String username);

    Prenotazione getPrenotazione(int theId);

    void deletePrenotazione(int theId);

    List <Auto> getAutoList(LocalDate dateStart, LocalDate dateEnd);

}