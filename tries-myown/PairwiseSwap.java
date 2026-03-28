import java.util.Scanner;

class PairwiseSwap {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head1 = buildList(sc); // Gets the first list
        Node head2 = buildList(sc); // Gets the second list

        System.out.println(findMergePoint(head1, head2));
    }

    // --- YOUR TURN: IMPLEMENT THIS ---
    public static int findMergePoint(Node h1, Node h2) {
        // Logic: 1. Get lengths 2. Align 3. Walk together
        int size1 = 0,
            size2 = 0;
        Node temp1 = h1;
        Node temp2 = h2;
        while (temp1 != null) {
            temp1 = temp1.next;
            size1++;
        }
        while (temp2 != null) {
            temp2 = temp2.next;
            size2++;
        }

        if (size1 < size2) {
            int temp = size2 - size1;
            while (temp != 0) {
                h2 = h2.next;
                temp--;
            }
        } else if (size1 > size2) {
            int temp = size1 - size2;
            while (temp != 0) {
                h1 = h1.next;
                temp--;
            }
        }

        while (h1 != null && h2 != null) {
            if (h1.data == h2.data) {
                return h1.data;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return -1;
    }

    private static Node buildList(Scanner sc) {
        Node head = null,
            tail = null;
        while (sc.hasNextInt()) {
            int val = sc.nextInt();
            if (val == -1) break;
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
}
