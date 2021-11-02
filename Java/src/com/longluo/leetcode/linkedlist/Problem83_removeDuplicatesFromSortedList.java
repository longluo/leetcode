package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

/**
 * 83. 删除排序链表中的重复元素
 * <p>
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
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
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
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{});
        System.out.println("[] ?= " + LinkedListNodeUtils.printLinkedList(deleteDuplicates(test1)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{1});
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(deleteDuplicates(test2)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{1, 1});
        System.out.println("[1] ?= " + LinkedListNodeUtils.printLinkedList(deleteDuplicates(test3)));

        ListNode test4 = LinkedListNodeUtils.constructListNode(new int[]{1, 1, 2});
        System.out.println("[1,2] ?= " + LinkedListNodeUtils.printLinkedList(deleteDuplicates(test4)));

        ListNode test5 = LinkedListNodeUtils.constructListNode(new int[]{1, 1, 2, 3, 3});
        System.out.println("[1,2,3] ?= " + LinkedListNodeUtils.printLinkedList(deleteDuplicates(test5)));
    }
}
