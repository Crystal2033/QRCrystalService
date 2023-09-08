package ru.crystal.qrservice.service;

import org.springframework.stereotype.Service;
import ru.crystal.qrservice.model.Keyboard;
import ru.crystal.qrservice.model.Person;
import ru.crystal.qrservice.repository.KeyboardRepository;
import ru.crystal.qrservice.repository.PersonRepository;

import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
public class KeyboardService {
    private final KeyboardRepository keyboardRepository;

    public KeyboardService(KeyboardRepository keyboardRepository) {
        this.keyboardRepository = keyboardRepository;
    }

    public Keyboard addKeyboard(Keyboard keyboard){
        return keyboardRepository.save(keyboard);
    }

    public Optional<Keyboard> getById(Long id){
        return keyboardRepository.findById(id);
    }

    public void deleteById(Long id){
        keyboardRepository.deleteById(id);
    }
}
