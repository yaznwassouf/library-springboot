package com.library.demo.rest;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.library.demo.DAO.BookDao;
import com.library.demo.entity.Book;
import com.library.demo.service.BookService;

// import jakarta.annotation.PostConstruct;

// for create endpoints

@RestController
@RequestMapping("/api")
public class BookRestController {

    //  private List<Book> theBooks;

    // @PostConstruct
    // public void loadData(){
    //     theBooks = new ArrayList<>();

    //     theBooks.add(new Book( "monaliza", "yazan", 19998, "ddd"));
    //     theBooks.add(new Book( "monaliza", "magd", 19998, "sss"));
    //     theBooks.add(new Book( "monaliza", "maya", 19998, "www"));
    // }

    private BookService bookService;

    // using constructor injection
    public BookRestController(BookService thebookService){
        this.bookService= thebookService;
    }


    @GetMapping("/books")
    public List<Book> findAllBook(){
        return bookService.findAllBook();
    }


    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable int id){
        Book book = bookService.findById(id);

        if (book == null ){
            throw new RuntimeException("id not found sorry!"+id);
        }

        return book;
    }


    @PostMapping("/books")
    public void addBook(@RequestBody Book theBook){
        theBook.setId(0);

        bookService.save(theBook);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book theBook){
        bookService.save(theBook);
    }


    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){

        Book book= bookService.findById(id);

        if (book == null){
            throw new RuntimeException("book id not found");
        }

        

        bookService.deleteById(id);

        return "deleted book id succesfully";
    }



    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exc){
        BookErrorResponse error= new BookErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());

        // error.setMessage(exc.getMessage());

        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
