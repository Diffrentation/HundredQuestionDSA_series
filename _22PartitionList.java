public class _22PartitionList {

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

    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes to start the less and greater partitions
        ListNode lesshead = new ListNode(0);  // Dummy node for less partition
        ListNode greaterhead = new ListNode(0);  // Dummy node for greater partition
        
        // Pointers for traversing the less and greater lists
        ListNode less = lesshead;
        ListNode greater = greaterhead;
        
        // Traverse through the original list
        while (head != null) {
            if (head.val < x) {
                // Add to the less list if value is less than x
                less.next = head;
                less = less.next;
            } else {
                // Add to the greater list if value is greater than or equal to x
                greater.next = head;
                greater = greater.next;
            }
            head = head.next; // Move to the next node in the original list
        }
        
        // End the greater list to avoid cycles
        greater.next = null;
        
        // Connect the less list to the greater list
        less.next = greaterhead.next;  // It should be greaterhead.next, not greaterhead
        
        // Return the head of the partitioned list, which starts from lesshead.next
        return lesshead.next;
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
        // Creating a linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2 -> null
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 4);
        head = add(head, 3);
        head = add(head, 2);
        head = add(head, 5);
        head = add(head, 2);

        System.out.println("Original List:");
        printList(head);

        // Partition the list around value 3
        _22PartitionList solution = new _22PartitionList();
        head = solution.partition(head, 3);

        System.out.println("Partitioned List:");
        printList(head);
    }
}
