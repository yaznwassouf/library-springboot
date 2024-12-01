package com.library.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.demo.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class BookDaoImpl  implements BookDao{

    private EntityManager entityManager;

    @Autowired
    public BookDaoImpl(EntityManager thEntityManager){
        this.entityManager= thEntityManager;
    }


    @Override
    public List<Book> findAllBook(){
           
        TypedQuery<Book> theQuery= entityManager.createQuery("From Book", Book.class);

        List<Book> books= theQuery.getResultList();

        return books;
    }

    @Override
    public void save(Book book){
        entityManager.merge(book);
    }

    


    @Override
    public Book findById(int id) {
     Book book= entityManager.find(Book.class, id);

     return book;
    }


    
    @Override
    public void deleteById(int id){
        Book book = entityManager.find(Book.class, id);

        entityManager.remove(book);
    }
}
