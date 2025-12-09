package trees.easy;

import java.util.*;

public class AverageOfLevels {

    // ---------- TreeNode definition ----------
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }

        TreeNode(int v, TreeNode l, TreeNode r) {
            val = v;
            left = l;
            right = r;
        }
    }

    // ---------- Your function to implement ----------
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> avgList = new ArrayList<>();
        avgList.add((double) root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int counter = 0;
            Queue<TreeNode> queue1 = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue1.add(node.left);
                    sum += node.left.val;
                    counter++;
                }
                if (node.right != null) {
                    queue1.add(node.right);
                    sum += node.right.val;
                    counter++;
                }
            }
            queue = queue1;
            if (counter != 0) avgList.add((sum / counter));
        }
        return avgList;
    }

    // ---------- Helper to build tree from array ----------
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null)
            return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode node = q.poll();

            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                q.add(node.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }

    // ---------- Test runner ----------
    public static void main(String[] args) {
        AverageOfLevels sol = new AverageOfLevels();

        TreeNode r1 = buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println("Test 1: " + sol.averageOfLevels(r1));

        TreeNode r2 = buildTree(new Integer[]{1, 2, 3});
        System.out.println("Test 2: " + sol.averageOfLevels(r2));

        TreeNode r3 = buildTree(new Integer[]{5});
        System.out.println("Test 3: " + sol.averageOfLevels(r3));

        TreeNode r4 = buildTree(new Integer[]{1, 2, null, 3});
        System.out.println("Test 4: " + sol.averageOfLevels(r4));

        TreeNode r5 = buildTree(new Integer[]{});
        System.out.println("Test 5: " + sol.averageOfLevels(r5));
    }
}
