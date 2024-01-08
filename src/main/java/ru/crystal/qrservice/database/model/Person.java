package ru.crystal.qrservice.database.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.crystal.qrservice.database.options.JSONifyierForQR;
import ru.crystal.qrservice.database.options.DataBaseTableNames;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Data
@Table(name = DataBaseTableNames.PERSON_DB_TABLE_NAME)
public class Person implements JSONifyierForQR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Department department;

    @ManyToOne
    private Title title;

    private String firstName;

    private String secondName;
    @Lob
    private byte[] image;

    @ManyToOne
    private WorkSpace workSpace;

    @Override
    public String getJSONDataForQR() {
        jsonObjectForQR.put(JSONifyierForQR.JSON_TABLE_NAME, DataBaseTableNames.PERSON_DB_TABLE_NAME);
        jsonObjectForQR.put(JSONifyierForQR.JSON_ID, this.id);
        return jsonObjectForQR.toString();
    }
}
