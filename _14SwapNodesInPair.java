public class _14SwapNodesInPair {
    public static class ListNode {
        int data;
        ListNode next;

        // Constructor for data only
        ListNode(int data) {
            this.data = data;
        }

        // Constructor for data and next
        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    // Method to swap nodes in pairs
    public static ListNode pairSwapping(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node
        dummy.next = head;
        ListNode pointer = dummy;

        while (pointer.next != null && pointer.next.next != null) {
            ListNode swap1 = pointer.next;
            ListNode swap2 = pointer.next.next;

            // Swapping nodes
            swap1.next = swap2.next;
            swap2.next = swap1;
            pointer.next = swap2;

            // Move the pointer forward
            pointer = swap1;
        }

        return dummy.next;
    }

    // Method to add a new node to the end of the list
    public static ListNode add(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = newNode;
        return head;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " -> ");
            pointer = pointer.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating a linked list
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 4);
        head = add(head, 5);

        // Printing the original list
        System.out.println("Original List:");
        printList(head);

        // Swapping nodes in pairs
        head = pairSwapping(head);

        // Printing the modified list
        System.out.println("List After Pair Swapping:");
        printList(head);
    }
}
