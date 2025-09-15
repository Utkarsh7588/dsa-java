package trees;

public class AVL {
    private int height;
    private AVL.Node root;

    public static class Node {
        private AVL.Node left;
        private AVL.Node right;
        private int value;
        private int height;

        public int getValue() {
            return value;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public int height(AVL.Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }


    public void prettyDisplay() {
        prettyDisplay(this.root, 0);
    }

    private void prettyDisplay(AVL.Node node, int level) {
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

    public void insert(int value) {
        root = insert(value, root);
    }

    public Node insert(int value, AVL.Node node) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) - height(node.left.right) > 0) {
                return rightRotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (height(node.left) - height(node.right) < -1) {
            // right heavy
            if (height(node.right.left) - height(node.right.right) < 0) {
                // right right case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {
                // left right case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(AVL.Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 20; i++) {
            tree.insert(i);
        }
        tree.prettyDisplay();
//        System.out.println(tree.root.height);
    }
}
