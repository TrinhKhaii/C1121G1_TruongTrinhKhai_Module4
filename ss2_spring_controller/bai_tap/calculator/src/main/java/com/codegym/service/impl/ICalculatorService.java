package com.codegym.service.impl;
/*
    Created by Trinh Khai
    Date: 01/04/2022
    Time: 16:08
*/

import com.codegym.repository.ICalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICalculatorService implements com.codegym.service.ICalculatorService {
    @Autowired
    private ICalculatorRepository iCalculatorRepository;

    @Override
    public Double addition(Double a, Double b) {
        return iCalculatorRepository.addition(a, b);
    }

    @Override
    public Double subtraction(Double a, Double b) {
        return iCalculatorRepository.subtraction(a, b);
    }

    @Override
    public Double multiplication(Double a, Double b) {
        return iCalculatorRepository.multiplication(a, b);
    }

    @Override
    public Double division(Double a, Double b) {
        return iCalculatorRepository.multiplication(a, b);
    }
}
