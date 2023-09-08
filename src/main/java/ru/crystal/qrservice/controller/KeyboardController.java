package ru.crystal.qrservice.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.model.Keyboard;
import ru.crystal.qrservice.model.Person;
import ru.crystal.qrservice.service.KeyboardService;
import ru.crystal.qrservice.service.PersonService;

import java.io.IOException;
import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Controller
@RequestMapping("/api/keyboards")
public class KeyboardController {

    private final KeyboardService keyboardService;

    @Autowired
    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @PostMapping
    public Keyboard add(@RequestPart("keyboard") Keyboard keyboard, @RequestPart("file") MultipartFile image){
        try {
            keyboard.setImage(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return keyboardService.addPerson(keyboard);
    }

    @GetMapping("/{id}")
    public Keyboard getById(@PathVariable Long id){
        Optional<Keyboard> optionalPerson = keyboardService.getById(id);
        return optionalPerson.orElseThrow(() -> new EntityNotFoundException("Keyboard not found exception"));
    }

    @PutMapping
    public Keyboard update(@RequestBody Keyboard keyboard){
        return keyboardService.addPerson(keyboard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        keyboardService.deleteById(id);
    }
}
