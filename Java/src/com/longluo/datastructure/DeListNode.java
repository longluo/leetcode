package com.longluo.datastructure;

public class DeListNode {
    public int key;
    public int value;
    public DeListNode pre;
    public DeListNode next;

    public DeListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }

    public DeListNode(int key, int value, DeListNode pre, DeListNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
