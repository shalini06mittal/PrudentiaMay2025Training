package com.boot.demo.springbootdemo.rest;


import com.boot.demo.springbootdemo.entity.Book;
import com.boot.demo.springbootdemo.service.BookServiceRepo;
import com.boot.demo.springbootdemo.utility.AppConstants;
import com.boot.demo.springbootdemo.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books/ex")
public class BookRestControllerExceptionHandler {

    @Autowired
    private BookServiceRepo bookService;
    public BookRestControllerExceptionHandler() {
        System.out.println("Book Rest Controller default constructor");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        System.out.println("exception handler");
        Map<String, Object> body = new HashMap<>();
        body.put("errors", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String author){
        if(author==null)
            return bookService.getAllBooks();
        return bookService.getBooksByAuthor(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable  int id){
        Map<String, Object> map = new HashMap<>();
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.getBookById(id) );
            return ResponseEntity.ok(map);
    }

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody  Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();
            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.addNewBook(book) );
            return ResponseEntity.ok(map);

    }

    @PutMapping
    public ResponseEntity<Object> updateBook(@RequestBody  Book book){
        System.out.println("Book "+book);
        Map<String, Object> map = new HashMap<>();

            map.put(AppConstants.STATUS, Status.SUCCESS);
            map.put("book",bookService.updateBook(book) );
            return ResponseEntity.ok(map);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable  int id){
        Map<String, Object> map = new HashMap<>();

            map.put(AppConstants.STATUS, Status.SUCCESS);
            if(bookService.deleteBook(id)) {
                map.put("message", "Book deleted successfully");
                return ResponseEntity.ok(map);
            }


        return ResponseEntity.badRequest().body(map);
    }
}
