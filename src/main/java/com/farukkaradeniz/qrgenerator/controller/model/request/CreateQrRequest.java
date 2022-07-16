package com.farukkaradeniz.qrgenerator.controller.model.request;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrColorEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Color;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Shape;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateQrRequest {
    private String text;

    @Color
    private String color = QrColorEnum.BLACK.getValue();

    @Color
    private String backgroundColor = QrColorEnum.WHITE.getValue();

    private Byte[] image;

    @Shape
    private String shape = QrShapeEnum.SQUARE.getValue();

    @Size
    private String size = QrSizeEnum.MEDIUM.getValue();
}
