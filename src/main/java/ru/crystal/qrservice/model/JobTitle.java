package ru.crystal.qrservice.model;

import jakarta.persistence.*;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Table(name = "jobTitle")
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
}
