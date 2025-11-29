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
        when(calculatorService.add(2, 3)).thenReturn(5.0);

        mockMvc.perform(get("/api/sum?a=2&b=3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 5.0"));
    }

    @Test
    void subtractEndpointReturnsCorrectResult() throws Exception {
        when(calculatorService.subtract(9, 5)).thenReturn(4.0);

        mockMvc.perform(get("/api/sub?a=9&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 4.0"));
    }

    @Test
    void multiplyEndpointReturnsCorrectResult() throws Exception {
        when(calculatorService.multiply(4, 6)).thenReturn(24.0);

        mockMvc.perform(get("/api/mult?a=4&b=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 24.0"));
    }
}