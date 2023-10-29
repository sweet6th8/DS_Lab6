import java.io.*;

public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SinglyLinkedList() {
        super();
    }

    // Returns the number of elements in the list.
    public int size() {
        int count = 0;
        Node<E> current = head;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    // Returns true if the list is empty, and false otherwise.
    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    // Returns (but does not remove) the first element in the list.
    public E first() {
        return head.getData();
    }

    // Returns (but does not remove) the last element in the list.
    public E last() {
        return tail.getData();

    }

    // Adds a new element to the front of the list.
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        // size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node<E> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
        tail = newNode;
    }

    // Removes and returns the first element of the list.
    public E removeFirst() {
        head = head.getNext();
        return head.getData();
    }

    // Removes and returns the last element of the list.
    public E removeLast() {
        Node<E> curNode = head;

        while (curNode.getNext().getNext() != null) {
            curNode = curNode.getNext();
        }

        curNode.setNext(null);
        tail = curNode;
        return curNode.getData();
    }

    public void print() {
        Node<E> currNode = head;
        while (currNode != null) {
            System.out.print(currNode.getData());
            currNode = currNode.getNext();
            if (currNode != null) {
                System.out.print("->");
            } else {
                System.out.println();
            }
        }
    }
}