package dataStructureAnalyzer;

public class LinkedListOperations {

    private Node head;

    // Node class
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert a new value at the end
    public void insert(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Inserted successfully: " + value);
    }

    // Delete the first occurrence of a value
    public void delete(int value) {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted successfully: " + value);
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found: " + value);
        } else {
            current.next = current.next.next;
            System.out.println("Deleted successfully: " + value);
        }
    }

    // Search for a value and return its position
    public boolean search(int value) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == value) {
                System.out.println(
                    "Value " + value + " found at position " + position
                );
                return true;
            }

            current = current.next;
            position++;
        }

        System.out.println("Value not found: " + value);
        return false;
    }

    // Display all elements and their total count
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            System.out.println("Total elements: 0");
            return;
        }

        Node current = head;
        int count = 0;

        System.out.print("Linked list: ");

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            count++;
            current = current.next;
        }

        System.out.println(" -> null");
        System.out.println("Total elements: " + count);
    }

    // Check whether the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Return the number of elements
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}

