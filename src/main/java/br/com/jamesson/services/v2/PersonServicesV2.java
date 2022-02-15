package br.com.jamesson.services.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jamesson.converter.custom.PersonConverter;
import br.com.jamesson.data.vo.PersonVOV2;
import br.com.jamesson.repository.PersonRepository;

@Service
public class PersonServicesV2 {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonConverter converter;
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.convertVOToEntity(person);
		var vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
}
