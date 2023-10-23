package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.crystal.qrservice.database.model.Keyboard;
import ru.crystal.qrservice.repository.KeyboardRepository;

import java.io.IOException;

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

    public Keyboard addKeyboard(Keyboard keyboard) {
        keyboardRepository.save(keyboard);
        log.info("Trying to add new keyboard with model: {}...", keyboard.getModel());
        try {
            qrCodeService.createQRCode(keyboard);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        log.info("Keyboard with model: {} has been saved.", keyboard.getModel());
        return keyboard;
    }

    public Keyboard getById(Long id) {
        return keyboardRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        try {
            keyboardRepository.deleteById(id);
        } catch (Exception e) {
            log.error("impossible to delete not exising keyboard with id:" + id);
        }

    }


}
