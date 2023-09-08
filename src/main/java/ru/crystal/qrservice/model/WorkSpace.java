package ru.crystal.qrservice.model;

import jakarta.persistence.*;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Table(name = "workSpace")
public class WorkSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
