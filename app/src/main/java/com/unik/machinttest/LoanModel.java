package com.unik.machinttest;

public class LoanModel {
    String loanName;
    Double totalSale, totalIncentives,seekBarValue,calculatedValue;

    public LoanModel(String loanName, Double totalSale, Double totalIncentives, Double seekBarValue, Double calculatedValue) {
        this.loanName = loanName;
        this.totalSale = totalSale;
        this.totalIncentives = totalIncentives;
        this.seekBarValue = seekBarValue;
        this.calculatedValue = calculatedValue;
    }
}
