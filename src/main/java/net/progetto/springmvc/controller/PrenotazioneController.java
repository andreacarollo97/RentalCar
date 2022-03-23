package net.progetto.springmvc.controller;

import net.progetto.springmvc.dto.AutoDto;
import net.progetto.springmvc.dto.PrenotazioneDto;
import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.entity.Prenotazione;
import net.progetto.springmvc.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping("/list")
    public String listPrenotazione(Model theModel) {
        List <Prenotazione> prenotazioni = prenotazioneService.getPrenotazione();
        theModel.addAttribute("prenotazioni", prenotazioni);
        return "prenotazione-list";
    }

    @GetMapping("/listPrenotazioniConfermate")
    public String listPrenotazioniConfermate(Model theModel) {
        List <Prenotazione> prenotazioniConfermate = prenotazioneService.getPrenotazioniConfermate();
        theModel.addAttribute("prenotazioniConfermate", prenotazioniConfermate);
        return "prenotazioni-confermate";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        PrenotazioneDto thePrenotazione = new PrenotazioneDto();
        theModel.addAttribute("prenotazione", thePrenotazione);
        return "prenotazione-form";
    }

    @PostMapping("/savePrenotazione")
    public String savePrenotazione(@RequestParam("auto_id") Integer auto_Id, @RequestParam("dateS") String dateS ,@RequestParam("dateE") String dateE) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateStart = LocalDate.parse(dateS, formatter);
        LocalDate dateEnd = LocalDate.parse(dateE, formatter);
        prenotazioneService.savePrenotazione(auto_Id, dateStart, dateEnd);
        return "prenotazione-avvenuta";
    }

    @GetMapping("/conferma")
    public String conferma(@RequestParam("prenotazioneId") int theId)  {
        Prenotazione thePrenotazione = prenotazioneService.getPrenotazione(theId);
        LocalDate dateStartP = thePrenotazione.getDateStart();
        LocalDate dateEndP=  thePrenotazione.getDateEnd();
        Integer auto_IdP = thePrenotazione.getAuto().getId();
        String username = thePrenotazione.getUser().getUsername();
        prenotazioneService.confermaPrenotazione(theId,auto_IdP,dateStartP,dateEndP,1,username);
        return "redirect:/prenotazione/list";
    }

    @GetMapping("/delete")
    public String deletePrenotazione(@RequestParam("prenotazioneId") int theId) {
        prenotazioneService.deletePrenotazione(theId);
        return "redirect:/prenotazione/list";
    }

    @PostMapping("/listAuto")
    public String listAutoByDate(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd, Model theModel) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateS = LocalDate.parse(dateStart, formatter);
        LocalDate dateE = LocalDate.parse(dateEnd, formatter);
        List <Auto> autoList = prenotazioneService.getAutoList(dateS,dateE);
        theModel.addAttribute("autolist", autoList);
        theModel.addAttribute("dataInizio",dateS);
        theModel.addAttribute("dataFine",dateE);
        return "prenotazione-list-auto";
    }
}