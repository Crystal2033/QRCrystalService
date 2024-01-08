package ru.crystal.qrservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Title;
import ru.crystal.qrservice.repository.TitleRepository;

import java.util.List;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@Service
public class TitleService {
    private final TitleRepository titleRepository;

    @Autowired
    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public List<Title> getTitles(){
        return titleRepository.findAll();
    }
}
