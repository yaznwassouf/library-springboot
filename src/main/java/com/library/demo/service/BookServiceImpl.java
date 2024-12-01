package com.library.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.demo.DAO.BookDao;
import com.library.demo.entity.Book;


@Service
public class BookServiceImpl  implements BookService{

    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao theBookDao){
        this.bookDao= theBookDao;
    }


    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public Book findById(int id) {
     return  bookDao.findById(id);
    }

    @Transactional
    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        bookDao.deleteById(id);
    }


   

}
