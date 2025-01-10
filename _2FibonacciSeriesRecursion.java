package HundredQuestionDSA_series;

import java.math.BigInteger;
import java.util.Scanner;

public class _2FibonacciSeriesRecursion {
    
    // Recursive method to calculate the nth Fibonacci number
    public static BigInteger calFib(int n) {
        // Base cases: Fibonacci of 0 is 0, and Fibonacci of 1 is 1
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }
        // Recursive calls for (n-1)th and (n-2)th Fibonacci numbers
        return calFib(n - 1).add(calFib(n - 2));
    }

    // Method to print the Fibonacci series up to n terms
    public static void printFib(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(calFib(i)); // Print each Fibonacci number
            if (i < n - 1) {
                System.out.print(", "); // Add a comma separator except after the last term
            }
        }
        System.out.println(); // Newline for better output formatting
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Prompt user for the number of terms
        System.out.print("Enter the number of terms to print in the Fibonacci series: ");
        int n = sc.nextInt();

        // Validate input
        if (n < 0) {
            System.out.println("Please enter a non-negative number.");
        } else {
            System.out.print("Fibonacci Series: ");
            printFib(n);
        }
        
        sc.close(); // Close the scanner to prevent resource leaks
    }
}
