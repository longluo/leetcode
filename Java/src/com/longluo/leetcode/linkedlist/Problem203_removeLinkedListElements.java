package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * 列表中的节点在范围[0, 10^4]内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 */
public class Problem203_removeLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }

            cur = cur.next;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode test1 = Utils.makeListNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println("[1,2,3,4,5] ?= " + Utils.printLinkedList(removeElements(test1, 6)));

        ListNode test2 = Utils.makeListNode(new int[]{});
        System.out.println("[] ?= " + Utils.printLinkedList(removeElements(test2, 1)));

        ListNode test3 = Utils.makeListNode(new int[]{7, 7, 7, 7});
        System.out.println("[] ?= " + Utils.printLinkedList(removeElements(test3, 7)));
    }
}
