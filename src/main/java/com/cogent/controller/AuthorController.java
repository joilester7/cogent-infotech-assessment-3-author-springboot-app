package com.cogent.controller;

import com.cogent.entity.AuthRequest;
import com.cogent.entity.Author;
import com.cogent.repository.AuthorRepository;
import com.cogent.repository.UserRepository;
import com.cogent.service.CustomUserDetailsService;
import com.cogent.util.JwtUtil;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private CustomUserDetailsService authorService;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
    
    // Create author
    @PostMapping("/authors")
	public Author add(@RequestBody Author author) {
		return authorService.update(author);
	}
    
 	// Get single author
 	@GetMapping("/authors/{id}")
	public Author get(@PathVariable("id") Integer id) {
		Optional<Author> i = authorService.get(id);
		return i.get();
	}
 	
    // Get all authors
 	@GetMapping(value= {"/authors"})
	public List<Author> getAll(){
		List<Author> authors = authorService.getAll();
		System.out.println("items retrieved "+ authors.size());
		return authors;
	}
	
	// Update author
 	@PutMapping("/authors")
	public Author edit(@RequestBody Author author) {
		return authorService.update(author);
	}
    
	// Delete author
	@DeleteMapping("/authors")
	public String delete(@RequestParam(value="id") int id) {
		Optional<Author> i = authorService.get(id);
		authorService.delete(i.get());
		return "Item id "+id+" deleted successfully";
	}
		
}
