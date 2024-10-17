package com.lalitha;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// input and output and perform operations
public class CurrencyUI {
    Scanner input = new Scanner(System.in);
    double inputAmt;
    double outputAmt;

    public void displayMenu() {
        System.out.println("Currency Converter App:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert USD to SEK");
        System.out.println("3. Convert SEK to Euro");
        System.out.println("4. Convert Euro to SEK");
        System.out.println("0. Exit");
        System.out.println("Enter your choice:");
        getInput();
    }

    public void getInput() {

        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter amount in SEK");
                inputAmt = getInputAmount();
                if(ConversionOperation.validateInput(inputAmt)) {
                    outputAmt = ConversionOperation.convertSekToUsd(inputAmt);
                    formatOutput(inputAmt, outputAmt, "SEK", "USD");
                }
                break;
            case 2:
                System.out.println("Enter amount in USD");
                inputAmt = getInputAmount();
                outputAmt = ConversionOperation.convertUsdToSek(inputAmt);
                formatOutput(inputAmt,outputAmt,"USD","SEK");
                break;
            case 3:
                System.out.println("Enter amount in SEK");
                inputAmt = getInputAmount();
                outputAmt = ConversionOperation.convertSekToEur(inputAmt);
                formatOutput(inputAmt,outputAmt,"SEK","EUR");
                break;
            case 4:
                System.out.println("Enter amount in Euro");
                inputAmt = getInputAmount();
                outputAmt = ConversionOperation.convertEurToSek(inputAmt);
                formatOutput(inputAmt,outputAmt,"EUR","SEK");
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
            return -1;
        }

        return inputAmt;
    }

    public void formatOutput(double inputAmt, double outputAmt, String fromCrncy, String toCrncy){
        LocalDateTime localDateTime = LocalDateTime.now();
        String dateTime = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));

        DecimalFormat formatter = new DecimalFormat("#,##0.00");
        BigDecimal outAmt = new BigDecimal(String.valueOf(outputAmt));
        String outAmtStr = formatter.format(outAmt);

        System.out.println(fromCrncy+" "+inputAmt +" = "+toCrncy+" "+outAmtStr +" at "+ dateTime);
    }


}
