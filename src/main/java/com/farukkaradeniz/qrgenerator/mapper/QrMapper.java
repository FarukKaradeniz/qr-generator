package com.farukkaradeniz.qrgenerator.mapper;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.controller.model.response.CreateQrResponse;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrRequestDTO;
import com.farukkaradeniz.qrgenerator.data.dto.CreateQrResponseDTO;

import java.util.Base64;

public class QrMapper {
    public static CreateQrRequestDTO toCreateQrRequestDTO(CreateQrRequest request) {
        return CreateQrRequestDTO.builder()
                .text(request.getText())
                .color(request.getColor())
                .backgroundColor(request.getBackgroundColor())
                .image(request.getImage() != null ? Base64.getDecoder().decode(request.getImage()) : null)
                .shape(request.getShape())
                .size(request.getSize())
                .build();
    }

    public static CreateQrResponse toCreateQrResponse(CreateQrResponseDTO dto) {
        return CreateQrResponse.builder()
                .body(dto.getBody())
                .build();
    }
}
