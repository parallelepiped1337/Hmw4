package app;

import java.util.Scanner;

class TaxCalculator {

    public double calculateTax(double income) {
        double tax = 0;

        if (income <= 10000) {
            tax = income * 0.025;
        } else if (income <= 25000) {
            tax = (10000 * 0.025) + ((income - 10000) * 0.043);
        } else {
            tax = (10000 * 0.025) + (15000 * 0.043) + ((income - 25000) * 0.067);
        }

        return tax;

    }

}

class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double income = getIncome(scanner);

        TaxCalculator taxCalculator = new TaxCalculator();
        double tax = taxCalculator.calculateTax(income);

        displayTax(income, tax);
        scanner.close();

    }

    private static double getIncome(Scanner scanner) {
        System.out.print("Введіть суму доходу: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Будь ласка, введіть дійсне число.");
            scanner.next();
        }

        return scanner.nextDouble();

    }

    private static void displayTax(double income, double tax) {
        System.out.printf("Сума податку від доходу %.2f становить: %.2f\n", income, tax);

    }

}