
/*
 * Stack Implementation:
 * 1)Push
 * 2)Pop
 * 3)Peep
 * 4)Traverse
 * 5)IsEmpty
 */
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Implement {
    static Scanner sc = new Scanner(System.in);
    static Node top = null;

    // PUSH

    public void push() {
        System.out.print("Enter element to push into the Stack: ");
        int d = sc.nextInt();
        Node n = new Node(d);
        n.next = top;
        top = n;
        System.out.println("Element Pushed into the Stack. Pushed Element: " + data);
    }

    // POP

    public void pop() {
        if (IsEmpty()) {
            System.out.println("Stack is Empty");
        }
        int poppedElement = top.data;
        top = top.next;
        System.out.println("Element Popped is " + poppedElement);
    }

    // PEEP

    public int peek() {
        if (IsEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }

    // TRAVERSE

    public void traverse() {
        if (IsEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        Node current = top;
        System.out.println("Stack Elemenst.");
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // IsEmpty

    public static Boolean IsEmpty() {
        return top == null;
    }

}

public class Stack {
    public static void main(String[] args) {
        Implement stack = new Implement();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter 0 for exit \n1 For Push \n2 For Pop \n3 For Peek \n4 For Traverse \n5 For To Check Empty or not.");
            int n = sc.nextInt();
            switch (n) {

                case 0:
                    System.exit(0);
                    sc.close();
                    break;
                case 1:
                    stack.push();
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println("Top Value: " + stack.peek());
                    break;
                case 4:
                    stack.traverse();
                    break;
                case 5:
                    stack.IsEmpty();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

}
