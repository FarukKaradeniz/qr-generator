package com.farukkaradeniz.qrgenerator.data.dto;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateQrRequestDTO {
    private String text;
    private String color;
    private String backgroundColor;
    private Byte[] image;
    private String shape;
    private String size;

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
