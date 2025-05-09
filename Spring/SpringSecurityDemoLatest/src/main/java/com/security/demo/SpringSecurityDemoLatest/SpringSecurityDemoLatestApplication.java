package com.security.demo.SpringSecurityDemoLatest;

import com.security.demo.SpringSecurityDemoLatest.entity.Customer;
import com.security.demo.SpringSecurityDemoLatest.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoLatestApplication {

	public static void main(String[] args) {
		System.out.println("HEYYYY");
		SpringApplication.run(SpringSecurityDemoLatestApplication.class, args);
	}

	@Autowired
	private CustomerRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostConstruct
	public void initialize(){
		System.out.println("database");
		repository.save(new Customer(1, "user@a.com",passwordEncoder.encode("12345"),"user"));
		repository.save(new Customer(2, "admin@a.com",passwordEncoder.encode("154321"),"admin"));
	}
}
