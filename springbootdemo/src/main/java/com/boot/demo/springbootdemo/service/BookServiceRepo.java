package com.boot.demo.springbootdemo.service;

import com.boot.demo.springbootdemo.entity.Book;
import com.boot.demo.springbootdemo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceRepo {
    @Autowired
    private BookRepo bookRepo;

    public long getTotalBookCount(){
        return bookRepo.count();
    }
    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }
    public Book addNewBook(Book book){
        if(bookRepo.existsById(book.getBookid()))
            throw new RuntimeException("Cannot add "+book.getBookid()+" already exists");
        return bookRepo.save(book);

    }
    public Book updateBook(Book book){
        if(!bookRepo.existsById(book.getBookid()))
            throw new RuntimeException("cannot update "+book.getBookid()+" does not exist");
        return bookRepo.save(book);
    }
    public boolean deleteBook(int id){
        if(!bookRepo.existsById(id))
            throw new RuntimeException("cannot delete "+id+" does not exist");
        bookRepo.deleteById(id);
        return true;
    }
    public Book getBookById(int id){
        if(!bookRepo.existsById(id))
            throw new RuntimeException(id+" not found");
        return bookRepo.findById(id).get();
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }
}
