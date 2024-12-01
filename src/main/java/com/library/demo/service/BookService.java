package com.library.demo.service;

import java.util.List;

import com.library.demo.entity.Book;

public interface BookService {

    List<Book> findAllBook();

    Book findById(int id);

    void save(Book book);

    void deleteById(int id);
}
