// class BSTbasics {

//     static class Node {

//         int data;
//         Node left, right;

//         Node(int data) {
//             this.data = data;
//             this.left = this.right = null;
//         }
//     }

//     static class BST {

//         Node root;

//         public void insert(int data) {
//             root = insertRec(root, data);
//         }

//         public Node insertRec(Node curr, int data) {
//             if (curr == null) return new Node(data);

//             if (data < curr.data) {
//                 curr.left = insertRec(curr.left, data);
//             } else if (data > curr.data) {
//                 curr.right = insertRec(curr.right, data);
//             }

//             return curr;
//         }

//         // INORDER
//         public void inorder(Node node) {
//             if (node == null) return;
//             inorder(node.left);
//             System.out.print(node.data + " ");
//             inorder(node.right);
//         }
//     }

//     public static void main(String[] args) {
//         BST tree = new BST();

//         tree.insert(50);
//         tree.insert(30);
//         tree.insert(70);
//         tree.insert(20);
//         tree.insert(40);
//         tree.insert(60);
//         tree.insert(80);

//         tree.inorder(tree.root);
//     }
// }

import java.util.Scanner;

class Node {

    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BSTbasics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;

        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == -1) break;
            root = insert(root, val);
        }

        inorder(root);
    }

    private static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
