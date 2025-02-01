public class _20removeDuplSortedList {

    public static class ListNode {
        int val;
        ListNode next;

        // Constructor for data only
        ListNode(int val) {
            this.val = val;
        }

        // Constructor for data and next
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return the head if the list has 0 or 1 node
        }

        ListNode dummy = new ListNode(-1); // Dummy node for easier edge case handling
        dummy.next = head;
        ListNode prev = dummy; // Pointer to track the last non-duplicate node
        ListNode current = head; // Pointer to traverse the list

        while (current != null) {
            // Detect duplicate group
            if (current.next != null && current.val == current.next.val) {
                // Skip all duplicate nodes
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                // Connect prev to the node after the duplicates
                prev.next = current.next;
            } else {
                // If no duplicate, move prev to current
                prev = current;
            }
            // Move current to the next node
            current = current.next;
        }

        return dummy.next; // Return the new head of the list
    }

    // Utility function to add a node at the end of the list
    public static ListNode add(ListNode head, int data) {
        if (head == null) {
            return new ListNode(data); // If the list is empty, return a new node as the head
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the last node
        }

        // Add the new node at the end
        current.next = new ListNode(data);
        return head;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a linked list with duplicates: 1 -> 1 -> 2 -> 3 -> 3 -> null
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 3);

        System.out.println("Original List:");
        printList(head);

        // Remove duplicates
        _20removeDuplSortedList solution = new _20removeDuplSortedList();
        head = solution.deleteDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
