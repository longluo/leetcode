package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 92. 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，
 * 返回 反转后的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class Problem92_reverseLinkedList_ii {

    // BF Swap Val time: O(n) space: O(n)
    public static ListNode reverseBetween_bf(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode pNode = head;
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        while (left < right) {
            int temp = nodeList.get(left - 1).val;
            nodeList.get(left - 1).val = nodeList.get(right - 1).val;
            nodeList.get(right - 1).val = temp;
            left++;
            right--;
        }

        return head;
    }

    // BF Swap Node time: O(n) space: O(n)
    // TODO: 2022/7/21  
    public static ListNode reverseBetween_node(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode pNode = head;
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preNode = left > 1 ? nodeList.get(left - 2) : dummyNode;

        for (int i = left; i <= right; i++) {
            ListNode curNode = nodeList.get(left - 1);

        }

        return head;
    }

    //
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode curr = dummyNode;
        int step = left;
        while (step > 1) {
            step--;
            curr = curr.next;
        }
        ListNode preLeft = curr;
        ListNode leftNode = curr.next;
        curr.next = null;
        step = right - left;
        curr = leftNode;
        while (step > 0) {
            step--;
            curr = curr.next;
        }
        ListNode rightNode = curr;
        ListNode preRight = null;
        if (curr.next != null) {
            preRight = curr.next;
        }
        rightNode.next = null;
        reverseLinkedList(leftNode);
        preLeft.next = rightNode;
        if (preRight != null) {
            leftNode.next = preRight;
        }
        return dummyNode.next;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[1,4,3,2,5] ?= " + LinkedListNodeUtils.printLinkedList(reverseBetween(test1, 2, 4)));
        System.out.println("[1,4,3,2,5] ?= " + LinkedListNodeUtils.printLinkedList(reverseBetween_bf(test1, 2, 4)));
        System.out.println("[1,4,3,2,5] ?= " + LinkedListNodeUtils.printLinkedList(reverseBetween_node(test1, 2, 4)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{5});
        System.out.println("[5] ?= " + LinkedListNodeUtils.printLinkedList(reverseBetween(test2, 1, 1)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{3, 5});
        System.out.println("[5,3] ?= " + LinkedListNodeUtils.printLinkedList(reverseBetween(test3, 1, 2)));

    }
}
