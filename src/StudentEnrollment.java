import java.util.Scanner;

public class StudentEnrollment {

    // Method to compute the total enrollment fee
    public static int computeEnrollmentFee(int units, int feePerUnit) {
        return units * feePerUnit;
    }

    public static void main(String[] args) {
        // Declare constants
        final int MAX_SUBJECTS = 10;
        final int FEE_PER_UNIT = 1000;

        // Create a Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Input student information
        System.out.print("Enter student name: ");
        String studentName = input.nextLine();

        System.out.print("Enter course name: ");
        String course = input.nextLine();

        System.out.print("Enter course code: ");
        String courseCode = input.nextLine();

        System.out.print("Enter number of units (Max 10): ");
        int units = input.nextInt();

        // Validate the number of units
        if (units > MAX_SUBJECTS || units <= 0) {
            System.out.println("Error: Invalid number of units. Please enter a value between 1 and 10.");
            input.close();
            return;
        }

        // Compute the total fee
        int totalFee = computeEnrollmentFee(units, FEE_PER_UNIT);

        // Output student's name and total enrollment fee
        System.out.println("\n--- Enrollment Summary ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Total Enrollment Fee: PHP " + totalFee);

        // Payment process
        System.out.print("\nEnter payment amount: ");
        int payment = input.nextInt();

        // Check the payment status
        if (payment == totalFee) {
            System.out.println("Fully Paid.");
        } else if (payment < totalFee && payment > 0) {
            System.out.println("Partial Payment. Amount paid: PHP " + payment);
            System.out.println("Remaining balance: PHP " + (totalFee - payment));
        } else if (payment > totalFee) {
            System.out.println("Overpaid. You have paid PHP " + (payment - totalFee) + " more than required.");
        } else {
            System.out.println("Error: Invalid payment amount.");
        }

        // Close the scanner
        input.close();
    }
}