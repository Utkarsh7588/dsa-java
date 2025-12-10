package trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



class LevelOrderTraversal {
    // LeetCode TreeNode definition
    class TreeNode {
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
        Queue<TreeNode> list1 = new LinkedList<>();
        list1.add(root);
        list.add(List.of(root.val));
        while (!list1.isEmpty()) {
            List<Integer> list2 = new ArrayList<>();
            Queue<TreeNode> list3 = new LinkedList<>();
            while (!list1.isEmpty()) {
                TreeNode node = list1.remove();
                if (node.left != null) {
                    list3.add(node.left);
                    list2.add(node.left.val);
                }
                if (node.right != null) {
                    list3.add(node.right);
                    list2.add(node.right.val);
                }

            }
            if (!list2.isEmpty()) list.add(list2);
            list1 = list3;
        }

        return list;
    }

    // --- TESTING SETUP ---
    public static void main(String[] args) {
        LevelOrderTraversal sol = new LevelOrderTraversal();

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
