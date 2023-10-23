package ru.crystal.qrservice.controller;

import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.database.model.Keyboard;
import ru.crystal.qrservice.service.KeyboardService;

import java.io.IOException;

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

    @Value("${hostname}")
    private String hostname;

    @Autowired
    public KeyboardController(KeyboardService keyboardService) {
        this.keyboardService = keyboardService;
    }

    @PostMapping
    public Keyboard addMultipart(@RequestPart("keyboard") Keyboard keyboard, @RequestPart("image") @NotNull MultipartFile image) {
        try {
            keyboard.setImage(image.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return keyboardService.addKeyboard(keyboard);
    }

//    @PostMapping
//    public Keyboard add(@RequestBody Keyboard keyboard) {
//        return keyboardService.addKeyboard(keyboard);
//    }

    @GetMapping("/{id}")
    public Keyboard getById(@PathVariable Long id) {
        return keyboardService.getById(id);
    }

    @PutMapping
    public Keyboard update(@RequestBody Keyboard keyboard) {
        return keyboardService.addKeyboard(keyboard);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        keyboardService.deleteById(id);
    }
}
