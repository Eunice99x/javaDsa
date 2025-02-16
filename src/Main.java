import java.util.LinkedList;

public class Main {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }
    
    class LinkedList {
        Node head;
        // Add a node at the end
        public void append(int data) {
            if (head == null) {
                head = new Node(data);
                return;
            }
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = new Node(data);
        }
        // Print the linked list
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
        }
    } 
}