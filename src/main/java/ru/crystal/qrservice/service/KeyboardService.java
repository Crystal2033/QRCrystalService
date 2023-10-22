package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.crystal.qrservice.database.model.Keyboard;
import ru.crystal.qrservice.exception.ResourceNotFoundException;
import ru.crystal.qrservice.repository.KeyboardRepository;

import java.io.IOException;
import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
@Slf4j
public class KeyboardService {

    private final KeyboardRepository keyboardRepository;
    private final QRCodeService qrCodeService;
    @Autowired
    public KeyboardService(KeyboardRepository keyboardRepository, QRCodeService qrCodeService) {
        this.keyboardRepository = keyboardRepository;
        this.qrCodeService = qrCodeService;
    }

    public Keyboard addKeyboard(Keyboard keyboard) { //TODO: add spring AOP
        keyboardRepository.save(keyboard);

        try {
            qrCodeService.createQRCode(keyboard);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return keyboard;
    }

    public Keyboard getById(Long id) {
        return keyboardRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Keyboard with id=" + id + " not found.")
        );
    }

    public void deleteById(Long id) {
        keyboardRepository.deleteById(id);
    }


}
