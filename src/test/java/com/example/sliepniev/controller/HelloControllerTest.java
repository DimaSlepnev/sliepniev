package com.example.sliepniev.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.example.sliepniev.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void helloEndpointReturnsDefaultMessage() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    void sumEndpointReturnsCorrectResult() throws Exception {
        when(calculatorService.add(2, 3)).thenReturn(5);

        mockMvc.perform(get("/api/sum?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 5"));
    }
}