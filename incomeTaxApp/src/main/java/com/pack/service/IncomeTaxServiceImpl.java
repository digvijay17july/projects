package com.pack.service;

import org.springframework.stereotype.Service;

@Service
public class IncomeTaxServiceImpl implements IncomeTaxService {
    @Override
    public Double computeIncomeTax(double grossIncome, int age) {


        double incomeTax = getTaxPercent(grossIncome, age);
        double totalIncomeTax = incomeTax - creditTax > 0 ? incomeTax - creditTax : 0.0;
        return totalIncomeTax;
    }

}
