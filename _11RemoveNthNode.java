package HundredQuestionDSA_series;

class _11RemoveNthNode {

    // Definition for singly-linked list
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        // Utility function to add a node at the end of the list
        public void add(int data) {
            ListNode current = this;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(data);
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // Create a dummy node to simplify edge cases
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // Initialize two pointers at the dummy node
            ListNode firstPointer = dummy;
            ListNode secondPointer = dummy;

            // Move the secondPointer n+1 steps ahead to create a gap of n
            for (int i = 0; i <= n; i++) {
                secondPointer = secondPointer.next;
            }

            // Move both pointers until the secondPointer reaches the end
            while (secondPointer != null) {
                firstPointer = firstPointer.next;
                secondPointer = secondPointer.next;
            }

            // Remove the nth node from the end by skipping it
            firstPointer.next = firstPointer.next.next;

            // Return the head of the modified list
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        // Create a sample linked list using the add method
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);

        // Instantiate the solution class
        Solution solution = new Solution();

        // Remove the 2nd node from the end (result should be 1 -> 2 -> 3 -> 5)
        head = solution.removeNthFromEnd(head, 2);

        // Print the modified linked list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}
