package com.lalitha;

public class ConversionOperation {
    public static boolean validateInput(double amount){
        if(amount < 0.00){
            System.out.println("Enter valid Amount");
            return false;
        }
        return true;
    }

    public static double convertSekToUsd(double amount) {
        return amount * ExchangeRates.SEK_to_USD;
    }

    public static double convertUsdToSek(double amount) {
        return amount * ExchangeRates.USD_to_SEK;
    }

    public static double convertSekToEur(double amount) {
        return amount * ExchangeRates.SEK_to_EUR;
    }

    public static double convertEurToSek(double amount) {
        return amount * ExchangeRates.EUR_to_SEK;
    }

}
