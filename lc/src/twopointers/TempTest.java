package twopointers;


import java.util.Scanner;

public class TempTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Loan 1
        System.out.print("Enter the principal balance for Loan 1: ");
        double principal1 = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in %) for Loan 1: ");
        double rate1 = scanner.nextDouble() / 100;
        System.out.print("Enter the remaining tenure (in months) for Loan 1: ");
        int tenure1 = scanner.nextInt();

        // Input for Loan 2
        System.out.print("Enter the principal balance for Loan 2: ");
        double principal2 = scanner.nextDouble();
        System.out.print("Enter the annual interest rate (in %) for Loan 2: ");
        double rate2 = scanner.nextDouble() / 100;
        System.out.print("Enter the remaining tenure (in months) for Loan 2: ");
        int tenure2 = scanner.nextInt();

        // Input for additional principal payment
        System.out.print("Enter the additional principal payment amount: ");
        double additionalPayment = scanner.nextDouble();

        // Calculate interest saving ratios
        double interestSavingRatio1 = rate1 / tenure1;
        double interestSavingRatio2 = rate2 / tenure2;

        // Calculate total of the ratios
        double totalRatio = interestSavingRatio1 + interestSavingRatio2;

        // Calculate proportionate payment amounts
        double paymentForLoan1 = additionalPayment * (interestSavingRatio1 / totalRatio);
        double paymentForLoan2 = additionalPayment * (interestSavingRatio2 / totalRatio);

        // Display the results
        System.out.printf("Amount to be paid towards Loan 1: %.2f\n", paymentForLoan1);
        System.out.printf("Amount to be paid towards Loan 2: %.2f\n", paymentForLoan2);

        scanner.close();
    }
}
