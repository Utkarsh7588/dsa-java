package trees;

public class BST {
    public static class Node {
        private Node left;
        private Node right;
        private int value;
        private  int height;
        public int getValue() {
            return value;
        }

        public Node(int value) {
            this.value = value;
        }


    }
    private int height;
    private Node root;

    public BST(int value) {
        this.root = new Node(value);
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

    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        insert(value, root);
    }

    public void insert(int value, Node node) {
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(value, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(value, node.right);
            }
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
    }
    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        BST obj = new BST(5);
        obj.insert(7);
        obj.insert(3);
        obj.insert(8);
        obj.insert(6);
        obj.insert(4);
        obj.insert(2);
        obj.prettyDisplay();
    }
}