import java.util.*;

class LevelTraversal {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class LevelOrder {

        void levelOrder(Node root) {
            if (root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();
                System.out.println(curr.data + " ");

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrder tree = new LevelOrder();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Level Order: ");
        tree.levelOrder(root);
    }
}
