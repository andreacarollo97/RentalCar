package net.progetto.springmvc.dao;

import net.progetto.springmvc.entity.Auto;

import java.util.List;

public interface AutoDao {

    List <Auto> getAuto();

    void saveAuto(Auto theAuto);

    Auto getAuto(int theId);

    void deleteAuto(int theId);
}