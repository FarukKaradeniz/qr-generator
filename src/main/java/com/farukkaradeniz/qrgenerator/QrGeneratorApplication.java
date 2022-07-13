package com.farukkaradeniz.qrgenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class QrGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrGeneratorApplication.class, args);
    }

}
