package com.example.sliepniev.controller;

import com.example.sliepniev.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final CalculatorService calculatorService;

    private final String resultLabel = "Result";

    public HelloController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/sum")
    public String sum(@RequestParam double a, @RequestParam double b) {
        return resultLabel + calculatorService.add(a, b);
    }

    @GetMapping("/sub")
    public String subtract(@RequestParam double a, @RequestParam double b) {
        return resultLabel + calculatorService.subtract(a, b);
    }

    @GetMapping("/mult")
    public String multiply(@RequestParam double a, @RequestParam double b){
        return resultLabel + calculatorService.multiply(a, b);
    }

    @GetMapping("/instance-id")
    public String identity() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return "Host: " + addr.getHostName() + " | IP: " + addr.getHostAddress();
    }
}
