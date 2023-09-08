package ru.crystal.qrservice.service;

import org.springframework.stereotype.Service;
import ru.crystal.qrservice.model.Person;
import ru.crystal.qrservice.repository.PersonRepository;

import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public Optional<Person> getById(Long id){
        return personRepository.findById(id);
    }

    public void deleteById(Long id){
        personRepository.deleteById(id);
    }

}
