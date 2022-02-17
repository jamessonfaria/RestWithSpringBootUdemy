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

import br.com.jamesson.data.vo.PersonVO;
import br.com.jamesson.services.v1.PersonServices;

@RestController
@RequestMapping("/person/v1")
public class PersonController {

	@Autowired
	private PersonServices services;

	@PostMapping(consumes = {"application/json", "application/xml"}, 
			produces = {"application/json", "application/xml"})
	public PersonVO create(@RequestBody PersonVO person) {
		return services.create(person);
	}

	@PutMapping(consumes = {"application/json", "application/xml"}, 
			produces = {"application/json", "application/xml"})
	public PersonVO update(@RequestBody PersonVO person) {
		return services.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		return services.findById(id);
	}

	@GetMapping(produces = {"application/json", "application/xml"})
	public List<PersonVO> findAll() {
		return services.findAll();
	}

}
