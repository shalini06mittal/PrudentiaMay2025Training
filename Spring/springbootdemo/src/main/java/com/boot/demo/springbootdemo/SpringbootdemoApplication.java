package com.boot.demo.springbootdemo;

import com.boot.demo.springbootdemo.entity.Book;
import com.boot.demo.springbootdemo.repo.BookRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@Autowired
	private BookRepo repo;

	@PostConstruct
	public void initialize(){
		repo.save(new Book(1,"t1","a1","desc",673));
	}
}
