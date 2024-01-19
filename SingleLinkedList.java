
/* Single Linked List Implementation: */
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

// Create

public class SingleLinkedList {

	static Node head = null;
	static Scanner sc = new Scanner(System.in);

	public static void create() {
		head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
	}

	// Insert Beggening

	public static void Insert_beg() {
		System.out.println("Enter Data: ");
		int d = sc.nextInt();
		Node n = new Node(d);
		if (head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
	}

	// Insert End

	public static void Insert_end() {
		System.out.println("Enter data to Insert it at End: ");
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
		}
	}

	// Insert Any

	public static void Insert_any() {
		System.out.println("Enter Data: ");
		int d = sc.nextInt();
		System.out.println("Enter Position: ");
		int p = sc.nextInt();
		Node n = new Node(d);
		Node temp = head;
		int i = 1;
		while (i < p - 1) {
			i++;
			temp = temp.next;

		}
		Node y = temp.next;
		temp.next = n;
		n.next = y;
	}

	// Traverse

	public static void Traverse() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "--->");
			temp = temp.next;
		}
		System.out.println();
	}

	// Delete Begenning

	public static void Delete_beg() {
		if (head == null) {
			System.out.println("Linked List is empty Please Enter Data. ");
		} else {
			head = head.next;
		}
	}

	// Delete End

	public static void Delete_end() {
		if (head == null) {
			System.out.println("Linked List is empty Please Enter Data. ");
		} else if (head.next == null) {
			head = null;
		} else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
		}
	}

	// Delete nth

	public static void Delete_nth() {
		System.out.print("Enter Position you want to delete: ");
		int p = sc.nextInt();
		Node temp = head;
		int i = 1;
		while (i < p - 1) {
			i++;
			temp = temp.next;
		}
		Node x = temp.next;
		Node y = x.next;
		temp.next = y;
		x.next = null;

	}

	// Delete Particular

	public static void Delete_Particular() {

	}

	// Reverse

	public static void Reverse() {
		Node current = head, prev = null, temp;
		while (current.next != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		current.next = prev;
		head = prev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(
					"1.To Create \n2.To Insert at Beg \n3.To Insert at the End \n4.To Insert at nth Position \n5.Display ");
			System.out.println(
					"6.To Delete at Beginning \n7.To Delete at End \n8.Delete Position Value \n9To Delete Particular Element \n10.Reverse \n11. Exit");
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
					Traverse();
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