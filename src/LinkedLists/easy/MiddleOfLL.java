package LinkedLists.easy;

import LinkedLists.LL;

public class MiddleOfLL extends LL {
    public static void main(String[] args) {
//        Node node1=new Node(6);
        Node node2=new Node(5);
        Node node3=new Node(node2,4);
        Node node4=new Node(node3,3);
        Node node5=new Node(node4,2);
        Node node6=new Node(node5,1);

        System.out.println(middleNode(node6).val);
    }

    public static Node middleNode(Node head) {
        if(head==null||head.next==null){
            return head;
        }
        Node slow=head.next;
        Node fast=head.next.next;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
