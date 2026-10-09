package dataStructureAnalyzer;

public class LinkedListOperations {

    private Node head;
    private Node tail;
    private int count;

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new value at the end in O(1) time
    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        count++;
        System.out.println("Inserted successfully: " + value);
    }

    // Delete the first occurrence of a value
    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        // Delete the first node
        if (head.data == value) {
            head = head.next;
            count--;

            if (head == null) {
                tail = null;
            }

            System.out.println("Deleted successfully: " + value);
            return;
        }

        Node current = head;

        // Find the node before the target
        while (current.next != null &&
               current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found: " + value);
        } else {
            // Update tail if the last node is deleted
            if (current.next == tail) {
                tail = current;
            }

            current.next = current.next.next;
            count--;

            System.out.println("Deleted successfully: " + value);
        }
    }

    // Search for a value and display its position
    public boolean search(int value) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                System.out.println(
                    "Value " + value +
                    " found at position " + position
                );
                return true;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found: " + value);
        return false;
    }

    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            System.out.println("Total elements: 0");
            return;
        }

        Node current = head;

        System.out.print("Linked list: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println(" -> null");
        System.out.println("Total elements: " + count);
    }

    // Check whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return the number of elements in O(1) time
    public int size() {
        return count;
    }
}

