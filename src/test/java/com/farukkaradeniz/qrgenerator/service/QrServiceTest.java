package com.farukkaradeniz.qrgenerator.service;

import com.farukkaradeniz.qrgenerator.data.constant.QrConstants;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.util.TestData;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class QrServiceTest {

    @InjectMocks
    QrService qrService;

    @SneakyThrows
    @ParameterizedTest
    @EnumSource(QrSizeEnum.class)
    public void createQrCode_generatesImage_withDifferentSizes(QrSizeEnum size) {
        var requestDTO = TestData.getSampleCreateQrRequestDTO();
        requestDTO.setSize(size.getValue());

        var responseDTO = qrService.createQrCode(requestDTO);

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getBody()).isNotNull().isNotEmpty();

        var result = readQrFromByteArray(responseDTO.getBody());

        assertThat(result.getText()).isEqualTo(requestDTO.getText());
        assertThat(result.getBarcodeFormat()).isEqualTo(BarcodeFormat.QR_CODE);
    }

    @SneakyThrows
    @ParameterizedTest
    @EnumSource(QrShapeEnum.class)
    public void createQrCode_generatesImage_withDifferentShapes(QrShapeEnum shape) {
        var requestDTO = TestData.getSampleCreateQrRequestDTO();
        requestDTO.setShape(shape.getValue());

        var responseDTO = qrService.createQrCode(requestDTO);

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getBody()).isNotNull().isNotEmpty();

        var result = readQrFromByteArray(responseDTO.getBody());

        assertThat(result.getText()).isEqualTo(requestDTO.getText());
        assertThat(result.getBarcodeFormat()).isEqualTo(BarcodeFormat.QR_CODE);
    }

    @SneakyThrows
    @Test
    public void createQrCode_generatesImage_withOverlayImage() {
        var requestDTO = TestData.getSampleCreateQrRequestDTO();
        requestDTO.setImage(new ClassPathResource("twitter-logo.jpg").getInputStream().readAllBytes());

        var responseDTO = qrService.createQrCode(requestDTO);

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getBody()).isNotNull().isNotEmpty();

        var result = readQrFromByteArray(responseDTO.getBody());

        assertThat(result.getText()).isEqualTo(requestDTO.getText());
        assertThat(result.getBarcodeFormat()).isEqualTo(BarcodeFormat.QR_CODE);
    }

    @Test
    public void createQrCode_throwsException() {
        var requestDTO = TestData.getSampleCreateQrRequestDTO();
        requestDTO.setColor(null);

        assertThatThrownBy(() -> qrService.createQrCode(requestDTO))
                .hasMessage(QrConstants.QR_CREATE_EXCEPTION_MESSAGE)
                .isInstanceOf(Exception.class);
    }

    @Test
    public void createQrCode_generatesResponse() {
        var requestDTO = TestData.getSampleCreateQrRequestDTO();

        var responseDTO = qrService.createQrCode(requestDTO);

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getBody()).isNotNull().isNotEmpty();
    }

    @SneakyThrows
    private Result readQrFromByteArray(byte[] input) {
        var binaryBitMap = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(ImageIO.read(new ByteArrayInputStream(input)))));
        return new MultiFormatReader().decode(binaryBitMap);
    }
}