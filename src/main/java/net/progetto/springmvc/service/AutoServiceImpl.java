package net.progetto.springmvc.service;

import net.progetto.springmvc.dao.AutoDao;
import net.progetto.springmvc.dto.AutoDto;
import net.progetto.springmvc.entity.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao AutoDAO;

    @Override
    @Transactional
    public List <Auto> getAuto() {
        return AutoDAO.getAuto();
    }

    @Override
    @Transactional
    public void saveAuto(AutoDto theAuto) {
        Auto AutoEntity = new Auto();
        AutoEntity.setId(theAuto.getId());
        AutoEntity.setTarga(theAuto.getTarga());
        AutoEntity.setMarca(theAuto.getMarca());
        AutoEntity.setModello(theAuto.getModello());
        AutoDAO.saveAuto(AutoEntity);
    }

    @Override
    @Transactional
    public Auto getAuto(int theId) {
        return AutoDAO.getAuto(theId);
    }

    @Override
    @Transactional
    public void deleteAuto(int theId) {
        AutoDAO.deleteAuto(theId);
    }
}