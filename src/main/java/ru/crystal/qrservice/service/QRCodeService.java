package ru.crystal.qrservice.service;

import net.glxn.qrgen.javase.QRCode;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import ru.crystal.qrservice.database.options.JSONifyierForQR;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @project QRService
 * ©Crystal2033
 * @date 09/09/2023
 */
@Service
public class QRCodeService {

    public BufferedImage generateQRCodeImage(String jsonObjectForQR) throws IOException {
        ByteArrayOutputStream stream = QRCode
                .from(jsonObjectForQR)
                .withSize(250, 250)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());

        return ImageIO.read(bis);
    }

    public void saveQRCodeByPath(BufferedImage bufferedImage, String path) throws IOException {
        File outputfile = new File(path);
        ImageIO.write(bufferedImage, "jpg", outputfile);
    }

    public void createQRCode(JSONifyierForQR objectForQRCreation) throws IOException { //TODO: make return value to get QR code
        String qrData = objectForQRCreation.getJSONDataForQR();
        BufferedImage image = generateQRCodeImage(qrData);

        JSONObject json = new JSONObject(qrData);
        String tableName = json.getString(JSONifyierForQR.JSON_TABLE_NAME);
        int tableId = json.getInt(JSONifyierForQR.JSON_ID);

        saveQRCodeByPath(image, "D:\\Paul\\Programming\\Java\\QRCrystalService\\TestQRPhotos\\" + tableName + "-" + tableId + ".jpg");
    }
}
