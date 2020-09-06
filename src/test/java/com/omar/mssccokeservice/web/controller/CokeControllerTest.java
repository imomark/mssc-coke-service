package com.omar.mssccokeservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omar.mssccokeservice.web.model.CokeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CokeController.class)
class CokeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void getCokeById() throws  Exception{
        mockMvc.perform(get("/api/v1/coke/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewCoke() throws Exception{
        CokeDto cokeDto = CokeDto.builder().build();
        String cokeDtoJson = objectMapper.writeValueAsString(cokeDto);

        mockMvc.perform(post("/api/v1/coke/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(cokeDtoJson))
        .andExpect(status().isCreated());
    }

    @Test
    void updateCokeById() throws Exception{
        CokeDto cokeDto = CokeDto.builder().build();
        String cokeDtoJson = objectMapper.writeValueAsString(cokeDto);
        mockMvc.perform(put("/api/v1/coke/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(cokeDtoJson))
                .andExpect(status().isNoContent());
    }
}