package LinkedLists.easy;

import LinkedLists.LL;

public class RemoveDuplicate extends LL {
    public static void main(String[] args) {
        RemoveDuplicate list = new RemoveDuplicate();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);

        list.head = deleteDuplicates(list.head, list);
        System.out.println(list.head);
        list.display();

    }

    public static LL.Node deleteDuplicates(LL.Node head, RemoveDuplicate list) { //extram parameter list taken to acceess size not needed on leet code
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            head.next = head.next.next;
            head = deleteDuplicates(head,list);
            list.size--;//managing size of my linked list not needed on leet code submission
        } else {
            head.next = deleteDuplicates(head.next,list);
        }

        return head;
    }
}
