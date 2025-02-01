package HundredQuestionDSA_series;

class ListNode {
    int val;          // Value of the current node
    ListNode next;    // Pointer to the next node in the list

    // Constructor to initialize the node
    ListNode(int x) { 
        this.val = x;
        this.next = null;
    }
}

public class _18linkListCycle {

    // Method to detect a cycle in a linked list
    public boolean hasCycle(ListNode head) {
        // If the head is null or the list has only one node, there is no cycle
        if (head == null || head.next == null) {
            return false;
        }

        // Initialize two pointers: slow and fast
        ListNode slow = head;  // Moves one step at a time
        ListNode fast = head;  // Moves two steps at a time

        // Traverse the list using the two-pointer technique
        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move slow pointer by 1 step
            fast = fast.next.next;    // Move fast pointer by 2 steps

            // If slow and fast pointers meet, a cycle is detected
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end of the list (null), there is no cycle
        return false;
    }

    public static void main(String[] args) {
        // Create test cases
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Create a cycle: 3 -> 2 -> 0 -> -4 -> 2
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle here

        _18linkListCycle solution = new _18linkListCycle();

        // Test case with a cycle
        System.out.println("Test case 1 (Cycle present): " + solution.hasCycle(node1)); // Output: true

        // Create a linked list without a cycle: 1 -> 2
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        node5.next = node6;

        // Test case without a cycle
        System.out.println("Test case 2 (No cycle): " + solution.hasCycle(node5)); // Output: false

        // Edge case: Empty list
        System.out.println("Test case 3 (Empty list): " + solution.hasCycle(null)); // Output: false

        // Edge case: Single node, no cycle
        ListNode singleNode = new ListNode(10);
        System.out.println("Test case 4 (Single node, no cycle): " + solution.hasCycle(singleNode)); // Output: false
    }
}
