package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Person;
import ru.crystal.qrservice.exception.ResourceNotFoundException;
import ru.crystal.qrservice.repository.PersonRepository;

import java.io.IOException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;
    private final QRCodeService qrCodeService;

    @Autowired
    public PersonService(PersonRepository personRepository, QRCodeService qrCodeService) {
        this.personRepository = personRepository;
        this.qrCodeService = qrCodeService;
    }

    public Person addPerson(Person person) { //TODO: add spring AOP
        personRepository.save(person);
        try {
            qrCodeService.createQRCode(person);
        } catch (IOException e) {
            log.error("can not create file for saving qr code");
        }
        return person;
    }

    public Person getById(Long id) {
        log.info("Trying to get person with id:" + id);
        Person person = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Person with id=" + id + "not found")
        );
        log.info("We have got person with id:" + id);
        return person;
    }

    public void deleteById(Long id) {
        try {
            personRepository.deleteById(id);
        } catch (Exception e) {
            log.error("impossible to delete not exising person with id:" + id);
        }

    }

}
