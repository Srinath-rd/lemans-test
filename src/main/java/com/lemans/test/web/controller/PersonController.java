package com.lemans.test.web.controller;

import com.lemans.test.web.model.Person;
import com.lemans.test.web.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {


  @Autowired
  PersonRepository personRepository;

  @GetMapping(path = "/person/{id}")
  public Person getPerson(@PathVariable long id) {

    Optional<Person> person = personRepository.findById(id);

    if(!person.isPresent()) {
      throw new IllegalArgumentException("id" + id);
    }
    return person.get();
  }

  @PutMapping(path = "/person/{id}")
  public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person person) {
    Optional<Person> personOptional = personRepository.findById(id);

    if (!personOptional.isPresent())
      return ResponseEntity.notFound().build();

    personRepository.save(person);

    return ResponseEntity.ok().build();
  }

  @DeleteMapping(path = "/person/{id}")
  public void deletePerson(@PathVariable long id) {
    personRepository.deleteById(id);
  }

  @PostMapping(path = "/person")
  public ResponseEntity<Person> AddPerson(@RequestBody Person person) {

    Person savedPerson = personRepository.save(person);
    return ResponseEntity.ok().body(savedPerson);

  }

}
