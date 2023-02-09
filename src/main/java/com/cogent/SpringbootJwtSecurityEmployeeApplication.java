package com.cogent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.entity.Author;
import com.cogent.entity.User;
import com.cogent.repository.AuthorRepository;
import com.cogent.repository.UserRepository;

@SpringBootApplication
public class SpringbootJwtSecurityEmployeeApplication {

	@Autowired
    private UserRepository repository;
	
	@Autowired
	private AuthorRepository authorRepository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "gyanendra", "password", "gyanendra@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
        
        List<Author> authors = Stream.of(
                new Author(1001, "Joi", "US",4705721900L),
                new Author(1002, "Sam", "US",4102607615L),
                new Author(1003, "Kayla", "Russia",7474215984L),
                new Author(1004, "Malik", "India", 1673618345L)
        ).collect(Collectors.toList());
        authorRepository.saveAll(authors);
        
    }
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtSecurityEmployeeApplication.class, args);
	}

}
