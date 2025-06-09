package LinkedLists.easy;

import LinkedLists.LL;

public class ReverseLL extends LL {
    public static void main(String[] args) {
        Node node5 = new Node(1);
        Node node4 = new Node(node5, 2);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 4);
        Node node1 = new Node(node2, 5);
        Node head=recurssion(node1, null);
    }
    public static Node reverseList(Node head){
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next; // Save next
            current.next = prev;          // Reverse current node's pointer
            prev = current;               // Move prev forward
            current = nextNode;           // Move current forward
        }

        return prev;
    }

    public static  Node recurssion(Node current,Node prev){
        if(current==null){
            return prev;
        }
        Node next=current.next;
        current.next=prev;

        return recurssion(next,current);
    }
}
