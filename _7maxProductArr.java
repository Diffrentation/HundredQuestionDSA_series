package HundredQuestionDSA_series;

import java.util.Scanner;

public class _7maxProductArr {
    // Function to calculate the maximum product
    public static int product(int[] nums) {
        int max1 = 0; // First largest number
        int max2 = 0; // Second largest number

        // Traverse the array to find the two largest numbers
        for (int num : nums) {
            if (num > max1) {
                max2 = max1; // Update max2 to previous max1
                max1 = num;  // Update max1 to the current number
            } else if (num > max2) {
                max2 = num; // Update max2 if the number is larger than current max2
            }
        }

        // Return the product of (max1 - 1) and (max2 - 1)
        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input: number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int nums[] = new int[n];

        // Input: elements of the array
        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Calculate the maximum product
        int result = product(nums);

        // Display the array
        System.out.print("Array: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + (i == nums.length - 1 ? "" : ", "));
        }
        System.out.println("]");

        // Display the result
        System.out.println("Maximum product of two elements is: " + result);

        sc.close(); // Close the scanner
    }
}
