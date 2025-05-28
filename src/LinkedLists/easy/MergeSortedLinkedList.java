package LinkedLists.easy;

import LinkedLists.LL;

import java.util.List;

public class MergeSortedLinkedList extends LL {

    public static void main(String[] args) {
        MergeSortedLinkedList list1 = new MergeSortedLinkedList();
        MergeSortedLinkedList list2 = new MergeSortedLinkedList();

//        list1.insertLast(1);
//        list1.insertLast(2);
//        list1.insertLast(4);
//
//        list2.insertLast(1);
//        list2.insertLast(3);
//        list2.insertLast(4);

        MergeSortedLinkedList res = new MergeSortedLinkedList();
        res.head = res.mergeTwoLists(list1.head, list2.head);
//        res.display(); // will only work if both list heads are not null
    }

    public LL.Node mergeTwoLists(LL.Node list1, LL.Node list2) {
        if (list1 != null && list2 != null){
            if (list1.val >= list2.val) {
                return mergeTwoLists(list1, list2.next, list2);

            } else {
                return mergeTwoLists(list1.next, list2, list1);
            }
        }
        else{
            if(list1!=null){
                return list1;
            }else if(list2!=null) {
                return list2;
            }
            else{
                return null;
            }
        }
    }

    public LL.Node mergeTwoLists(LL.Node list1, LL.Node list2, LL.Node start) {

        if (list1 == null && list2 == null) {
            return start;
        }
        if (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                start.next = list2;
                list2 = list2.next;
            } else {
                start.next = list1;
                list1 = list1.next;
            }
        } else {
            if (list1 != null) {
                start.next = list1;
                list1 = list1.next;
            } else {
                start.next = list2;
                list2 = list2.next;
            }
        }

        start.next = mergeTwoLists(list1, list2, start.next);
        return start;
    }
}
