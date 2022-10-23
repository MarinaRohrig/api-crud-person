package br.com.futurodev.crud.repository;

import br.com.futurodev.crud.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository <Person, Long> {

}
