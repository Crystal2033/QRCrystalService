package ru.crystal.qrservice.database.options;

import org.json.JSONObject;

/**
 * @project QRService
 * ©Crystal2033
 * @date 09/09/2023
 */
public interface JSONifyierForQR {

    JSONObject jsonObjectForQR = new JSONObject();
    String JSON_TABLE_NAME = "tableName";
    String JSON_ID = "id";
    String getJSONDataForQR();
}
