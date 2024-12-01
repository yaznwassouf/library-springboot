package com.library.demo.rest;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.DAO.PatronDao;
// import com.library.demo.entity.Book;
// import com.library.demo.DAO.PatronDao;
import com.library.demo.entity.Patron;
// import com.library.demo.service.PatronService;

// import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class PatronRestController {

    // private List<Patron> thepatrons;

    // @PostConstruct
    // public void loadData(){
    //     thepatrons=new ArrayList<>();

    //     thepatrons.add(new Patron("Ali", "software Engineer"));
    //     thepatrons.add(new Patron("shaza", "netWork Engineer"));
    //     thepatrons.add(new Patron("soliman", "AI Engineer"));
    // }

    private PatronDao patronDao;

    public PatronRestController(PatronDao thePatronDao){
        this.patronDao= thePatronDao;
    }

    @GetMapping("/patrons")
    public List<Patron> findAllPatrons(){
         return patronDao.findAllPatrons();
    }

    @GetMapping("/patrons/{id}")
    public Patron getPatron(@PathVariable int id){
        Patron patron = patronDao.findById(id);

        if (patron == null){
            throw new RuntimeException("patron not found sorry!"+ id);
        }

        return patron;
    }


    @PostMapping("/patrons")
    public void addPatron(@RequestBody Patron thePatron){
        thePatron.setId(0);

        patronDao.save(thePatron);
    }



    @PutMapping("/patrons")
    public void updatePatron(@RequestBody Patron thePatron){

        patronDao.save(thePatron);
    }

    @DeleteMapping("/patron/{id}")
    public String deletePatron(@PathVariable int id){

        Patron patron= patronDao.findById(id);

        if (patron == null){
            throw new RuntimeException("book id not found");
        }

        patronDao.deleteById(id);

        return "deleted book id succesfully";
    }
    
}
