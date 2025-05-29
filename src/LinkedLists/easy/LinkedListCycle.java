package LinkedLists.easy;

import LinkedLists.LL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinkedListCycle extends LL {
    public static void main(String[] args) {
        LL.Node node1 = new Node(3);
        LL.Node node2 = new Node(2);
        LL.Node node3 = new Node(0);
        LL.Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(hasCycle(node1));
    }

//    public static boolean hasCycle(LL.Node head) { // not so efficient method
//        Map<Node, Integer> l = new HashMap<>();
//        int i = 0;
//        while (head != null) {
//
//            if (l.containsKey(head)) {
//                return true;
//            }
//            l.put(head, i);
//            i++;
//            head=head.next;
//        }
//        return false;
//    }

    public static boolean hasCycle(Node head) {//2 pointer approach one pointer is fast one is slow
        if(head == null || head.next == null){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if ( fast == slow) {
                return true;
            }

        }

        return false;
    }
}
