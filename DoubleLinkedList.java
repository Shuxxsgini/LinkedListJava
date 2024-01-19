
/* Double Linked List Implementation */
import java.util.Scanner;

class Node {
    int data;
    Node next, prev;

    Node(int d) {
        data = d;
        next = prev = null;
    }
}

public class DoubleLinkedList {

    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    public static void create() {
        head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;
    }

    // Insert beginning
    public static void Insert_beg() {
        System.out.println("Enter Data: ");
        int d = sc.nextInt();
        Node n = new Node(d);
        if (head == null) {
            head = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    // Insert End
    public static void Insert_end() {
        System.out.println("Enter data to Insert at End: ");
        int d = sc.nextInt();
        Node n = new Node(d);
        if (head == null) {
            head = n;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }

    // Insert any
    public static void Insert_any() {
        System.out.println("Enter Data: ");
        int d = sc.nextInt();
        System.out.println("Enter Position: ");
        int p = sc.nextInt();
        Node n = new Node(d);
        if (p == 1) {
            n.next = head;
            if (head != null) {
                head.prev = n;
            }
            head = n;
        } else {
            Node temp = head;
            int i = 1;
            while (i < p - 1 && temp != null) {
                temp = temp.next;
                i++;
            }
            if (temp != null) {
                Node nextNode = temp.next;
                temp.next = n;
                n.prev = temp;
                n.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = n;
                }
            }
        }
    }

    // Traverse
    public static void Traverse(Node node) {
        if (node == null) {
            System.out.println();
            return;
        }
        System.out.print(node.data + "--->");
        Traverse(node.next);
    }

    // Delete Beginning
    public static void Delete_beg() {
        if (head == null) {
            System.out.println("Linked List is empty. Please Enter Data.");
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
    }

    // Delete End
    public static void Delete_end() {
        if (head == null) {
            System.out.println("Linked List is empty. Please Enter Data.");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node prevNode = temp.prev;
            prevNode.next = null;
        }
    }

    // Delete nth
    public static void Delete_nth() {
        System.out.print("Enter Position you want to delete: ");
        int p = sc.nextInt();
        Delete_nth_recursive(head, p);
    }

    // Recursive
    private static void Delete_nth_recursive(Node node, int p) {
        if (node == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        if (p == 1) {
            Node nextNode = node.next;
            Node prevNode = node.prev;
            if (prevNode != null) {
                prevNode.next = nextNode;
            } else {
                head = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = prevNode;
            }
        } else {
            Delete_nth_recursive(node.next, p - 1);
        }
    }

    public static void Delete_Particular() {
        // Implement as needed for specific element deletion
    }

    // Reverse
    public static void Reverse() {
        head = Reverse_recursive(head);
    }

    private static Node Reverse_recursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node newHead = Reverse_recursive(node.next);
        node.next.next = node;
        node.next = null;
        node.prev = newHead;
        return newHead;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "1.To Create \n2.To Insert at Beg \n3.To Insert at the End \n4.To Insert at nth Position \n5.Display ");
            System.out.println(
                    "6.To Delete at Beginning \n7.To Delete at End \n8.Delete Position Value \n9.To Delete Particular Element \n10.Reverse \n11. Exit");
            System.out.print("Enter Choice: ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    create();
                    break;
                case 2:
                    Insert_beg();
                    break;
                case 3:
                    Insert_end();
                    break;
                case 4:
                    Insert_any();
                    break;
                case 5:
                    Traverse(head);
                    break;
                case 6:
                    Delete_beg();
                    break;
                case 7:
                    Delete_end();
                    break;
                case 8:
                    Delete_nth();
                    break;
                case 9:
                    Delete_Particular();
                    break;
                case 10:
                    Reverse();
                    break;
                case 11:
                    System.out.println("Thank You Visit Again.");
                    System.exit(0);
                    sc.close();
                    break;
            }
        }
    }
}