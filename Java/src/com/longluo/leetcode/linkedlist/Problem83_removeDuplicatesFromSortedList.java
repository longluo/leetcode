package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点head，请你删除所有重复的元素，使每个元素只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点数目在范围[0, 300]内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class Problem83_removeDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode test1 = Utils.makeListNode(new int[]{});
        System.out.println("[] ?= " + Utils.printLinkedList(deleteDuplicates(test1)));

        ListNode test2 = Utils.makeListNode(new int[]{1});
        System.out.println("[1] ?= " + Utils.printLinkedList(deleteDuplicates(test2)));

        ListNode test3 = Utils.makeListNode(new int[]{1, 1});
        System.out.println("[1] ?= " + Utils.printLinkedList(deleteDuplicates(test3)));

        ListNode test4 = Utils.makeListNode(new int[]{1, 1, 2});
        System.out.println("[1,2] ?= " + Utils.printLinkedList(deleteDuplicates(test4)));

        ListNode test5 = Utils.makeListNode(new int[]{1, 1, 2, 3, 3});
        System.out.println("[1,2,3] ?= " + Utils.printLinkedList(deleteDuplicates(test5)));
    }
}
