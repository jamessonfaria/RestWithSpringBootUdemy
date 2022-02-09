package br.com.jamesson.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.jamesson.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jamesson");
		person.setLastName("Faria");
		person.setAddress("Av do arroz, 100");
		person.setGender("M");
		return person;
	}
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Person person = mockPerson();
			persons.add(person);
		}
		
		return persons ;
	}

	private Person mockPerson() {
		Person person = new Person();
		long cont = counter.incrementAndGet();
		person.setId(cont);
		person.setFirstName("Person Name");
		person.setLastName("Last Name");
		person.setAddress("Endereco...");
		person.setGender(cont % 2 == 0 ? "M" : "F");
		return person;
	}
	
}
