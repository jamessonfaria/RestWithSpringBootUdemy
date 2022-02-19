package br.com.jamesson.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Api(value = "Person Endpoint", description = "Description for person", tags = {"PersonEndpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices services;

	@ApiOperation(value = "Create a person")
	@PostMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, 
			produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) {
		PersonVO personVO = services.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Update a person")
	@PutMapping(consumes = {"application/json", "application/xml", "application/x-yaml"}, 
			produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) {		
		PersonVO personVO = services.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	@ApiOperation(value = "Delete a person")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}

	//@CrossOrigin(origins = "http://localhost:8080")
	@ApiOperation(value = "Find a person")
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		PersonVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}

	//@CrossOrigin(origins = {"http://localhost:8080", "http://www.jj.com.br"})
	@ApiOperation(value = "Find all people")
	@GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<PersonVO> findAll() {
		List<PersonVO> persons = services.findAll();
		persons.stream()
			.forEach(p -> p.add(linkTo(methodOn(PersonController.class)
					.findById(p.getKey()))
					.withSelfRel()));
		return persons;
	}

}
