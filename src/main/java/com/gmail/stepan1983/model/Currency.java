package com.gmail.stepan1983.model;

public enum Currency {

    UAH(28.35), USD(1), EUR(0.87);

//    private double rate_UAH;

    private double rate_USD;

//    private double rate_EUR;

    Currency(double rate_USD) {
        this.rate_USD = rate_USD;
    }


    public double getRate_USD() {
        return rate_USD;
    }

    public void setRate_USD(double rate_USD) {
        this.rate_USD = rate_USD;
    }

}
