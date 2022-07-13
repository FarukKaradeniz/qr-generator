package com.farukkaradeniz.qrgenerator.service;

import com.farukkaradeniz.qrgenerator.data.constant.QrConstants;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrRequestDTO;
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
    public void createQrCode(CreateQrRequestDTO request) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE, request.getQrSize(), request.getQrSize());
        var outputStream = new ByteArrayOutputStream();

        var config = new MatrixToImageConfig(Utils.parseColorHexInteger(request.getColor()),
                Utils.parseColorHexInteger(request.getBackgroundColor()));

        MatrixToImageWriter.writeToStream(bitMatrix, QrConstants.QR_IMAGE_FORMAT, outputStream, config);
        byte[] bytes = outputStream.toByteArray();

        Path path = FileSystems.getDefault().getPath("C:\\Users\\faruk\\Desktop\\test\\create.png");
        Files.write(path, bytes);
    }

    @SneakyThrows
    public void testQrCode(CreateQrRequestDTO request) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE, request.getQrSize(), request.getQrSize());

        // MatrixToImageWriter.toBufferedImage(bitMatrix);
        Path path = FileSystems.getDefault().getPath("C:\\Users\\faruk\\Desktop\\test\\qr.png");
        MatrixToImageWriter.writeToPath(bitMatrix, QrConstants.QR_IMAGE_FORMAT, path);
    }

}
