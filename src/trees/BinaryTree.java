package trees;

import java.util.Scanner;

public class BinaryTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node: ");
        int value = scanner.nextInt();
        this.root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }

        // Print current node
        System.out.println(indent + node.value);

        // Print left subtree with extra indentation
        if (node.left != null) {
            System.out.println(indent + "L-> ");
            display(node.left, indent + "   ");
        }

        // Print right subtree with extra indentation
        if (node.right != null) {
            System.out.println(indent + "R-> ");
            display(node.right, indent + "   ");
        }
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        prettyDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.populate(new Scanner(System.in));
        bt.display();
    }
}

