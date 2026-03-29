class ValidBST {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class BST {

        static int index = 0;

        public static Node buildTree(int[] preorder) {
            if (index >= preorder.length || preorder[index] == -1) {
                index++;
                return null;
            }

            Node node = new Node(preorder[index++]);
            node.left = buildTree(preorder);
            node.right = buildTree(preorder);

            return node;
        }

        public static boolean validate(Node node, long min, long max) {
            if (node == null) return true;
            if (node.data <= min || node.data >= max) return false;

            return (
                validate(node.left, min, node.data) &&
                validate(node.left, node.data, max)
            );
        }
    }
}
