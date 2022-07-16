package com.farukkaradeniz.qrgenerator.util;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrRequestDTO;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrResponseDTO;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrColorEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;

public class TestData {
    public static final String DEFAULT_TEXT = "farukkaradeniz.com";

    public static CreateQrRequestDTO getSampleCreateQrRequestDTO() {
        return CreateQrRequestDTO.builder()
                .text(DEFAULT_TEXT)
                .color(QrColorEnum.BLACK.getValue())
                .backgroundColor(QrColorEnum.WHITE.getValue())
                .shape(QrShapeEnum.SQUARE.getValue())
                .size(QrSizeEnum.MEDIUM.getValue())
                .build();
    }

    public static CreateQrRequest getSampleCreateQrRequest() {
        var request = new CreateQrRequest();

        request.setText(DEFAULT_TEXT);
        request.setColor(QrColorEnum.BLACK.getValue());
        request.setBackgroundColor(QrColorEnum.WHITE.getValue());
        request.setShape(QrShapeEnum.SQUARE.getValue());
        request.setSize(QrSizeEnum.MEDIUM.getValue());
        request.setImage(null);

        return request;
    }

    public static CreateQrResponseDTO getSampleCreateQrResponseDTO() {
        return CreateQrResponseDTO.builder()
                .body(new byte[]{})
                .build();
    }
}
