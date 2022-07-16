package com.farukkaradeniz.qrgenerator.service;

import com.farukkaradeniz.qrgenerator.data.constant.QrConstants;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrRequestDTO;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrResponseDTO;
import com.farukkaradeniz.qrgenerator.data.exception.QrException;
import com.farukkaradeniz.qrgenerator.util.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Slf4j
@Service
public class QrService {


    public CreateQrResponseDTO createQrCode(CreateQrRequestDTO request) {
        log.info("Create QR Request {}", request);

        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE, request.getQrSize(), request.getQrSize());

            // Set QR code colors config
            var config = new MatrixToImageConfig(Utils.parseColorHexInteger(request.getColor()),
                    Utils.parseColorHexInteger(request.getBackgroundColor()));

            MatrixToImageWriter.writeToStream(bitMatrix, QrConstants.QR_IMAGE_FORMAT, outputStream, config);
            byte[] bytes = outputStream.toByteArray();

            return CreateQrResponseDTO.builder()
                    .body(bytes)
                    .build();
        } catch (Exception e) {
            log.error("Create QR Request Error: {}", e.getMessage());
            throw new QrException(QrConstants.QR_CREATE_EXCEPTION_MESSAGE);
        }
    }


}
