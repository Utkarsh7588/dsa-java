package trees;

import java.util.*;

public class Search {

    // Simple binary tree node
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // Root of the tree
    Node root;

    public Search() {
        /*
         * Build this tree manually:
         *
         *          1
         *        /   \
         *       2     3
         *      / \   / \
         *     4   5 6   7
         */

        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    // Getter so you can use this root in your BFS
    public Node getRoot() {
        return root;
    }

    // You can implement BFS here
    // public void bfs() {
    //     // TODO: your BFS implementation
    // }

    public static void main(String[] args) {
        Search tree = new Search();
        Node root = tree.getRoot();

        // Call your BFS method here once you implement it
        System.out.println(tree.bfs(root));
        System.out.println(tree.dfs(root));
    }

    public List<Integer> bfs(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        return bfs(queue, list);
    }

    public List<Integer> bfs(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }
        Node node = queue.remove();
        list.add(node.value);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
        return bfs(queue, list);
    }

    public List<Integer> dfs(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        return dfs(stack, list);
    }

    public List<Integer> dfs(Stack<Node> stack, List<Integer> list) {
        if (stack.isEmpty()) {
            return list;
        }
        Node node = stack.pop();
        list.add(node.value);
        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
        return dfs(stack, list);
    }
}
