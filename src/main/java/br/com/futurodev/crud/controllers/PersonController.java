package br.com.futurodev.crud.controllers;

import br.com.futurodev.crud.models.Person;
import br.com.futurodev.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value="/",produces = "application/json")
    public ResponseEntity<Person> update(@RequestBody Person person){
        Person pers = personRepository.save(person);
        return new ResponseEntity<Person>(pers,HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long id){
        personRepository.deleteById(id);
        return new ResponseEntity<>("Person updated with success!",HttpStatus.OK);
    }

    @GetMapping(value="/{idUsuario}",produces = "application/json")
    public ResponseEntity<Person> getUserById(@PathVariable(value = "id")Long id){
        Person pers = personRepository.findById(id).get();
        return new ResponseEntity<>(pers,HttpStatus.OK);
    }

}