public class _21RemoveDupliSortedList2 {

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

    // Function to remove duplicates from a sorted linked list
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head; // Return null if the list is empty
        }

        ListNode current = head;

        // Traverse the list and remove duplicates
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head; // Return the modified list
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
        _21RemoveDupliSortedList2 solution = new _21RemoveDupliSortedList2();
        head = solution.deleteDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}
