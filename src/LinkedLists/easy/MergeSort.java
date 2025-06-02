package LinkedLists.easy;

import LinkedLists.LL;

public class MergeSort extends LL {


    public Node sortList(Node head) {

        if (head == null || head.next == null)
            return head;

        // Step 1: Split the list into halves
        Node mid = getMid(head);
        Node left = head;
        Node right = mid;

        // Step 2: Sort each half
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // Helper to find and split the list at midpoint
    private Node getMid(Node head) {
        Node slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect left half from right
        if (prev != null)
            prev.next = null;

        return slow;
    }

    // Merge two sorted lists
    private Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
