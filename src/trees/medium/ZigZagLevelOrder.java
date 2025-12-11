package trees.medium;

import com.sun.source.tree.Tree;

import java.util.*;

public class ZigZagLevelOrder {

    // ---------------- TreeNode definition ----------------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ---------------- zigzagLevelOrder() method ----------------
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = queue.removeFirst();
                    list1.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                } else {
                    TreeNode node = queue.removeLast();
                    list1.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }
            if (!list1.isEmpty()) list.add(list1);
            leftToRight = !leftToRight;
        }
        return list;
    }

    // ---------------- Helper: Build tree from array ----------------
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();

            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                q.offer(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                q.offer(node.right);
            }
            i++;
        }
        return root;
    }

    // ---------------- Test Runner ----------------
    public static void main(String[] args) {

        ZigZagLevelOrder sol = new ZigZagLevelOrder();

        // Test 1
        TreeNode t1 = buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Test 1: " + sol.zigzagLevelOrder(t1));

        // Test 2
        TreeNode t2 = buildTree(new Integer[]{1});
        System.out.println("Test 2: " + sol.zigzagLevelOrder(t2));

        // Test 3
        TreeNode t3 = buildTree(new Integer[]{});
        System.out.println("Test 3: " + sol.zigzagLevelOrder(t3));

        // Test 4
        TreeNode t4 = buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Test 4: " + sol.zigzagLevelOrder(t4));

        // Test 5 (unbalanced)
        TreeNode t5 = buildTree(new Integer[]{1, 2, null, 3, null, 4});
        System.out.println("Test 5: " + sol.zigzagLevelOrder(t5));

        TreeNode t6 = buildTree(new Integer[]{0,-4,-3,null,-1,8,null,null,3,null,-9,-2,null,4});
        System.out.println("Test 6: " + sol.zigzagLevelOrder(t6));
    }
}
