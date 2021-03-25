package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 876. 链表的中间结点
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
 */
public class Problem876_middleOfTheLinkedList {

    public static ListNode middleNode1(ListNode head) {
        ListNode[] arr = new ListNode[100];
        int n = 0;
        while (head != null) {
            arr[n++] = head;
            head = head.next;
        }

        return arr[n / 2];
    }

    public static ListNode middleNode2(ListNode head) {
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

    public static ListNode middleNode3(ListNode head) {
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
        ListNode test1 = Utils.makeListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[3,4,5] ?= " + Utils.printLinkedList(middleNode1(test1)));
        System.out.println("[3,4,5] ?= " + Utils.printLinkedList(middleNode2(test1)));
        System.out.println("[3,4,5] ?= " + Utils.printLinkedList(middleNode3(test1)));

        ListNode test2 = Utils.makeListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println("[4,5,6] ?= " + Utils.printLinkedList(middleNode1(test2)));
        System.out.println("[4,5,6] ?= " + Utils.printLinkedList(middleNode2(test2)));
        System.out.println("[4,5,6] ?= " + Utils.printLinkedList(middleNode3(test2)));

        ListNode test3 = Utils.makeListNode(new int[]{1});
        System.out.println("[1] ?= " + Utils.printLinkedList(middleNode1(test3)));
        System.out.println("[1] ?= " + Utils.printLinkedList(middleNode2(test3)));
        System.out.println("[1] ?= " + Utils.printLinkedList(middleNode3(test3)));
    }
}
