package trees.medium;

import java.util.*;

public class PopulateNextRightPointers {

    // --------------------- Node Definition ---------------------
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> list = new ArrayList<>();
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (prev != null) {
                    prev.next = node;
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                prev = node;
            }
        }
        return root;
    }

    // --------------------- Helper: Build Tree from Array ---------------------
// NOTE: This builds a normal binary tree, not a perfect one.
    public static Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            Node node = q.poll();

            if (arr[i] != null) {
                node.left = new Node(arr[i]);
                q.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new Node(arr[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    // --------------------- Print Next Pointers Level-Wise ---------------------
    public static void printLevels(Node root) {
        Node levelStart = root;
        while (levelStart != null) {
            Node cur = levelStart;
            levelStart = null;

            while (cur != null) {
                System.out.print(cur.val + " -> ");
                if (levelStart == null) {
                    if (cur.left != null) levelStart = cur.left;
                    else if (cur.right != null) levelStart = cur.right;
                }
                cur = cur.next;
            }
            System.out.println("null");
        }
    }

    // --------------------- Test Runner ---------------------
    public static void main(String[] args) {
        PopulateNextRightPointers sol = new PopulateNextRightPointers();

        // Test 1
        Node t1 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        sol.connect(t1);
        System.out.println("Test 1:");
        printLevels(t1);

        // Test 2
        Node t2 = buildTree(new Integer[]{1, 2, 3, 4, null, null, 5});
        sol.connect(t2);
        System.out.println("\nTest 2:");
        printLevels(t2);

        // Test 3
        Node t3 = buildTree(new Integer[]{});
        sol.connect(t3);
        System.out.println("\nTest 3:");
        printLevels(t3);

        // Test 4
        Node t4 = buildTree(new Integer[]{10, 5, 15, null, 7});
        sol.connect(t4);
        System.out.println("\nTest 4:");
        printLevels(t4);
    }
}
