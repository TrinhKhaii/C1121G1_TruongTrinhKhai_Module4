package com.model.impl;

import com.model.ICurrencyService;
import org.springframework.stereotype.Service;

/*
    Created by Trinh Khai
    Date: 29/03/2022
    Time: 14:36
*/
@Service
public class CurrencyService implements ICurrencyService {

    @Override
    public Double converterToUSD(Double vnd,  Double exchangeRate) {
        return (vnd / exchangeRate);
    }
}
