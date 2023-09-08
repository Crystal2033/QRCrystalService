package ru.crystal.qrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crystal.qrservice.model.Keyboard;

/**
 * @project QRService
 * ©Crystal2033
 * @date 08/09/2023
 */
@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {
}
