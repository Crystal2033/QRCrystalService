package ru.crystal.qrservice.database.options;

/**
 * @project QRService
 * ©Crystal2033
 * @date 09/09/2023
 */
public interface JSONifyierForQR {
    String JSON_TABLE_NAME = "tableName";
    String JSON_ID = "id";
    String getJSONDataForQR();
}
