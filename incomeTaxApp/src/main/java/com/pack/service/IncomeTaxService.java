package com.pack.service;

public interface IncomeTaxService {
    Double educationCessPercent = 1.0;
    Double generalSalarySlabs[] = {250000.0, 500000.0, 1000000.0};
    Double seniorCitizenSalarySlabs[] = {300000.0, 500000.0, 1000000.0};
    Double standardDeduction = 50000.0;
    Double creditTax = 2500.0;

    enum Category {SENIOR_CITIZEN, GENERAL;}

    Double computeIncomeTax(final double grossIncome, final int age);

    default Double educationCess(final Double grossSalary) {
        Double calculatedCess = 0.0;
        calculatedCess = (grossSalary * educationCessPercent) / 100;
        return calculatedCess;
    }

    default Category getCategory(final int age) {

        return age < 60 ? Category.GENERAL : Category.SENIOR_CITIZEN;
    }

    default Double getTaxPercent(final double grossIncome, final int age) {
        Category category = getCategory(age);
        double netIncome = grossIncome - educationCess(grossIncome) - standardDeduction;
        if (category == Category.GENERAL) {

            return netIncome <= generalSalarySlabs[0] ? calculateTax(netIncome, 0.0, generalSalarySlabs) : netIncome <= generalSalarySlabs[1] ? calculateTax(netIncome, 5.0, generalSalarySlabs) : netIncome <= generalSalarySlabs[2] ? calculateTax(netIncome, 20.0, generalSalarySlabs) : calculateTax(netIncome, 20.0, generalSalarySlabs);


        } else {

            return netIncome <= seniorCitizenSalarySlabs[0] ? calculateTax(netIncome, 0.0, seniorCitizenSalarySlabs) : netIncome <= seniorCitizenSalarySlabs[1] ? calculateTax(netIncome, 5.0, seniorCitizenSalarySlabs) : netIncome <= seniorCitizenSalarySlabs[2] ? calculateTax(netIncome, 20.0, seniorCitizenSalarySlabs) : calculateTax(netIncome, 20.0, seniorCitizenSalarySlabs);
        }
    }

    default double calculateTax(final double netIncome, final double taxPercent, final Double taxSlabs[]) {
        double totalTax = 0.0;
        if (taxPercent == 5.0) {
            totalTax = (Math.abs(netIncome - taxSlabs[0]) * taxPercent) / 100;
        } else if (taxPercent == 20.0) {
            totalTax = Math.abs(((Math.abs(netIncome - taxSlabs[0]) * 5.0) + (Math.abs(netIncome - taxSlabs[0] - taxSlabs[1]) * 20.0)) / 100);
        }
        return totalTax;
    }
}
