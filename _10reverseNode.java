package HundredQuestionDSA_series;

public class _10reverseNode {
    public static class Node {
        int data;
        Node next;

        // Constructor for Node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList {
        Node head;

        // Method to add a node at the end of the list
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        // Method to reverse the linked list
        public void reverseList() {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next; // Store the next node
                current.next = prev; // Reverse the current node's pointer
                prev = current;      // Move prev one step ahead
                current = next;      // Move current one step ahead
            }
            head = prev; // Update the head to the new front
        }

        // Method to print the list
        public void print() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Add elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Print the original list
        System.out.println("Original List:");
        list.print();

        // Reverse the list
        list.reverseList();

        // Print the reversed list
        System.out.println("Reversed List:");
        list.print();
    }
}
