package ru.crystal.qrservice.database.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Data
@Table(name = "workSpace")
public class WorkSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
