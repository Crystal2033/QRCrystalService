package ru.crystal.qrservice.model;

import jakarta.persistence.*;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Department departmentId;

    @ManyToOne
    private JobTitle titleId;

    private String firstName;

    private String secondName;

    @Lob
    private byte[] image;

    @ManyToOne
    private WorkSpace workSpaceId;
}
