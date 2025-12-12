package trees.easy;

import java.util.*;

public class CousinsInBinaryTree {

    // ---------------- TreeNode Definition ----------------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) { val = v; }
        TreeNode(int v, TreeNode l, TreeNode r) {
            val = v; left = l; right = r;
        }
    }

    // ---------------- Actual Solution ----------------
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;

                // Check if siblings
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) ||
                            (node.left.val == y && node.right.val == x)) {
                        return false; // siblings → not cousins
                    }
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // If both found in same level → cousins
            if (foundX && foundY) return true;

            // If only one found at this level → cannot be cousins
            if (foundX || foundY) return false;
        }

        return false;
    }

    // ---------------- Build Tree Helper ----------------
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

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
        CousinsInBinaryTree sol = new CousinsInBinaryTree();

        // Test 1: Expected true (4 and 5 are cousins)
        TreeNode t1 = buildTree(new Integer[]{1, 2, 3, 4, null, 5});
        System.out.println("Test 1: " + sol.isCousins(t1, 4, 5));

        // Test 2: Expected false (3 and 4 are not cousins)
        TreeNode t2 = buildTree(new Integer[]{1, 2, 3, null, 4});
        System.out.println("Test 2: " + sol.isCousins(t2, 3, 4));

        // Test 3: Expected false (same parent → siblings)
        TreeNode t3 = buildTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println("Test 3: " + sol.isCousins(t3, 4, 5));

        // Test 4: Expected true
        TreeNode t4 = buildTree(new Integer[]{1, 2, 3, null, 4, null, 5});
        System.out.println("Test 4: " + sol.isCousins(t4, 4, 5));

        // Test 5: Expected false
        TreeNode t5 = buildTree(new Integer[]{});
        System.out.println("Test 5: " + sol.isCousins(t5, 1, 2));
    }
}
