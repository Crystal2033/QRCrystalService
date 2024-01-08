package ru.crystal.qrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crystal.qrservice.database.model.Title;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
}
