package com.longluo.algorithm;

// Circular Queue
public class CircularQueue {
    int capacity;
    int head;
    int tail;
    int[] array;

    CircularQueue(int capacity) {
        if (capacity <= 0) {
            return;
        }

        this.capacity = capacity;
        this.head = this.tail = 0;
        array = new int[capacity];
    }

    public boolean empty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean enqueue(int data) {
        if (isFull()) {
            return false;
        }

        array[tail] = data;
        tail = (tail + 1) % capacity;
        return true;
    }

    public Integer dequeue() {
        if (empty()) {
            return null;
        }

        int x = array[head];
        head = (head + 1) % capacity;
        return x;
    }

    public void display() {
        if (empty()) {
            return;
        }

        for (int i = head; i < head + capacity; i++) {
            System.out.printf("array[%d] = %d\n", i % capacity, array[i % capacity]);
        }
    }

    public int size() {
        return (tail - head + capacity) % capacity;
    }

    public Integer peek() {
        if (empty()) {
            return null;
        }

        return array[head];
    }

    // Driver code
    public static void main(String[] args) {

        // Initialising new object of
        // CircularQueue class.
        CircularQueue q = new CircularQueue(5);

        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(13);
        q.enqueue(-6);

        q.display();

        int x = q.dequeue();

        // Checking for empty queue.
        if (x != -1) {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        x = q.dequeue();

        // Checking for empty queue.
        if (x != -1) {
            System.out.print("Deleted value = ");
            System.out.println(x);
        }

        q.display();

        q.enqueue(9);
        q.enqueue(20);
        q.enqueue(5);

        q.display();

        q.enqueue(20);
    }
}

