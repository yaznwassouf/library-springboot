package com.library.demo.DAO;

import java.util.List;

// import com.library.demo.entity.Book;

// import org.springframework.stereotype.Repository;

import com.library.demo.entity.Patron;


public interface PatronDao {

    List<Patron> findAllPatrons();

    Patron findById(int id);

    void save(Patron patron);

    void deleteById(int id);

}
