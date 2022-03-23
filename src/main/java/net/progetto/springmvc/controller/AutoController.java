package net.progetto.springmvc.controller;

import net.progetto.springmvc.dto.AutoDto;
import net.progetto.springmvc.entity.Auto;
import net.progetto.springmvc.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    private AutoService autoService;

    @GetMapping("/list")
    public String listAuto(Model theModel) {
        List <Auto> theAutos = autoService.getAuto();
        theModel.addAttribute("auto", theAutos);
        return "auto-list";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        AutoDto theAuto = new AutoDto();
        theModel.addAttribute("auto", theAuto);
        return "auto-form";
    }

    @PostMapping("/saveAuto")
    public String saveAuto(@ModelAttribute("auto") AutoDto theAuto) throws ParseException {
        autoService.saveAuto(theAuto);
        return "redirect:/auto/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("autoId") int theId, Model theModel) {
        Auto theAuto = autoService.getAuto(theId);
        theModel.addAttribute("auto", theAuto);
        return "auto-form";
    }

    @GetMapping("/delete")
    public String deleteAuto(@RequestParam("autoId") int theId) {
        autoService.deleteAuto(theId);
        return "redirect:/auto/list";
    }
}