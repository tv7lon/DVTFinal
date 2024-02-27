/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BACKEND;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author dhiyas
 */
public class CreditCardPayingScreenBACKEND {

    //CVV verification
    public static String checkCVV(String CVVNum) {
        //askdualkjshc
        String message = "";
        boolean isValidLength = false;
        boolean onlyNumbers = true;
        String numbers = "1234567890";

        //checks the length
        if (CVVNum.length() == 3) {
            //check only ints 
            isValidLength = true;
            for (int i = 0; i < CVVNum.length(); i++) {
                char currentChar = CVVNum.charAt(i);
                String currentCharStr = String.valueOf(currentChar);
                if (!numbers.contains(currentCharStr)) {
                    message = "No letters or special characters may be used.";
                    onlyNumbers = false;
                    break;
                }
            }
        } else {
            message = "CVVs may only have 3 numerical digits and cannot be blank.";

        }

        if (isValidLength && onlyNumbers) {
            message = "valid";
        }
        return message;
    }

    public static boolean hasOnlyNumbers(String amountStr) {
        boolean onlyNums = true, manyPeriods = false;

        String validChars = "0123456789.";
        int counter = 0;
        for (int i = 0; i < amountStr.length(); i++) {
            char currentChar = amountStr.charAt(i);
            String currentCharStr = String.valueOf(currentChar);
            if (!validChars.contains(currentCharStr)) {
                onlyNums = false;
                break;
            }
            if (currentCharStr.equals(".")) {
                counter++;
            }
            if (counter > 1) {
                manyPeriods = true;
            }
        }
        if (onlyNums == true && manyPeriods == false) {
            return true;
        } else {
            return false;
        }

    }

    public static Double convertToDouble(String amountStr) {
        Double amountDbb = Double.parseDouble(amountStr);
        return amountDbb;
    }

    public static String checkCardHolderName(String input) {
        String message = "";
        String letters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM ";
        boolean onlyLetters = false;
        boolean hasASpace = false;

//checks the LENGTH and that no other characters are entered
        if (input.length() > 3) {
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                String currentCharStr = String.valueOf(currentChar);

                if (!letters.contains(currentCharStr)) {
                    message = "No numbers or special characters may be used.";
                } else {
                    onlyLetters = true;
                }
                if (currentCharStr.equals(" ")) {
                    hasASpace = true;

                }
                if (onlyLetters && hasASpace) {
                    message = "valid";
                } else {
                    message = "This does not qualify as a valid cardholder name.";
                }
            }
        } else if (input.length() == 0) {
            message = "This is a required field and cannot be left blank.";
        } else {
            message = "This does not qualify as a valid cardholder name.";
        }

        return message;
    }

    public static LocalDate convertToDate(String date) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate expiryDate = LocalDate.parse(date, dtf);
        return expiryDate;
    }

    public static String isValidEmail(String email) {
        String message = "";
        boolean lettersValid = false, hasAtBeforePeriod = false;
        int atCounter = 0, spaceCounter = 0;
        int posOfAt = -1;
        int posOfPeriod = -1;
        //needs to be bigger than @ and dot
        //needs to have an @ then a dot somewhere after the @
        //can only have 1 @

        if (email.length() != 0) {
            //one @
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    atCounter = atCounter + 1;
                } else if (email.charAt(i) == ' ') {
                    spaceCounter = spaceCounter + 1;
                }
            }

            if (atCounter == 1 && spaceCounter == 0) {

                lettersValid = true;
            }
            //@ before .
            posOfAt = email.indexOf("@");
            posOfPeriod = email.lastIndexOf(".");
            if (posOfAt < posOfPeriod) {
                hasAtBeforePeriod = true;
            }

            if (lettersValid && hasAtBeforePeriod) {
                message = "valid";
            } else {
                message += "Email must be in the correct format. No email was sent.";
            }
        } else {
            message = "Please enter an email to send the receipt to.";
        }

        return message;
    }

    public static void printPayment(String cardHolderName, String cardNumber, LocalDate expiryDate, String CVV, double amount, String email) {
        System.out.println("\tPAYMENT:\n\nCard Holder Name: " + cardHolderName + "\nCard Number: **** **** **** " + cardNumber.substring(12, 16));
        System.out.println("Expiry date: " + expiryDate.getMonthValue() + "/" + expiryDate.getYear() + "\nCVV: " + CVV + "\nAmount: R" + amount + "\nEmail: " + email);
    }

    public static void printPayment(String cardHolderName, String cardNumber, LocalDate expiryDate, String CVV, double amount) {
        System.out.println("\tPAYMENT:\n\nCard Holder Name: " + cardHolderName + "\nCard Number: **** **** **** " + cardNumber.substring(12, 16));
        System.out.println("Expiry date: " + expiryDate.getMonthValue() + "/" + expiryDate.getYear() + "\nCVV: " + CVV + "\nAmount: R" + amount);

    }

    public static String checkCardNum(String cardNum) {
        //askdualkjshc
        String message = "";
        boolean isValidLength = false;
        boolean onlyNumbers = true;
        String numbers = "1234567890";

        //checks the length
        if (cardNum.length() == 16) {
            //check only ints 
            isValidLength = true;

            for (int i = 0; i < cardNum.length(); i++) {

                char currentChar = cardNum.charAt(i);
                String currentCharStr = String.valueOf(currentChar);
                if (!numbers.contains(currentCharStr)) {

                    message = "No letters, spaces or special characters may be used.";
                    onlyNumbers = false;
                    break;
                }
            }

        } else {
            message = "Card numbers may only have 16 numerical digits, no spaces.";

        }

        if (isValidLength && onlyNumbers) {
            message = "valid";
        }
        return message;
    }
}
