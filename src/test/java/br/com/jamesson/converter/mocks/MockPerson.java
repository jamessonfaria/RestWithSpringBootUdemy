package br.com.jamesson.converter.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.jamesson.data.model.Person;
import br.com.jamesson.data.vo.PersonVO;

public class MockPerson {

	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		return persons;
	}
	
	public List<PersonVO> mockVOList() {
		List<PersonVO> persons = new ArrayList<>();
		for (int i = 0; i < 14; i++) {
			persons.add(mockVO(i));
		}
		return persons;
	}

	private PersonVO mockVO(Integer number) {
		PersonVO person = new PersonVO();
		person.setAddress("Address Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setLastName("Last Name Test" + number);
		person.setGender(((number % 2)==0) ? "Male" : "Female");
		person.setId(number.longValue());
		return person;
	}

	private Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Address Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setLastName("Last Name Test" + number);
		person.setGender(((number % 2)==0) ? "Male" : "Female");
		person.setId(number.longValue());
		return person;
	}
	

}