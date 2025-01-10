package HundredQuestionDSA_series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _6ArraySum {
    // Method to add an integer `k` to the array-form of an integer represented by `nums`
    public static List<Integer> ArrSum(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(); // List to store the resulting array
        int carry = 0; // Carry variable to handle overflow during addition
        int i = nums.length - 1; // Pointer to the last digit in the nums array

        // Process the digits of nums and k until all digits are exhausted
        while (i >= 0 || k > 0) {
            int digit = (i >= 0) ? nums[i] : 0; // Get current digit from nums or 0 if index is out of bounds
            int sum = digit + (k % 10) + carry; // Compute the sum of current digits and carry
            result.add(sum % 10); // Add the least significant digit of the sum to the result
            carry = sum / 10; // Compute the carry for the next iteration
            k = k / 10; // Remove the least significant digit from k
            i--; // Move to the previous digit in nums
        }

        // If there's any remaining carry, add it to the result
        if (carry > 0) {
            result.add(carry);
        }

        // Reverse the result list to restore the correct order
        Collections.reverse(result);
        return result; // Return the resulting array
    }

    public static void main(String[] args) {
        _6ArraySum solution = new _6ArraySum(); // Create an instance of the class
        Scanner sc = new Scanner(System.in); // Scanner for input

        // Input the array size
        System.out.print("Enter the Number of Element of Array: ");
        int n = sc.nextInt();

        // Input the array elements
        System.out.print("Enter the Elements of an Array: ");
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input the number `k` to be added
        System.out.print("Enter the Number you Want to Add in Array: ");
        int k = sc.nextInt();

        // Perform the addition
        List<Integer> result = ArrSum(nums, k);

        // Display the original array before addition
        System.out.print("Array Before Adding K: [");
        for (int num : nums) {
            System.out.print(num + (num == nums[nums.length - 1] ? "" : ",")); 
        }
        System.out.println("]");

        // Display the resulting array
        System.out.println("Resulting Array-Form: " + result);
    }
}
