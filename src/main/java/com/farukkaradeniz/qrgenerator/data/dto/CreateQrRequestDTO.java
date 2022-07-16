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
    private byte[] image;
    private String shape;
    private String size;

    public int getQrSize() {
        if (QrSizeEnum.SMALL.getValue().equals(size)) {
            return 200;
        } else if (QrSizeEnum.MEDIUM.getValue().equals(size)) {
            return 300;
        } else { // QrSizeEnum.LARGE
            return 400;
        }
    }

    public int getOverlayImageSize() {
        if (QrSizeEnum.SMALL.getValue().equals(size)) {
            return 50;
        } else if (QrSizeEnum.MEDIUM.getValue().equals(size)) {
            return 75;
        } else { // QrSizeEnum.LARGE
            return 90;
        }
    }
}
