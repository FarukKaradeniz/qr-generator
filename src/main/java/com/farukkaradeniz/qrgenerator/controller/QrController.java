package com.farukkaradeniz.qrgenerator.controller;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.mapper.QrMapper;
import com.farukkaradeniz.qrgenerator.service.QrService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/qr")
public class QrController {

    private final QrService qrService;

    @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
    @Timed(value = "request_timer.createQr", description = "Time taken to create qr code")
    public ResponseEntity<byte[]> createQr(@Valid @RequestBody CreateQrRequest request) {
        var responseDTO = qrService.createQrCode(QrMapper.toCreateQrRequestDTO(request));
        return new ResponseEntity<>(QrMapper.toCreateQrResponse(responseDTO).getBody(), HttpStatus.CREATED);
    }

}
