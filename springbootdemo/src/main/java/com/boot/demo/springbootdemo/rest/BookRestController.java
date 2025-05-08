package com.boot.demo.springbootdemo.rest;


import com.boot.demo.springbootdemo.entity.Book;
import com.boot.demo.springbootdemo.service.BookService;
import com.boot.demo.springbootdemo.service.BookServiceRepo;
import com.boot.demo.springbootdemo.utility.AppConstants;
import com.boot.demo.springbootdemo.utility.Status;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookRestController {

    Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private BookServiceRepo bookService;
    public BookRestController() {
        System.out.println("Book Rest Controller default constructor");
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String author,
                               @RequestParam(required = false) Integer price){
        logger.warn("GET All books if author is null or get books by author : {}", author);

        if(author!=null )
            return bookService.getBooksByAuthor(author);
//        if(price != null)
//            return bookService.getBooksByPriceGreaterThan(price);
        return bookService.getAllBooks();


    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable  int id){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.getBookById(id) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addBook(@Valid @RequestBody  Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.addNewBook(book) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateBook(@RequestBody  Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.updateBook(book) );
            return ResponseEntity.ok(map);
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable  int id){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            if(bookService.deleteBook(id)) {
                map.put("message", "Book deleted successfully");
                return ResponseEntity.ok(map);
            }
        }
        catch (RuntimeException e){
            map.put(AppConstants.STATUS, Status.FAILURE);
            map.put("error",e.getMessage());

        }
        return ResponseEntity.badRequest().body(map);
    }


}
