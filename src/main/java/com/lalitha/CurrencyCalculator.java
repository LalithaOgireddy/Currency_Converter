package com.lalitha;

import java.util.Scanner;

public class CurrencyCalculator {
    double inputAmt;
    double outputAmt;
    Scanner input = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("Currency Converter App:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
        getInput();
    }

    public void getInput(){

        int choice = input.nextInt();
        double excRate;
        switch(choice){
            case 1:
                System.out.println("Enter amount in SEK");
                excRate = ExchangeRates.SEK_to_USD;
                inputAmt = getInputAmount();
                exchangeCalculation(excRate,inputAmt);
                break;
            case 2:
                System.out.println("Enter amount in USD");
                excRate = ExchangeRates.USD_to_SEK;
                inputAmt = getInputAmount();
                exchangeCalculation(excRate,inputAmt);
                break;
            case 3:
                System.out.println("Enter amount in SEK");
                excRate = ExchangeRates.SEK_to_EUR;
                inputAmt = getInputAmount();
                exchangeCalculation(excRate,inputAmt);
                break;
            case 4:
                System.out.println("Enter amount in Euro");
                excRate = ExchangeRates.EUR_to_SEK;
                inputAmt = getInputAmount();
                exchangeCalculation(excRate,inputAmt);
                break;
            case 0:
                break;
            default:
                System.out.println("Enter valid input choice");
        }
    }

    public double getInputAmount() {
        try {
            inputAmt = input.nextDouble();
        } catch(Exception e) {
            System.out.println("Enter valid Amount");
        }
        return inputAmt;
    }

    public boolean validateInput(double inputAmt){
        if(inputAmt < 0.00){
            System.out.println("negative");
            return false;
        }
        return true;
    }

    public void exchangeCalculation(double rate, double inputAmt){
        if(validateInput(inputAmt)){
            outputAmt = inputAmt * rate;
            System.out.println(outputAmt);
        } else System.out.println("Amount should not be negative");
    }
}
