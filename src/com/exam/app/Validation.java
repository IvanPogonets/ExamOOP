package com.exam.app;

import java.util.Scanner;

public class Validation {

    public static String validateData(String input, Validator dataValidator) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            if (dataValidator.dataIsValid(input)) {
                return input;
            }
            dataValidator.printError();
            input = scanner.nextLine();
        }
    }


    public static class validateName implements Validator {
        @Override
        public boolean dataIsValid(String input) {
            return input.matches("[a-zA-Z\\s]+") && input.matches(".*\\S.*");
        }

        @Override
        public void printError() {
            System.out.println("Name must contain only characters and space");
        }

    }


    public static class validateIndustry implements Validator {

        public static void printIndustry() {
            for (Industry industry : Industry.values()) {
                System.out.println(industry.getName());
            }
        }

        @Override
        public boolean dataIsValid(String input) {
            try {
                Industry industry = Industry.valueOf(input.toUpperCase());
                return true;
            } catch (IllegalArgumentException e) {
            }
            return false;
        }

        @Override
        public void printError() {
            System.out.println("Enter an industry from list:");
            printIndustry();
        }
    }

    public static class validateRevenue implements Validator {

        @Override
        public boolean dataIsValid(String input) {
            return input.matches("\\d+\\.\\d{0,2}")
                    && Double.parseDouble(input) > 0
                    && Double.parseDouble(input) < 10000000;
        }

        @Override
        public void printError() {
            System.out.println("Revenue must contain a number above zero and less than 10 000 000.00");
            System.out.println("Enter revenue again");
        }
    }
}

