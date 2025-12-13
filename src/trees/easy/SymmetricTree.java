package trees.easy;

import java.util.*;

public class SymmetricTree {

    // ---------------- TreeNode Definition ----------------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) { val = v; }
        TreeNode(int v, TreeNode l, TreeNode r) {
            val = v; left = l; right = r;
        }
    }

    // ---------------- Main Solution ----------------
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // ---------------- Tree Builder Helper ----------------
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

    // ---------------- Test Cases ----------------
    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();

        // Test 1 - symmetric
        TreeNode t1 = buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println("Test 1: " + sol.isSymmetric(t1)); // true

        // Test 2 - not symmetric
        TreeNode t2 = buildTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println("Test 2: " + sol.isSymmetric(t2)); // false

        // Test 3 - single node
        TreeNode t3 = buildTree(new Integer[]{1});
        System.out.println("Test 3: " + sol.isSymmetric(t3)); // true

        // Test 4 - empty tree
        TreeNode t4 = buildTree(new Integer[]{});
        System.out.println("Test 4: " + sol.isSymmetric(t4)); // true

        // Test 5 - asymmetric children
        TreeNode t5 = buildTree(new Integer[]{1, 2, 2, 3, null, null, 3});
        System.out.println("Test 5: " + sol.isSymmetric(t5)); // true
    }
}
