package trees.medium;

import java.util.*;

public class RightSideView {

    // ------------------- TreeNode Definition -------------------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) { val = v; }

        TreeNode(int v, TreeNode l, TreeNode r) {
            val = v;
            left = l;
            right = r;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = null;

            for (int i = 0; i < size; i++) {
                node = queue.remove();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.add(node.val);
        }

        return result;
    }

    // ------------------- Helper: Build Tree from Array -------------------
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

    // ------------------- Test Runner -------------------
    public static void main(String[] args) {
        RightSideView sol = new RightSideView();

        // Test 1
        TreeNode t1 = buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        System.out.println("Test 1: " + sol.rightSideView(t1)); // [1,3,4]

        // Test 2
        TreeNode t2 = buildTree(new Integer[]{1, 2});
        System.out.println("Test 2: " + sol.rightSideView(t2)); // [1,2]

        // Test 3
        TreeNode t3 = buildTree(new Integer[]{1, null, 3});
        System.out.println("Test 3: " + sol.rightSideView(t3)); // [1,3]

        // Test 4
        TreeNode t4 = buildTree(new Integer[]{1});
        System.out.println("Test 4: " + sol.rightSideView(t4)); // [1]

        // Test 5
        TreeNode t5 = buildTree(new Integer[]{});
        System.out.println("Test 5: " + sol.rightSideView(t5)); // []
    }
}
