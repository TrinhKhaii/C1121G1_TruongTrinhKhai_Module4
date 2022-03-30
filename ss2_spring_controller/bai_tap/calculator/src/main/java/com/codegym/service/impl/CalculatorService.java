package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 15:02
*/
@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Double addition(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtraction(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiplication(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double division(Double a, Double b) {
        return a / b;
    }
}
