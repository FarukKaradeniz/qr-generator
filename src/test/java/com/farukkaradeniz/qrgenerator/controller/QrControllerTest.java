package com.farukkaradeniz.qrgenerator.controller;

import com.farukkaradeniz.qrgenerator.data.enumeration.QrSizeEnum;
import com.farukkaradeniz.qrgenerator.mapper.QrMapper;
import com.farukkaradeniz.qrgenerator.service.QrService;
import com.farukkaradeniz.qrgenerator.util.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QrController.class)
class QrControllerTest {

    @MockBean
    QrService qrService;
    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @ParameterizedTest
    @EnumSource(QrSizeEnum.class)
    void createQrCode_generatesResponse_withDifferentSizes(QrSizeEnum size) {
        var request = TestData.getSampleCreateQrRequest();
        request.setSize(size.getValue());

        Mockito.when(qrService.createQrCode(QrMapper.toCreateQrRequestDTO(request)))
                .thenReturn(TestData.getSampleCreateQrResponseDTO());

        var mvcRequest = MockMvcRequestBuilders.post("/api/v1/qr")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.IMAGE_PNG_VALUE);

        mockMvc.perform(mvcRequest)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.IMAGE_PNG_VALUE));

    }

    @SneakyThrows
    @Test
    void createQrCode_generatesResponse() {
        var request = TestData.getSampleCreateQrRequest();

        Mockito.when(qrService.createQrCode(QrMapper.toCreateQrRequestDTO(request)))
                .thenReturn(TestData.getSampleCreateQrResponseDTO());

        var mvcRequest = MockMvcRequestBuilders.post("/api/v1/qr")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.IMAGE_PNG_VALUE);

        mockMvc.perform(mvcRequest)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.IMAGE_PNG_VALUE));

    }

    @SneakyThrows
    @Test
    void createQrCode_generatesResponse_withOverlayImage() {
        var request = TestData.getSampleCreateQrRequest();
        request.setImage(Base64.getEncoder().encodeToString(new ClassPathResource("twitter-logo.jpg").getInputStream().readAllBytes()));

        Mockito.when(qrService.createQrCode(QrMapper.toCreateQrRequestDTO(request)))
                .thenReturn(TestData.getSampleCreateQrResponseDTO());

        var mvcRequest = MockMvcRequestBuilders.post("/api/v1/qr")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.IMAGE_PNG_VALUE);

        mockMvc.perform(mvcRequest)
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.IMAGE_PNG_VALUE));

    }

    @SneakyThrows
    private String asJsonString(Object o) {
        return new ObjectMapper().writeValueAsString(o);
    }

}
