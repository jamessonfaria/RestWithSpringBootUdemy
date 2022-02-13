package br.com.jamesson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesson.model.Person;
import br.com.jamesson.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@PostMapping
	public Person create(@RequestBody Person person) {
		return services.create(person);
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) {
		return services.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "/{id}")
	public Person findById(@PathVariable(value="id") Long id) {	
		return services.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll(){
		return services.findAll();
	}
	
}
