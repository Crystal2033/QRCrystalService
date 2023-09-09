package ru.crystal.qrservice.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.database.model.Person;
import ru.crystal.qrservice.service.PersonService;

import java.io.IOException;
import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@RestController
@Slf4j
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person add(@RequestPart("person") Person person, @RequestPart("image") MultipartFile file){
        try {
            person.setImage(file.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id){
        Optional<Person> optionalPerson = personService.getById(id);
        return optionalPerson.orElseThrow(() -> new EntityNotFoundException("Person not found exception"));
    }

    @PutMapping
    public Person update(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personService.deleteById(id);
    }
}
