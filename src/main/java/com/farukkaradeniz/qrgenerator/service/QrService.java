package com.farukkaradeniz.qrgenerator.service;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.util.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class QrService {

    @SneakyThrows
    public void createQrCode(CreateQrRequest request) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE, 150, 150);
        var outputStream = new ByteArrayOutputStream();


        var config = new MatrixToImageConfig(Utils.parseColorHexInteger(request.getColor()), Utils.parseColorHexInteger(request.getBackgroundColor())); // onColor kod rengi, offColor arkaplan rengi
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream, config);
        byte[] bytes = outputStream.toByteArray();

        Path path = FileSystems.getDefault().getPath("C:\\Users\\faruk\\Desktop\\test\\create.png");
        Files.write(path, bytes);
    }

    @SneakyThrows
    public void testQrCode(CreateQrRequest request) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE, 250, 250);
        // MatrixToImageWriter.toBufferedImage(bitMatrix);
        Path path = FileSystems.getDefault().getPath("C:\\Users\\faruk\\Desktop\\test\\qr.png");
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}
