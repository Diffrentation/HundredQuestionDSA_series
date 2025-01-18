/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;            // Value stored in the node
 *     ListNode next;      // Reference to the next node
 *     ListNode() {}       // Default constructor
 *     ListNode(int val) { this.val = val; } // Constructor to set value
 *     ListNode(int val, ListNode next) {    // Constructor to set value and next reference
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    /**
     * Adds two numbers represented by linked lists.
     * Each node contains a single digit, and the digits are stored in reverse order.
     *
     * @param l1 - Head of the first linked list
     * @param l2 - Head of the second linked list
     * @return ListNode - Head of the resulting linked list
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result construction
        ListNode current = dummy;        // Pointer to construct the result linked list
        int carry = 0;                   // Variable to store carry-over value

        // Loop through both linked lists and process until no nodes or carry remain
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Initialize sum with carry from the previous step

            // Add value from the first list if available
            if (l1 != null) {
                sum += l1.val; // Add the value of the current node in l1
                l1 = l1.next;  // Move to the next node in l1
            }

            // Add value from the second list if available
            if (l2 != null) {
                sum += l2.val; // Add the value of the current node in l2
                l2 = l2.next;  // Move to the next node in l2
            }

            // Update carry and calculate the digit to store in the current node
            carry = sum / 10; // Carry for the next iteration
            int digit = sum % 10; // Remainder to store in the current node

            // Create a new node with the digit and attach it to the result list
            current.next = new ListNode(digit);
            current = current.next; // Move the pointer to the next node
        }

        return dummy.next; // Return the actual head of the result list
    }

    /**
     * Converts an array of integers into a linked list.
     *
     * @param nums - Array of integers to convert
     * @return ListNode - Head of the resulting linked list
     */
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify list construction
        ListNode current = dummy;        // Pointer to construct the linked list

        // Traverse the array and create nodes for each element
        for (int num : nums) {
            current.next = new ListNode(num); // Create a new node with the current number
            current = current.next;          // Move the pointer to the next node
        }

        return dummy.next; // Return the head of the created linked list
    }

    /**
     * Prints the elements of a linked list.
     *
     * @param head - Head of the linked list to print
     */
    public static void printList(ListNode head) {
        // Traverse the list and print each value
        while (head != null) {
            System.out.print(head.val + " "); // Print the current node value
            head = head.next;                // Move to the next node
        }
        System.out.println(); // Print a newline at the end
    }

    public static void main(String[] args) {
        // Input arrays representing numbers in reverse order
        int[] l1 = {2, 4, 3}; // Represents the number 342
        int[] l2 = {5, 6, 7}; // Represents the number 765

        // Convert the arrays into linked lists
        ListNode list1 = createList(l1);
        ListNode list2 = createList(l2);

        // Create a Solution object to call the addTwoNumbers method
        Solution solution = new Solution();

        // Add the two numbers represented by the linked lists
        ListNode result = solution.addTwoNumbers(list1, list2);

        // Print the resulting linked list
        printList(result);
    }
}
