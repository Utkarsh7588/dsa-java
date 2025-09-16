package trees;

import java.util.Arrays;

public class SegmentTree {
    public static class Node {
        Node right;
        Node left;
        int endInterval;
        int startInterval;
        int data;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    Node root;

    public SegmentTree(int[] arr) {
        populate(arr);
    }

    public void populate(int[] arr) {
//        Node n = new Node(0, arr.length - 1);
//        n.data = sum(arr, 0, arr.length - 1);
        this.root = populate(arr, 0, arr.length - 1);

    }

    private Node populate(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            Node n = new Node(startIndex, endIndex);
            n.data = arr[startIndex];
            return n;
        }

        Node node = new Node(startIndex, endIndex);
        int mid = (startIndex + endIndex) / 2;
        node.left = populate(arr, startIndex, mid);
        node.right = populate(arr, mid + 1, endIndex);
        node.data=node.left.data+node.right.data;
        return node;
    }

//    private int sum(int[] arr, int startIndex, int endIndex) {
//        int sum = 0;
//        for (int i = startIndex; i <= endIndex; i++) {
//            sum = sum + arr[i];
//        }
//        return sum;
//    }

    public void update(int value, int index) {
        update(value, index, this.root);
    }

    private int update(int value, int index, Node node) {
        if (node.startInterval == node.endInterval && node.startInterval == index) {
            int diff = value - node.data;
            node.data = value;
            return diff;
        }
        if (node.left != null && node.left.endInterval >= index && index >= node.left.startInterval) {
            int add = update(value, index, node.left);
            node.data += add;
            return add;
        } else {
            int add = update(value, index, node.right);
            node.data += add;
            return add;
        }
    }

    public int sumInRange(int startInterval, int endInterval) {
        return sumInRange(startInterval, endInterval, this.root);
    }

    private int sumInRange(int startInterval, int endInterval, Node node) {
        if (node.startInterval == startInterval && node.endInterval == endInterval) {
            return node.data;
        }
        if (node.left != null && startInterval <= node.left.startInterval && node.left.endInterval >= endInterval) {
            return sumInRange(startInterval, endInterval, node.left);
        } else if (node.left != null && startInterval >= node.left.startInterval) {
            int sum = sumInRange(startInterval, node.left.endInterval, node.left) + sumInRange(node.left.endInterval+1, endInterval, node.right);
            return sum;
        } else {
            return sumInRange(startInterval, endInterval, node.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree tree = new SegmentTree(arr);
//        tree.update(2, 3);
        System.out.println(tree.sumInRange(0, 5));
    }
}
