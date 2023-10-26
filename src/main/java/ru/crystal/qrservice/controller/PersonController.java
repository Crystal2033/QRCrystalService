package ru.crystal.qrservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.database.model.Person;
import ru.crystal.qrservice.service.PersonService;

import java.io.IOException;

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
    public Person addMultipart(@RequestPart("person") Person person, @RequestPart("image") MultipartFile file) {
        try {
            person.setImage(file.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return personService.addPerson(person);
    }

//    @PostMapping
//    public Person add(@RequestBody Person person) {
//        return personService.addPerson(person);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getById(@PathVariable Long id) {
        Person person = personService.getById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.deleteById(id);
    }
}
