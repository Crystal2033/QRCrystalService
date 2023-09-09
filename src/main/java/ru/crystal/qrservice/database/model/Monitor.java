package ru.crystal.qrservice.database.model;

import jakarta.persistence.*;
import lombok.Data;
import org.json.JSONObject;
import ru.crystal.qrservice.database.options.JSONifyierForQR;
import ru.crystal.qrservice.database.options.DataBaseTableNames;

import java.sql.Date;

/**
 * @project QRService
 * ©Crystal2033
 * @date 07/09/2023
 */
@Entity
@Data
@Table(name = DataBaseTableNames.MONITOR_DB_TABLE_NAME)
public class Monitor implements JSONifyierForQR {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    @Lob
    private byte[] image;

    private Date startUseDate;

    @ManyToOne
    private WorkSpace workSpace;

    @Override
    public String getJSONDataForQR() {
        JSONObject jsonForQR = new JSONObject();
        jsonForQR.put(JSONifyierForQR.JSON_TABLE_NAME, DataBaseTableNames.MONITOR_DB_TABLE_NAME);
        jsonForQR.put(JSONifyierForQR.JSON_ID, this.id);
        return jsonForQR.toString();
    }
}
