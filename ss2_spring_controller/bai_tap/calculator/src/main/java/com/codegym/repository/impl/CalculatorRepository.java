package com.codegym.repository.impl;

import com.codegym.repository.ICalculatorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
    Created by Trinh Khai
    Date: 30/03/2022
    Time: 15:02
*/
@Repository
public class CalculatorRepository implements ICalculatorRepository {

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
