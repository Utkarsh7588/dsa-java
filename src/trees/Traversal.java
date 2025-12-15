package trees;

public class Traversal {

    // ---------- Tree Node ----------
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    TreeNode root;

    // ---------- Main ----------
    public static void main(String[] args) {

        Traversal tree = new Traversal();

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);

        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        tree.root.right.right = new TreeNode(6);

        System.out.print("Preorder: ");
        tree.preorder(tree.root);

        System.out.print("\nInorder: ");
        tree.inorder(tree.root);

        System.out.print("\nPostorder: ");
        tree.postorder(tree.root);
    }

    // ---------- Traversals ----------

    // Preorder: Root -> Left -> Right
    void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder: Left -> Root -> Right
    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    // Postorder: Left -> Right -> Root
    void postorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        inorder(node.right);
        System.out.print(node.data);
    }
}
