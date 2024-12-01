package com.library.demo.DAO;

import java.util.List;

import com.library.demo.entity.Book;

public interface BookDao {


    List<Book> findAllBook();
    
    Book findById(int id);

    void save(Book book);

    void deleteById(int id);

}
