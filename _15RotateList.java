

public class _15RotateList {
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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed for edge cases
        }

        // Step 1: Calculate the length of the list
        ListNode current = head;
        int length = 1; // Start with 1 to include the head
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Step 2: Adjust k to avoid unnecessary rotations
        k = k % length;
        if (k == 0) {
            return head; // No rotation needed if k is a multiple of length
        }

        // Step 3: Form a circular linked list
        current.next = head;

        // Step 4: Find the new tail and head
        int breakPoint = length - k; // The new tail will be at this position
        ListNode newTail = head;
        for (int i = 1; i < breakPoint; i++) { // Move to the new tail
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next; // The new head is the next node
        newTail.next = null; // Break the circular link

        return newHead;
    }

    public static ListNode add(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void printNode(ListNode head) {
        if (head == null) {
            System.out.println("Null");
            return;
        }
        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data);
            pointer = pointer.next;
            if (pointer != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" -> Null");
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 3);
        head = add(head, 5);
        head = add(head, 7);
        head = add(head, 9);
        head = add(head, 11);

        System.out.println("Original List:");
        printNode(head);

        // Rotate the list
        _15RotateList solution = new _15RotateList();
        ListNode result = solution.rotateRight(head, 4);

        System.out.println("Rotated List:");
        printNode(result);
    }
}
