package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

/**
 * 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 10^9
 * <p>
 * https://leetcode-cn.com/problems/rotate-list/
 */
public class Problem61_rotateLinkedList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode curr = head;
        int n = 1;
        while (curr.next != null) {
            n++;
            curr = curr.next;
        }
        int step = n - k % n;
        if (step == n) {
            return head;
        }
        curr.next = head;
        while (step-- > 0) {
            curr = curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;
        return ans;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[4,5,1,2,3] ?= " + LinkedListNodeUtils.printLinkedList(rotateRight(test1, 2)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{0, 1, 2});
        System.out.println("[2,0,1] ?= " + LinkedListNodeUtils.printLinkedList(rotateRight(test2, 4)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("[2,1] ?= " + LinkedListNodeUtils.printLinkedList(rotateRight(test3, 1)));

        ListNode test4 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3});
        System.out.println("[2,3,1] ?= " + LinkedListNodeUtils.printLinkedList(rotateRight(test4, 2000000000)));

        ListNode test5 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("[1,2] ?= " + LinkedListNodeUtils.printLinkedList(rotateRight(test5, 2)));
    }
}
