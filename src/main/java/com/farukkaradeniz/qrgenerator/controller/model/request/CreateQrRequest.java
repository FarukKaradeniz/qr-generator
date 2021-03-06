package com.farukkaradeniz.qrgenerator.controller.model.request;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrColorEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Color;
import com.farukkaradeniz.qrgenerator.data.enumeration.annotation.Size;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateQrRequest {
    @NotNull
    @javax.validation.constraints.Size(max = 3096, min = 1)
    private String text;

    @Color
    private String color = QrColorEnum.BLACK.getValue();

    @Color
    private String backgroundColor = QrColorEnum.WHITE.getValue();

    private String image; // Base64 Image

    @Size
    private String size = QrSizeEnum.MEDIUM.getValue();
}
