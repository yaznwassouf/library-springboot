package com.library.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.demo.entity.Patron;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class PatronDaoImpl  implements PatronDao{

    private EntityManager entityManager;


    @Autowired
    public PatronDaoImpl (EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }


    @Override
    public List<Patron> findAllPatrons() {
        TypedQuery<Patron> theQuery= entityManager.createQuery("From Patron", Patron.class);


        List<Patron> patrons= theQuery.getResultList();

        return patrons;
    }


    @Override
    public Patron findById(int id) {
        Patron patron = entityManager.find(Patron.class, id);

        return patron;
    }


    @Override
    public void save(Patron patron) {
       entityManager.merge(patron);
    }


    @Override
    public void deleteById(int id) {
       
        Patron patron= entityManager.find(Patron.class, id);

        entityManager.remove(patron);
    }

    

}
