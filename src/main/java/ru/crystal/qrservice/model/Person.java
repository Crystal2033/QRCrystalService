package ru.crystal.qrservice.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Department department;

    @ManyToOne
    private JobTitle title;

    private String firstName;

    private String secondName;

    @Lob
    private byte[] image;

    @ManyToOne
    private WorkSpace workSpace;
}
