package br.com.jamesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jamesson.data.vo.PersonVOV2;
import br.com.jamesson.services.v2.PersonServicesV2;

@RestController
@RequestMapping("/api/person/v2")
public class PersonControllerV2 {

	@Autowired
	private PersonServicesV2 services;
	
	@PostMapping
	public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
		return services.createV2(person);
	}

}
