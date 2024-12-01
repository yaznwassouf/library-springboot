package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.library.demo.DAO.PatronDao;
import com.library.demo.entity.Patron;

public class PatronServiceImpl implements PatronService {


    private PatronDao patronDao;


    @Autowired
    public PatronServiceImpl(PatronDao thePatronDao){
        this.patronDao= thePatronDao;
    }


    @Override
    public List<Patron> findAllPatrons() {
       return patronDao.findAllPatrons();
    }

    @Override
    public Patron findById(int id) {
         return patronDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Patron patron) {
      patronDao.save(patron);
    }

    
    @Override
    @Transactional
    public void deleteById(int id) {
        patronDao.deleteById(id);
    }

}
