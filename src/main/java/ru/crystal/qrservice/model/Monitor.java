package ru.crystal.qrservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Data
@Table(name = "monitor")
public class Monitor {
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
