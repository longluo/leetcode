package com.longluo.algorithm;

// implement the queue use array
public class MyQueue {
    int[] array;
    int front;
    int rear;
    int capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        front = 0;
        rear = 0;
    }

    public void enqueue(int x) {
        if (rear == capacity) {
            return;
        }

        array[rear] = x;
        rear++;
    }

    public void dequeue() {
        if (front == rear) {
            return;
        }

        for (int i = 0; i < rear - 1; i++) {
            array[i] = array[i + 1];
        }

        array[rear] = 0;
        rear--;
    }

    public int front() {
        if (front == rear) {
            return -1;
        }
        return array[front];
    }

    public boolean empty() {
        return front == rear;
    }
}
