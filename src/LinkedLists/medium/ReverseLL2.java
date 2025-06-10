package LinkedLists.medium;


import LinkedLists.LL;

public class ReverseLL2 extends LL {
    public static void main(String[] args) {
        // Example 1: reverse 2 to 4 in list: 5 -> 4 -> 3 -> 2 -> 1
        Node node5 = new Node(1);
        Node node4 = new Node(node5, 2);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 4);
        Node node1 = new Node(node2, 5); // head = node1

        Node head = node1;
//        System.out.println("Before reverse 2 to 4:");
//        printList(head);
//        head = reverseBetween(head, 2, 4);
//        System.out.println("After reverse 2 to 4:");
//        printList(head);

        // Example 2: reverse entire list: 1 -> 2 -> 3 -> 4->5->6
        Node a6 = new Node(6);
        Node a5 = new Node(a6,5);
        Node a4 = new Node(a5,4);
        Node a3 = new Node(a4, 3);
        Node a2 = new Node(a3, 2);
        Node a1 = new Node(a2, 1); // head = a1

        Node head2 = a1;
        System.out.println("\nBefore reverse 1 to 4:");
        printList(head2);
        head2 = reverseBetween(head2, 3, 4);
        System.out.println("After reverse 1 to 4:");
        printList(head2);
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if (left == right) {
            return head;
        }

        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;

        // reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

}
//7->6->5->4->3->2->1
//7->6<-5<-4<-3<-2 1
// 1-> 2-> 3-> 4-> 5
// 1->2<-3<-4 5 left=1 prev 4 curr 5