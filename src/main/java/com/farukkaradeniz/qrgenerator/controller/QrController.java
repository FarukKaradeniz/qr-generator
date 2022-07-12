package com.farukkaradeniz.qrgenerator.controller;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.controller.model.response.CreateQrResponse;
import com.farukkaradeniz.qrgenerator.service.QrService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/qr")
public class QrController {

    private final QrService qrService;

    @PostMapping
    public ResponseEntity<CreateQrResponse> createQr(@Valid @RequestBody CreateQrRequest request) {
        log.info("Create QR Request {}", request);
        qrService.createQrCode(request);

        return ResponseEntity.ok(new CreateQrResponse("SUCCESS"));
    }

    @GetMapping
    public ResponseEntity<CreateQrResponse> getQr() {
        log.info("Get QR");

        CreateQrRequest request = new CreateQrRequest();
        request.setText("farukkaradeniz.com");
        qrService.testQrCode(request);

        return ResponseEntity.ok(new CreateQrResponse("SUCCESS"));
    }

}
