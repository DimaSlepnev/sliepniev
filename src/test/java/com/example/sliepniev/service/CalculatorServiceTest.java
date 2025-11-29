package com.example.sliepniev.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void addTwoNumbers() {
        assertEquals(7, calculatorService.add(3, 4));
    }

    @Test
    void subtractTwoNumbers(){
        assertEquals(4, calculatorService.subtract(9,5));
    }

    @Test
    void multiplyTwoNumbers(){
        assertEquals(12, calculatorService.multiply(4,3));
    }
}