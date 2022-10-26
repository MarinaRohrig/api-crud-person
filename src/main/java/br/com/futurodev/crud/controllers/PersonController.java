package br.com.futurodev.crud.controllers;

import br.com.futurodev.crud.models.Person;
import br.com.futurodev.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value="/{id}",produces = "application/json")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id")Long id){
        Person pers = personRepository.findById(id).get();
        return new ResponseEntity<>(pers,HttpStatus.OK);
    }

    @GetMapping(value="/list")
    @ResponseBody
    public ResponseEntity<List<Person>> listPerson(){
        List<Person> persons = personRepository.findAll();
        return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);

    }

    @GetMapping(value ="/consult")
    @ResponseBody
    public ResponseEntity<List<Person>> consultPersonByName(@RequestParam String name){
        List<Person> persons = personRepository.getUserByName(name);

        return new ResponseEntity<List<Person>>(persons,HttpStatus.OK);

    }


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
        return new ResponseEntity<>("Person deleted with success!",HttpStatus.OK);
    }
}
