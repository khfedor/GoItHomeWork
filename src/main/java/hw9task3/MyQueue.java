package hw9task3;

public class MyQueue {
    private Node front;
    private Node rear;
    private int size;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    public Object poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Object data = front.data;
        front = front.next;
        size--;
        return data;
    }

    boolean isEmpty() {
        return size == 0;
    }

    private static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
        }
    }
}
