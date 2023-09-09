package ru.crystal.qrservice.service;

import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

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
}
