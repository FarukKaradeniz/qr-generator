package com.farukkaradeniz.qrgenerator.controller.model.request;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrColorEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.QrShape;
import lombok.Data;

@Data
public class CreateQrRequest {
    private String text;
    private String color = QrColorEnum.BLACK.getValue();
    private Byte[] image;
    @QrShape
    private String shape = QrShapeEnum.SQUARE.getValue();
}
