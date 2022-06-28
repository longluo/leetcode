package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Problem206_reverseLinkedList {

    // Stack time: O(n) space: O(n)
    public static ListNode reverseList_stack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode pHead = stack.pop();
        ListNode res = pHead;
        while (!stack.empty()) {
            ListNode node = stack.pop();
            node.next = null;
            pHead.next = node;
            pHead = pHead.next;
        }

        return res;
    }

    // Iteration time: O(n) space: O(1)
    public static ListNode reverseList_opt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{});
        System.out.println("[] ?= " + LinkedListNodeUtils.printLinkedList(reverseList_stack(test1)));
        System.out.println("[] ?= " + LinkedListNodeUtils.printLinkedList(reverseList_opt(test1)));
        System.out.println("[] ?= " + LinkedListNodeUtils.printLinkedList(reverseList(test1)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{1});
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList_stack(test2)));
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList(test2)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("[2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList_stack(test3)));
        System.out.println("[2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList(test3)));

        ListNode test4 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3});
        System.out.println("[3,2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList_stack(test4)));
        System.out.println("[3,2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseList(test4)));
    }
}
