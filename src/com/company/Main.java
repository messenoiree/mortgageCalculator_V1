package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;                                     // We declare a constant that holds the amount of months in a year.
        final byte PERCENT = 100;                                           // We declare a constant that holds the percentage.

        int principal = 0;                  // We need to declare these variables outside the loops, so we can use them everywhere.
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        Scanner scanner = new Scanner(System.in);       // We create a new scanner-object, that we will use to read the user input.

        while(true){                                                    // First, we get the Principal from the user.

            System.out.println("Principal: ");                          // We print this message to the user.
            principal = scanner.nextInt();                              // Our scanner reads the input from the user and stores the input in the variable "principal".

            if(principal >= 1000 && principal <= 1_000_000){            // IF the user input is greater than or equal to 1000 and less than or equal to 1000000...
                break;                                                  // Then we exit the loop, because the user input was valid.
            }

            System.out.println("Enter a value between 1000 and 1000000");   // Otherwise, we ask the user to try again.

        }

        while(true){                                                     // Second, we get the Annual Interest Rate from the user.

            System.out.println("Annual Interest Rate: ");               // We print this message to the user.
            float annualInterest = scanner.nextFloat();                 // Our scanner reads the input from the user and stores the input in the variable "annualInterest".

            if(annualInterest >= 1 && annualInterest <= 30){            // IF the user input is greater than or equal to 1 and less than or equal to 30...

                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;        // Then we calculate the monthly interest like this.
                break;                                                              // And then we jump out of this loop, because the user input was valid.
            }

            System.out.println("Enter a value between 1 and 30");                   // Otherwise, we ask the user to try again.

        }

        while(true){                                                        // Third, we get the Period (Years) from the user.

            System.out.println("Period (Years): ");                         // We print this message to the user.
            byte years = scanner.nextByte();                                // Our scanner reads the input from the user and stores the input in the variable "years".

            if(years >= 1 && years <= 30){                                  // IF the user input is greater than or equal to 1 and less than or equal to 30...

                numberOfPayments = years * MONTHS_IN_YEAR;                  // Then we calculate the number of payments like this.
                break;                                                      // And then we jump out of this loop, because the user input was valid.
            }

            System.out.println("Enter a value between 1 and 30");           // Otherwise, we ask the user to try again.
        }


        // Down here we use the information we gathered from the user to calculate the mortgage like this:

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);


        // Since we want the mortgage to be displayed in the correct currency (kr), we format the mortgage like this:

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);



    }
}
