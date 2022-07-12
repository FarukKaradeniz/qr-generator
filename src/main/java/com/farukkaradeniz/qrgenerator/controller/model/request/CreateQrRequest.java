package com.farukkaradeniz.qrgenerator.controller.model.request;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrColorEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrShapeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Color;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Shape;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Size;
import lombok.Data;

@Data
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

    // TODO DTO'da olacak bu size metodu
    public int getQrSize() {
        if (QrSizeEnum.SMALL.getValue().equals(size)) {
            return 150;
        } else if (QrSizeEnum.MEDIUM.getValue().equals(size)) {
            return 250;
        } else { // QrSizeEnum.LARGE
            return 400;
        }
    }
}
