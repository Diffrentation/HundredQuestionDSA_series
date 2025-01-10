package HundredQuestionDSA_series;

import java.util.Scanner;

public class _3PowerOfTwo {
    // Method to check if a number is a power of 2
    public static boolean powerOfTwo(int n) {
        // If the number is less than 1 or zero, it's not a power of 2
        if (n < 1) {
            return false;
        }

        // Loop to repeatedly divide the number by 2 while it is even
        while (n > 1) {
            if (n % 2 != 0) { // If n is not divisible by 2, it's not a power of 2
                return false;
            }
            n = n / 2; // Divide n by 2
        }

        // If the loop completes, the number is a power of 2
        return true;
    }

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner sc = new Scanner(System.in);
        
        // Prompt the user to enter a number
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        // Check if the number is a power of 2 using the powerOfTwo method
        boolean isPowerOf2 = powerOfTwo(n);

        // Display the result
        if (isPowerOf2) {
            System.out.println(n + " is a Power of 2");
        } else {
            System.out.println(n + " is NOT a Power of 2");
        }

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
