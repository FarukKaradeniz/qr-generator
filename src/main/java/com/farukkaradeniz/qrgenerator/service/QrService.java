package com.farukkaradeniz.qrgenerator.service;

import com.farukkaradeniz.qrgenerator.data.constant.QrConstants;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrRequestDTO;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrResponseDTO;
import com.farukkaradeniz.qrgenerator.data.exception.QrException;
import com.farukkaradeniz.qrgenerator.util.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class QrService {


    public CreateQrResponseDTO createQrCode(CreateQrRequestDTO request) {
        log.info("Create QR Request {}", request.getText());

        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            // Set Error Correction Level (30%)
            var hints = Map.of(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            var bitMatrix = qrCodeWriter.encode(request.getText(), BarcodeFormat.QR_CODE,
                    request.getQrSize(), request.getQrSize(), hints);

            // Set QR code colors config
            var config = new MatrixToImageConfig(Utils.parseColorHexInteger(request.getColor()),
                    Utils.parseColorHexInteger(request.getBackgroundColor()));

            var qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
            qrImage = setOverlayImage(request, qrImage);
            ImageIO.write(qrImage, QrConstants.QR_IMAGE_FORMAT, outputStream);
            byte[] bytes = outputStream.toByteArray();

            return CreateQrResponseDTO.builder()
                    .body(bytes)
                    .build();
        } catch (Exception e) {
            log.error("Create QR Request Error: {}", e.getMessage());
            throw new QrException(QrConstants.QR_CREATE_EXCEPTION_MESSAGE);
        }
    }

    private BufferedImage setOverlayImage(CreateQrRequestDTO requestDTO, BufferedImage qrImage) throws IOException {
        if (requestDTO.getImage() == null || requestDTO.getImage().length == 0) {
            return qrImage;
        }

        // Resize Overlay Image
        var size = requestDTO.getOverlayImageSize();
        var resizedImage = resizeOverlayImage(requestDTO.getImage(), size, size);
        resizedImage = scaleOverlay(resizedImage, size, size);

        var deltaHeight = qrImage.getHeight() - resizedImage.getHeight();
        var deltaWidth = qrImage.getWidth() - resizedImage.getWidth();

        BufferedImage combined = new BufferedImage(qrImage.getWidth(), qrImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) combined.getGraphics();
        g2.drawImage(qrImage, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.drawImage(resizedImage, Math.round(deltaWidth / 2f), Math.round(deltaHeight / 2f), null);

        return combined;
    }

    private BufferedImage resizeOverlayImage(byte[] imageData, int desiredWidth, int desiredHeight) throws IOException {
        var image = ImageIO.read(new ByteArrayInputStream(imageData));
        var resultingImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_DEFAULT);
        var outputImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    private BufferedImage scaleOverlay(BufferedImage overlay, int scaledWidth, int scaledHeight) {
        BufferedImage imageBuff = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = imageBuff.createGraphics();
        g.drawImage(overlay.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, new Color(0, 0, 0), null);
        g.dispose();

        return imageBuff;
    }

}
