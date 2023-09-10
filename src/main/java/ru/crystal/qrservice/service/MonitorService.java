package ru.crystal.qrservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Monitor;
import ru.crystal.qrservice.repository.MonitorRepository;

import java.io.IOException;
import java.util.Optional;

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

    public Optional<Monitor> getById(Long id) {
        return monitorRepository.findById(id);
    }

    public void deleteById(Long id) {
        monitorRepository.deleteById(id);
    }


}
