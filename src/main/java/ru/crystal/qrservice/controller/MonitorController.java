package ru.crystal.qrservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.crystal.qrservice.database.model.Monitor;
import ru.crystal.qrservice.service.MonitorService;

import java.io.IOException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@RestController
@Slf4j
@RequestMapping("/api/monitors")
public class MonitorController {
    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PostMapping
    public Monitor addMultipart(@RequestPart("monitor") Monitor monitor, @RequestPart("image") MultipartFile image) {
        try {
            monitor.setImage(image.getBytes());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return monitorService.addMonitor(monitor);
    }

//    @PostMapping
//    public Monitor add(@RequestBody Monitor monitor) {
//        return monitorService.addMonitor(monitor);
//    }

    @GetMapping("/{id}")
    public Monitor getById(@PathVariable Long id) {
        return monitorService.getById(id);
    }

    @PutMapping
    public Monitor update(@RequestBody Monitor monitor) {
        return monitorService.addMonitor(monitor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        monitorService.deleteById(id);
    }
}
