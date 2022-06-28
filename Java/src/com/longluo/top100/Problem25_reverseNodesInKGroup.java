package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 提示：
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * <p>
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * <p>
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Problem25_reverseNodesInKGroup {

    // BF + List Swap Value time: O(n*k) space: O(n)
    public static ListNode reverseKGroup_bf(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode pNode = head;
        while (pNode != null) {
            list.add(pNode);
            pNode = pNode.next;
        }

        int len = list.size();
        for (int i = 0; i < len; i += k) {
            if (i + k > len) {
                break;
            }

            int left = i;
            int right = i + k - 1;
            while (left < right) {
                int temp = list.get(left).val;
                list.get(left).val = list.get(right).val;
                list.get(right).val = temp;
                left++;
                right--;
            }
        }

        return head;
    }

    // TODO: 2022/6/28  
    // Swap Node time: O(nk) space: O(n)
    public static ListNode reverseKGroup_swap(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        ListNode endNode = dummyNode;

        while (endNode != null) {
            for (int i = 0; i < k && endNode != null; i++) {
                endNode = endNode.next;
            }

            if (endNode == null) {
                break;
            }

            ListNode grpBegin = preNode.next;
            ListNode grpEnd = endNode.next;

            endNode.next = null;
            preNode.next = reverse(grpBegin);
            grpBegin.next = grpEnd;

            preNode = grpBegin;
            endNode = preNode;
        }

        return dummyNode.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node3 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("[2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseKGroup_bf(node3, 2)));
        System.out.println("[2,1] ?= " + LinkedListNodeUtils.printLinkedList(reverseKGroup_swap(node3, 2)));

        ListNode node1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[2,1,4,3,5] ?= " + LinkedListNodeUtils.printLinkedList(reverseKGroup_bf(node1, 2)));

        ListNode node2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println("[3,2,1,4,5] ?= " + LinkedListNodeUtils.printLinkedList(reverseKGroup_bf(node2, 3)));
    }
}
