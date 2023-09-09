package ru.crystal.qrservice.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.database.model.Keyboard;
import ru.crystal.qrservice.service.KeyboardService;

import java.io.IOException;
import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@RestController
@Slf4j
@RequestMapping("/api/keyboards")
public class KeyboardController {

    private final KeyboardService keyboardService;

    @Autowired
    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @PostMapping
    public Keyboard add(@RequestPart("keyboard") Keyboard keyboard, @RequestPart("image") MultipartFile image){
        try {
            keyboard.setImage(image.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return keyboardService.addKeyboard(keyboard);
    }

    @GetMapping("/{id}")
    public Keyboard getById(@PathVariable Long id){
        Optional<Keyboard> optionalKeyboard = keyboardService.getById(id);
        return optionalKeyboard.orElseThrow(() -> new EntityNotFoundException("Keyboard not found exception"));
    }

    @PutMapping
    public Keyboard update(@RequestBody Keyboard keyboard){
        return keyboardService.addKeyboard(keyboard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        keyboardService.deleteById(id);
    }
}
