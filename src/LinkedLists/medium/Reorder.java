package LinkedLists.medium;

import LinkedLists.LL;

public class Reorder extends LL {
    public static void main(String[] args) {
//        Node a6 = new Node(6);
        Node a5 = new Node(5);
        Node a4 = new Node(a5, 4);
        Node a3 = new Node(a4, 3);
        Node a2 = new Node(a3, 2);
        Node a1 = new Node(a2, 1);
        display(a1);

        reorderList(a1);

        display(a1);

    }

    public static void reorderList(Node head) {
        if (head.next == null) {
            return;
        }
        Node mid = getMid(head);
        Node revHead = reverseFromMid(mid);
        //1->2->3
        //5->4
        while (head != null && revHead != null) {

            Node next = head.next;
            head.next = revHead;
            if (next == null) {
                break;
            }
            head = next;

            Node next1 = revHead.next;
            revHead.next = head;
            revHead = next1;
        }

    }

    public static Node reverseFromMid(Node mid) {
        Node prev = null;
        Node current = mid;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static Node getMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        Node prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    public static void display(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("END");
    }
}
