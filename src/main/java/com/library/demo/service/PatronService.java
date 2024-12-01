package com.library.demo.service;

import java.util.List;

import com.library.demo.entity.Patron;

public interface PatronService {

    List<Patron> findAllPatrons();

    Patron findById(int id);

    void save(Patron patron);

    void deleteById(int id);
}
