import java.util.ArrayList;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _13MergeKSortedLists {

    // Function to merge k sorted linked lists
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Priority queue (min-heap) based on the node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the first node of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Dummy node to simplify list manipulation
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process the heap
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                minHeap.add(smallest.next);
            }
        }

        return dummy.next;
    }

    // Function to convert an ArrayList<Integer> to a ListNode linked list
    public static ListNode arrayListToListNode(ArrayList<Integer> arrayList) {
        ListNode dummy = new ListNode(-1); // Dummy node to simplify construction
        ListNode current = dummy;

        for (int val : arrayList) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next; // Return the head of the linked list (skip dummy)
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(4);
        arrayList1.add(5);

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(3);
        arrayList2.add(4);

        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(2);
        arrayList3.add(6);

        // Convert ArrayLists to linked lists
        ListNode list1 = arrayListToListNode(arrayList1);
        ListNode list2 = arrayListToListNode(arrayList2);
        ListNode list3 = arrayListToListNode(arrayList3);

        // Merge linked lists
        ListNode[] lists = {list1, list2, list3};
        _13MergeKSortedLists solution = new _13MergeKSortedLists();
        ListNode mergedList = solution.mergeKLists(lists);

        // Print the result
        printList(mergedList);
    }
}
