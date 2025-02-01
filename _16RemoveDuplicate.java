package HundredQuestionDSA_series;

class _16RemoveDuplicate {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Return the head if the list has 0 or 1 node
        }

        ListNode dummy = new ListNode(0); // Dummy node for easier edge case handling
        dummy.next = head;
        ListNode prev = dummy; // Pointer to track the last non-duplicate node
        ListNode current = head; // Pointer to traverse the list

        while (current != null) {
            // Detect duplicate group
            if (current.next != null && current.data == current.next.data) {
                // Skip all duplicate nodes
                while (current.next != null && current.data == current.next.data) {
                    current = current.next;
                }
                // Connect prev to the node after the duplicates
                prev.next = current.next;
            } else {
                // If no duplicate, move prev to current
                prev = prev.next;
            }
            // Move current to the next node
            current = current.next;
        }

        return dummy.next; // Return the new head of the list
    }

    // Function to add a new node to the end of the list
    public ListNode add(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode; // If the list is empty, return the new node as the head
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next; // Traverse to the end of the list
        }
        current.next = newNode; // Add the new node at the end
        return head;
    }

    // Function to print the nodes of the list
    public void printList(ListNode head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null"); // End of the list
    }

    public static void main(String[] args) {
        _16RemoveDuplicate solution = new _16RemoveDuplicate();

        // Create a linked list
        ListNode head = null;
        head = solution.add(head, 1);
        head = solution.add(head, 2);
        head = solution.add(head, 3);
        head = solution.add(head, 3);
        head = solution.add(head, 4);
        head = solution.add(head, 4);
        head = solution.add(head, 5);

        System.out.println("Original List:");
        solution.printList(head);

        // Remove duplicates
        ListNode result = solution.deleteDuplicates(head);

        System.out.println("List After Removing Duplicates:");
        solution.printList(result);
    }
}
