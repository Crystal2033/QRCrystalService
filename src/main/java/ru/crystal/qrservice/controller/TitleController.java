package ru.crystal.qrservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crystal.qrservice.database.model.Title;
import ru.crystal.qrservice.service.TitleService;

import java.util.List;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@RestController
@RequestMapping("/api/titles")
public class TitleController {
    private final TitleService titleService;

    @Autowired
    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    public List<Title> getTitles() {
        return titleService.getTitles();
    }
}
