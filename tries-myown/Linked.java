class Linked {

    public class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    public insertAtIndex(int idx, int data) {
        Node node = head;
        for (int i = 0; i < idx; i++) {
            node = node.next;
        }
        Node newAdd = new Node(data);
        newAdd.next = node;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
    }

    // public void remove(int data) {
    //     if (head == null) return;

    //     if (head.next == data) {
    //         head = head.next;
    //         return;
    //     }
    // }

    public void print() {
        Node node = head;
        while (node.next != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.print(node.data);
    }

    public static void main(String[] args) {
        Linked n = new Linked();

        n.insert(22);
        n.insert(23);
        n.insert(3);
        n.insertFirst(40);

        n.print();
    }
}
