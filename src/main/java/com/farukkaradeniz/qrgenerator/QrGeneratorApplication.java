package com.farukkaradeniz.qrgenerator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "QR Generator",
        version = "1.0",
        description = "This application generates a QR code with given parameters")
)
public class QrGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrGeneratorApplication.class, args);
    }

}
