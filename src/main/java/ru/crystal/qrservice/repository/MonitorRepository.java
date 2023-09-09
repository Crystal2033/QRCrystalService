package ru.crystal.qrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crystal.qrservice.database.model.Monitor;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {
}
