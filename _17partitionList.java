package HundredQuestionDSA_series;

public class _17partitionList {
    
    // ListNode class definition
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

    // Method to partition the list based on a given value x
    public ListNode partition(ListNode head, int x) {
        // Create two dummy nodes to start the less and greater partitions
        ListNode lesshead = new ListNode(0);
        ListNode greaterhead = new ListNode(0);
        
        // Pointers for traversing the less and greater lists
        ListNode less = lesshead;
        ListNode greater = greaterhead;
        
        // Traverse through the original list
        while (head != null) {
            if (head.data < x) {
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
        less.next = greaterhead.next;  // Fix: it should be greaterhead.next, not greaterhead
        
        // Return the head of the partitioned list, which starts from lesshead.next
        return lesshead.next;
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
        _17partitionList solution = new _17partitionList();

        // Create a linked list
        ListNode head = null;
        head = solution.add(head, 1);
        head = solution.add(head, 4);
        head = solution.add(head, 3);
        head = solution.add(head, 2);
        head = solution.add(head, 5);
        head = solution.add(head, 2);

        System.out.println("Original List:");
        solution.printList(head);

        // Partition the list around value 3
        ListNode partitionedHead = solution.partition(head, 3);

        System.out.println("List After Partitioning:");
        solution.printList(partitionedHead);
    }
}
