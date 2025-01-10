package HundredQuestionDSA_series;

import java.util.Scanner;

public class _4Bottle {
    // Method to calculate the maximum number of bottles that can be drunk
    public static int countBottle(int bottles, int numExchange) {
        int totalDrunk = bottles; // Start with the initial number of bottles

        // Continue exchanging bottles as long as the number of bottles is greater than or equal to the exchange rate
        while (bottles >= numExchange) {
            int newBottles = bottles / numExchange; // Full bottles obtained from exchanging empty bottles
            int remainingBottles = bottles % numExchange; // Remaining empty bottles after exchange
            totalDrunk += newBottles; // Add the newly obtained bottles to the total drunk count
            bottles = newBottles + remainingBottles; // Update the total bottles (newly obtained + remaining)
        }

        return totalDrunk; // Return the total number of bottles drunk
    }

    public static void main(String[] args) {
        // Create an instance of the class to call the method (optional here as the method is static)
        _4Bottle bottleCalculator = new _4Bottle();
        Scanner sc = new Scanner(System.in);

        // Input: Number of initial full bottles
        System.out.print("Enter the number of full bottles: ");
        int bottles = sc.nextInt();

        // Input: Number of empty bottles required for one full bottle exchange
        System.out.print("Enter the number of empty bottles needed for one full bottle: ");
        int numExchange = sc.nextInt();

        // Calculate the maximum number of bottles that can be drunk
        int maxBottlesDrunk = bottleCalculator.countBottle(bottles, numExchange);

        // Output the result
        System.out.println("Maximum number of bottles drunk: " + maxBottlesDrunk);

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
