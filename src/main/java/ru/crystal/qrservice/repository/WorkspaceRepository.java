package ru.crystal.qrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crystal.qrservice.database.model.WorkSpace;

/**
 * @project QRService
 * ©Crystal2033
 * @date 29/11/2023
 */
@Repository
public interface WorkspaceRepository extends JpaRepository<WorkSpace, Long> {
}
