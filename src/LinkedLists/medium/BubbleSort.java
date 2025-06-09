package LinkedLists.medium;

import LinkedLists.LL;

public class BubbleSort extends LL {

    public static void main(String[] args) {
        Node node5 = new Node(1);
        Node node4 = new Node(node5, 2);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 4);
        Node node1 = new Node(node2, 5);

        Node head = sort(node1);
        printList(head); // helper to print
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) return head;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.val > current.next.val) {
                    // Swap values instead of nodes
                    int temp = current.val;
                    current.val = current.next.val;
                    current.next.val = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
