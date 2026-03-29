import java.util.*;

class MaxDepth {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class MaxDep {

        int maxDepth(Node node) {
            if (node == null) return -1;
            int leftMax = maxDepth(node.left);
            int rightMax = maxDepth(node.right);
            return 1 + Math.max(leftMax, rightMax);
        }
    }

    public static void main(String[] args) {
        MaxDep tree = new MaxDep();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Max Depth: " + tree.maxDepth(root));
    }
}
