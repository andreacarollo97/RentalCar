package net.progetto.springmvc.service;

import net.progetto.springmvc.dto.AutoDto;
import net.progetto.springmvc.entity.Auto;

import java.text.ParseException;
import java.util.List;

public interface AutoService {

    List <Auto> getAuto();

    void saveAuto(AutoDto theAuto) throws ParseException;

    Auto getAuto(int theId);

    void deleteAuto(int theId);

}