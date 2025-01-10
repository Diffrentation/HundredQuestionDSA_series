package HundredQuestionDSA_series;

import java.util.Scanner;

public class _1Pelindrome {

    // Method to check if a given string is a palindrome
    public boolean isPelindrome(String str) {
        // Validate the input string for null or empty value
        if (str == null || str.isEmpty()) {
            return false;
        }

        int left = 0; // Initialize left pointer at the start of the string
        int right = str.length() - 1; // Initialize right pointer at the end of the string

        // Compare characters while moving pointers toward the center
        while (left < right) {
            // If characters at left and right pointers are not the same, it's not a palindrome
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;  // Increment the left pointer
            right--; // Decrement the right pointer
        }
        return true; // If all characters matched, it's a palindrome
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner for user input
        _1Pelindrome pelindrome = new _1Pelindrome(); // Create an instance of the class

        System.out.println("Enter the string:");
        String str = sc.nextLine(); // Read user input

        boolean isPalindrome = pelindrome.isPelindrome(str); // Check if the string is a palindrome

        // Output the result
        if (isPalindrome) {
            System.out.println(str + " is a palindrome string.");
        } else {
            System.out.println(str + " is not a palindrome string.");
        }

        sc.close(); // Close the scanner to release resources
    }
}
