package LinkedLists.easy;

import LinkedLists.LL;

public class Palindrome extends LL {

    public static void main(String[] args) {
        // Example 1: Palindrome → 1 -> 2 -> 3 -> 2 -> 1
        Node n6=new Node(1);
        Node n5 = new Node(n6,2);
        Node n4 = new Node(n5, 3);
        Node n3 = new Node(n4, 3);
        Node n2 = new Node(n3, 2);
        Node n1 = new Node(n2, 1); // head = n1

        System.out.println("Is Palindrome: " + isPalindrome(n1)); // Expected: true

        // Example 2: Not a palindrome → 1 -> 2 -> 3
        Node b3 = new Node(3);
        Node b2 = new Node(b3, 2);
        Node b1 = new Node(b2, 1); // head = b1

        System.out.println("Is Palindrome: " + isPalindrome(b1)); // Expected: false
    }

    public static boolean isPalindrome(Node head){
        Node step1=reverseFromMid(head);
        Node step=head;
        while(step1!=null){
            if(step.val!=step1.val){
                return false;
            }
            step=step.next;
            step1=step1.next;
        }
        return true;
    }
    public static Node reverseFromMid(Node head){
        Node prev=null;
        Node current=getMid(head);

        while(current!=null){
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public static Node getMid(Node head){
        if(head==null||head.next==null){
            return head;
        }
        Node slow=head.next;
        Node fast=head.next.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
