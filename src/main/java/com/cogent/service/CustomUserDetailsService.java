package com.cogent.service;

import com.cogent.entity.Author;
import com.cogent.entity.User;
import com.cogent.repository.AuthorRepository;
import com.cogent.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
    
    // Create/Update an author
    public Author update(Author author) {
		  return authorRepository.save(author);
	  }
    
    // Display all authors
    public List<Author> getAll(){
		  return (List<Author>) authorRepository.findAll();
	  }
    
    // Display an author
    public Optional<Author> get(int authorId){
		  return authorRepository.findById(authorId);
	  }
    
    //Delete an author
    public void delete(Author author) {
		  authorRepository.delete(author);
	  }
    
    //Delete all authors
    public void deleteAll() {
		  authorRepository.deleteAll();
	  }
}
