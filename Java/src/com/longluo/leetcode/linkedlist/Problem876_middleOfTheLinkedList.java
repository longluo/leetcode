package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

/**
 * 876. 链表的中间结点
 * <p>
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间
 * <p>
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class Problem876_middleOfTheLinkedList {

    // BF time: O(n) space: O(n)
    public static ListNode middleNode_bf_store(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int n = 0;
        while (head != null) {
            arr[n++] = head;
            head = head.next;
        }

        return arr[n / 2];
    }

    // BF time: O(2*n) space: O(n)
    public static ListNode middleNode_bf_scan(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        int k = 0;
        cur = head;
        while (k < n / 2) {
            k++;
            cur = cur.next;
        }

        return cur;
    }

    // Two Pointers time: O(2*n) space: O(1)
    public static ListNode middleNode_tp(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[3,4,5] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_store(test1)));
        System.out.println("[3,4,5] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_scan(test1)));
        System.out.println("[3,4,5] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_tp(test1)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("[4,5,6] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_store(test2)));
        System.out.println("[4,5,6] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_scan(test2)));
        System.out.println("[4,5,6] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_tp(test2)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{1});
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_store(test3)));
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_bf_scan(test3)));
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(middleNode_tp(test3)));
    }
}
