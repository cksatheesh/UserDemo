package com.example.demo;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repos.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository repository;
	
	@GetMapping
	public Iterable<User> getUsers() {
		return repository.findAll();
	}
	
	@PostMapping
	public User create(@RequestBody User user) {
		return repository.save(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return repository.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		return repository.findOne(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
	    repository.delete(id);
	}
}
