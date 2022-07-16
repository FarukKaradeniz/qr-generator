package com.farukkaradeniz.qrgenerator.data.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CreateQrResponseDTO {
    private byte[] body;
}
