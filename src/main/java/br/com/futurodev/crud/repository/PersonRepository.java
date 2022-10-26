package br.com.futurodev.crud.repository;

import br.com.futurodev.crud.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "select p from Person p where p.name like%?1%")
    ArrayList<Person> getUserByName(String name);


}
