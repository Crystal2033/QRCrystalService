package ru.crystal.qrservice.service;

import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.model.Monitor;
import ru.crystal.qrservice.repository.MonitorRepository;

import java.util.Optional;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Service
public class MonitorService {
    private final MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public Monitor addMonitor(Monitor monitor) {
        return monitorRepository.save(monitor);
    }

    public Optional<Monitor> getById(Long id) {
        return monitorRepository.findById(id);
    }

    public void deleteById(Long id) {
        monitorRepository.deleteById(id);
    }


}
