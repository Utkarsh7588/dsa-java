package trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class LevelOrderTraversal2 {
    // LeetCode TreeNode definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // You will fill this
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        list.add(List.of(root.val));
        while (!queue.isEmpty()) {
            List<Integer> list1 = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    list1.add(node.left.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    list1.add(node.right.val);
                }

            }
            if (!list1.isEmpty()) list.add(0, list1);
        }

        return list;
    }

    // --- TESTING SETUP ---
    public static void main(String[] args) {
        LevelOrderTraversal2 sol = new LevelOrderTraversal2();

        // ---------- TEST TREE 1 ----------
        //       1
        //      / \
        //     2   3
        //    / \   \
        //   4   5   6
        TreeNode test1 =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(3,
                                null,
                                new TreeNode(6)
                        )
                );

        System.out.println("Test 1:");
        System.out.println(sol.levelOrder(test1));

        // ---------- TEST TREE 2 ----------
        //       10
        //      /
        //     20
        //    /
        //   30
        TreeNode test2 =
                new TreeNode(10,
                        new TreeNode(20,
                                new TreeNode(30),
                                null
                        ),
                        null
                );

        System.out.println("Test 2:");
        System.out.println(sol.levelOrder(test2));

        // ---------- TEST TREE 3 ----------
        // Empty tree
        TreeNode test3 = null;

        System.out.println("Test 3 (empty):");
        System.out.println(sol.levelOrder(test3));

        // ---------- TEST TREE 4 ----------
        //        7
        //       / \
        //      4   9
        //         /
        //        8
        TreeNode test4 =
                new TreeNode(7,
                        new TreeNode(4),
                        new TreeNode(9,
                                new TreeNode(8),
                                null
                        )
                );

        System.out.println("Test 4:");
        System.out.println(sol.levelOrder(test4));
    }
}
