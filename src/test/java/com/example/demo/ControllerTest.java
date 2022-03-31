package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @ParameterizedTest
    @ValueSource(strings = {"097.296.660-91", "15070203096", "25067406003", "900.381.640-94", "98.835.455/0001-21", "80.623.345/0001-30"}) //
    void annotation_cpf_ok(String documento) throws Exception {

        ResultActions post = mockMvc.perform(MockMvcRequestBuilders.post("/teste")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(new CompradorRequest(documento))))
                .andExpect(status().isOk());
    }

    @ParameterizedTest
    @ValueSource(strings = { "250672401002","250671406001", "900.381..640-94", "9812.835.455/0001-21", "80.623.345//0001-30"}) //
    void annotation_cpf_bad_request(String documento) throws Exception {

        ResultActions post = mockMvc.perform(MockMvcRequestBuilders.post("/teste")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(new CompradorRequest(documento))))
                .andExpect(status().isBadRequest());
    }



    private String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }




}