package com.farukkaradeniz.qrgenerator.controller.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateQrResponse {
    private byte[] body;
}
