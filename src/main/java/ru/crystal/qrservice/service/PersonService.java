package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Person;
import ru.crystal.qrservice.repository.PersonRepository;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Optional;

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

    public PersonService(PersonRepository personRepository, QRCodeService qrCodeService) {
        this.personRepository = personRepository;
        this.qrCodeService = qrCodeService;
    }

    public Person addPerson(Person person) {
        personRepository.save(person);
        try {
            createQRCode(person);
        } catch (IOException e) {
            log.error("can not create file for saving qr code");
        }
        return person;
    }

    public void createQRCode(Person person) throws IOException {
        BufferedImage image = qrCodeService.generateQRCodeImage(person.getJSONDataForQR());
        qrCodeService.saveQRCodeByPath(image, "D:\\Paul\\Programming\\Java\\QRCrystalService\\TestQRPhotos\\img.jpg");
    }
    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

}
