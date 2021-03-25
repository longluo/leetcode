package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点head，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中没有重复出现的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Problem82_removeDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode test0 = Utils.makeListNode(new int[]{});
        System.out.println("[] ?= " + Utils.printLinkedList(deleteDuplicates(test0)));

        ListNode test1 = Utils.makeListNode(new int[]{1});
        System.out.println("[1] ?= " + Utils.printLinkedList(deleteDuplicates(test1)));

        ListNode test2 = Utils.makeListNode(new int[]{1, 1});
        System.out.println("[] ?= " + Utils.printLinkedList(deleteDuplicates(test2)));

        ListNode test3 = Utils.makeListNode(new int[]{1, 2, 3});
        System.out.println("[1,2,3] ?= " + Utils.printLinkedList(deleteDuplicates(test3)));

        ListNode test4 = Utils.makeListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println("[1,2,5] ?= " + Utils.printLinkedList(deleteDuplicates(test4)));

        ListNode test5 = Utils.makeListNode(new int[]{1, 1, 1, 2, 3});
        System.out.println("[2,3] ?= " + Utils.printLinkedList(deleteDuplicates(test5)));
    }
}
