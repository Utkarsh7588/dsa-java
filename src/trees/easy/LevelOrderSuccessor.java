package trees.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    // Tree Node
    static class Node {
        Node left, right;
        int value;
    }

    // Utility function to create a
// new node with given value
    static Node newNode(int value)
    {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.value = value;

        return temp;
    }

    // Function to find the Level Order Successor
// of a given Node in Binary Tree
    static Node levelOrderSuccessor(Node root, Node key)
    {
        // Base Case
        if (root == null)
            return null;

        // If root equals to key
        if (root == key) {

            // If left child exists it will be
            // the Postorder Successor
            if (root.left != null)
                return root.left;

                // Else if right child exists it will be
                // the Postorder Successor
            else if (root.right != null)
                return root.right;
            else
                return null; // No Successor
        }

        // Create an empty queue for level
        // order traversal
//        Queue<Node> q = new LinkedList<Node>();
        Queue<Node> q = new LinkedList<Node>();

        // Enqueue Root
        q.add(root);

        while (!q.isEmpty()) {
            Node nd = q.peek();
            q.remove();

            if (nd.left != null) {
                q.add(nd.left);
            }

            if (nd.right != null) {
                q.add(nd.right);
            }

            if (nd == key)
                break;
        }

        return q.peek();
    }

    // Driver code
    public static void main(String[] args)
    {
        Node root = newNode(20);
        root.left = newNode(10);
        root.left.left = newNode(4);
        root.left.right = newNode(18);
        root.right = newNode(26);
        root.right.left = newNode(24);
        root.right.right = newNode(27);
        root.left.right.left = newNode(14);
        root.left.right.left.left = newNode(13);
        root.left.right.left.right = newNode(15);
        root.left.right.right = newNode(19);

        Node key = root.right.left; // node 24

        Node res = levelOrderSuccessor(root, key);

        if (res != null)
            System.out.println("LevelOrder successor of "
                    +key.value + " is " + res.value);
        else
            System.out.println("LevelOrder successor of "
                    +key.value + " is NULL");

    }
}