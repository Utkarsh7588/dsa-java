package LinkedLists.easy;

import LinkedLists.LL;

public class LinkedListCycle2 extends LL {
    public static void main(String[] args) {
        LL.Node node1 = new Node(3);
        LL.Node node2 = new Node(2);
        LL.Node node3 = new Node(0);
        LL.Node node4 = new Node(4);

        // Creating a cycle: 3 -> 2 -> 0 -> 4
        //                        ^         |
        //                        |_________|
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;  // cycle here (back to node2)

        System.out.println(detectCycle(node1).val);  // Expected output: 2
    }

    public static Node detectCycle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node fast = head;
        Node slow = head;

        // Step 1: Detect if there is a cycle using Floyd's Tortoise and Hare
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // moves 2 steps
            slow = slow.next;       // moves 1 step

            if (fast == slow) {     // they meet => cycle detected

                // Step 2: Find the entry point of the cycle
                Node entry = head;

                /*
                 * Math behind this:
                 *
                 * Let's say:
                 * - L = distance from head to cycle start
                 * - C = length of the cycle
                 * - x = distance from cycle start to meeting point
                 *
                 * When slow and fast meet:
                 * - slow has moved L + x
                 * - fast has moved L + x + n*C (full loops in the cycle)
                 * - fast = 2 * slow
                 *
                 * => 2(L + x) = L + x + n*C
                 * => L + x = n*C
                 * => L = n*C - x
                 *
                 * So, if we start one pointer at head and another at meeting point,
                 * and move both one step at a time, they will meet at cycle start after L steps.
                 */

                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }

                return entry; // this is the node where the cycle begins
            }
        }

        return null;  // No cycle
    }
}
