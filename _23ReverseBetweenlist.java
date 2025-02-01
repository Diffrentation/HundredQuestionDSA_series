public class _23ReverseBetweenlist {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before 'left'
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // 'curr' will initially be at 'left'
        ListNode curr = prev.next;
        ListNode next = null;

        // Reverse the sublist
        for (int i = 0; i < right - left; i++) {
            next = curr.next;           // Store the next node
            curr.next = next.next;      // Bypass the next node
            next.next = prev.next;      // Insert 'next' node at the beginning of the sublist
            prev.next = next;           // Update the previous node to point to the new head of the sublist
        }

        return dummy.next;  // Return the modified list starting from the dummy node's next
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
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 4);
        head = add(head, 5);

        System.out.println("Original List:");
        printList(head);

        // Reverse the list between position 2 and 4
        _23ReverseBetweenlist solution = new _23ReverseBetweenlist();
        head = solution.reverseBetween(head, 2, 4);

        System.out.println("List after reversing between 2 and 4:");
        printList(head);
    }
}
