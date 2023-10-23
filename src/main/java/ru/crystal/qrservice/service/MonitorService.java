package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Monitor;
import ru.crystal.qrservice.exception.ResourceNotFoundException;
import ru.crystal.qrservice.repository.MonitorRepository;

import java.io.IOException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
@Slf4j
public class MonitorService {
    private final MonitorRepository monitorRepository;
    private final QRCodeService qrCodeService;

    @Autowired
    public MonitorService(MonitorRepository monitorRepository, QRCodeService qrCodeService) {
        this.monitorRepository = monitorRepository;
        this.qrCodeService = qrCodeService;
    }

    public Monitor addMonitor(Monitor monitor) { //TODO: add spring AOP
        monitorRepository.save(monitor);
        try {
            qrCodeService.createQRCode(monitor);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return monitor;
    }

    public Monitor getById(Long id) {
        log.info("Trying to get monitor with id:" + id);
        Monitor monitor = monitorRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Monitor with id=" + id + " not found."));
        log.info("We have got monitor with id:" + id);
        return monitor;
    }

    public void deleteById(Long id) {
        try {
            monitorRepository.deleteById(id);
        } catch (Exception e) {
            log.error("impossible to delete not exising monitor with id:" + id);
        }

    }


}
