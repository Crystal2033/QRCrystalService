package ru.crystal.qrservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Date;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Table(name = "keyboard")
public class Keyboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String model;

    @Lob
    private byte[] image;

    private Date startUseDate;

    @ManyToOne
    private WorkSpace workSpace;
}
