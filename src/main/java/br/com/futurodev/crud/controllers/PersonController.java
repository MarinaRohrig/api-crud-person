package br.com.futurodev.crud.controllers;

import br.com.futurodev.crud.models.Person;
import br.com.futurodev.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;


    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Person> register(@RequestBody Person person){
      Person pers = personRepository.save(person);
      return new ResponseEntity<Person>(pers, HttpStatus.CREATED);
    }

}
