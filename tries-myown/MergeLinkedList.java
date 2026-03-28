import java.util.Scanner;

public class MergeLinkedList {

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

        // Read and build the first linked list
        Node head1 = buildList(sc);
        // Read and build the second linked list
        Node head2 = buildList(sc);

        // Merge the lists
        Node mergedHead = mergeSortedLists(head1, head2);

        // Print the result
        printList(mergedHead);
    }

    // TODO: Implement this function
    public static Node mergeSortedLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 == null) {
            tail.next = l2;
        } else if (l2 == null) {
            tail.next = l1;
        }
        return dummy.next;
    }

    public static Node buildList(Scanner sc) {
        Node head = null;
        Node tail = null;

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

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}
