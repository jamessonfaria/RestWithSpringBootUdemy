package br.com.jamesson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jamesson.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
