package com.farukkaradeniz.qrgenerator.controller;

import com.farukkaradeniz.qrgenerator.controller.model.request.CreateQrRequest;
import com.farukkaradeniz.qrgenerator.controller.model.response.CreateQrResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/qr")
public class QrController {

    @PostMapping
    public ResponseEntity<CreateQrResponse> createQr(@RequestBody CreateQrRequest request) {
        log.info("Create QR Request {}", request);

        return ResponseEntity.ok(new CreateQrResponse("SUCCESS"));
    }

    @GetMapping
    public ResponseEntity<CreateQrResponse> getQr() {
        log.info("Get QR");

        return ResponseEntity.ok(new CreateQrResponse("SUCCESS"));
    }

}
