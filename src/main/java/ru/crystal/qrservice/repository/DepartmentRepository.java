package ru.crystal.qrservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.crystal.qrservice.database.model.Department;

/**
 * @project QRService
 * ©Crystal2033
 * @date 26/11/2023
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
