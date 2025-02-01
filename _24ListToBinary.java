import javax.swing.tree.TreeNode;

public class _24ListToBinary {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Definition for binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null) { // If the list is empty, return null
            return null;
        }
        ListNode fast = head; // Fast pointer moves two steps at a time
        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode pre = slow; // Pointer to track the previous node of the middle node

        // Traverse the list until fast pointer reaches the end
        while (fast != null && fast.next != null) {
            pre = slow; // Update previous node
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps
        }

        pre.next = null; // Split the list into two halves
        return slow; // Return the middle node
    }

    // Method to convert a sorted linked list to a height-balanced binary search tree
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { // If the list is empty, return null
            return null;
        }

        // Find the middle element of the linked list
        ListNode mid = middleNode(head);

        // Create the root tree node with the middle element
        TreeNode root = new TreeNode(mid.val);

        // Recursively construct the left subtree using the left half of the list
        if (head != mid) {
            root.left = sortedListToBST(head);
        }

        // Recursively construct the right subtree using the right half of the list
        root.right = sortedListToBST(mid.next);

        return root; // Return the root of the tree
    }

    // Helper function to add a node at the end of the list
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

    // Helper function to print the tree in pre-order traversal
    public static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        // Creating a sorted linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 4);
        head = add(head, 5);
        head = add(head, 6);
        head = add(head, 7);

        // Converting the linked list to a height-balanced BST
        _24ListToBinary solution = new _24ListToBinary();
        TreeNode root = solution.sortedListToBST(head);

        // Printing the BST using pre-order traversal
        System.out.println("Binary Search Tree in Pre-order:");
        printTree(root);
    }
}
