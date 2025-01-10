package HundredQuestionDSA_series;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _5Triplate {
    // Method to find all unique triplets in the array that sum up to the target
    public static List<List<Integer>> Triplate(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to enable two-pointer technique

        // If the array has less than 3 elements, no triplets can be formed
        if (nums.length < 3) {
            return result;
        }

        // Iterate through the array to find potential triplets
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for the first element to avoid duplicate triplets
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right]; // Calculate the sum of the triplet

                if (sum == target) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate elements for the second and third elements
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < target) {
                    // If the sum is less than the target, move the left pointer to increase the sum
                    left++;
                } else {
                    // If the sum is greater than the target, move the right pointer to decrease the sum
                    right--;
                }
            }
        }
        return result; // Return the list of triplets
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the array size
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input the array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input the target sum
        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        // Find and display the triplets
        List<List<Integer>> result = Triplate(nums, target);
        System.out.println("Triplets that sum to " + target + ": " + result);

        sc.close(); // Close the scanner
    }
}
