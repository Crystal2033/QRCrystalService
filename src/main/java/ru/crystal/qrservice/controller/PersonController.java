package ru.crystal.qrservice.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.model.Person;
import ru.crystal.qrservice.service.PersonService;

import java.io.IOException;
import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Controller
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person add(@RequestPart("person") Person person, @RequestPart("file") MultipartFile file){
        try {
            person.setImage(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personService.addPerson(person);
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id){
        Optional<Person> optionalPerson = personService.getById(id);
        return optionalPerson.orElseThrow(() -> new EntityNotFoundException("Person not found exception"));
    }

    @PatchMapping
    public Person update(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personService.deleteById(id);
    }
}
