package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1721. 交换链表中的节点
 * <p>
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * <p>
 * 示例 3：
 * 输入：head = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * 输入：head = [1,2,3], k = 2
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * 链表中节点的数目是 n
 * 1 <= k <= n <= 10^5
 * 0 <= Node.val <= 100
 * <p>
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */
public class Problem1721_swappingNodesInALinkedList {

    // BF List time: O(n) space: O(n)
    public static ListNode swapNodes_bf_list(ListNode head, int k) {
        ListNode pNode = head;
        List<ListNode> nodeList = new ArrayList<>();
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        int len = nodeList.size();
        int temp = nodeList.get(k - 1).val;
        nodeList.get(k - 1).val = nodeList.get(len - k).val;
        nodeList.get(len - k).val = temp;

        return head;
    }

    // Two Pointers time: O(n) space: O(1)
    public static ListNode swapNodes_tp(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int cnt = 0;
        while (left != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            left = left.next;
        }

        ListNode pNode = left;
        while (pNode.next != null) {
            pNode = pNode.next;
            right = right.next;
        }

        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }

    // Two Pointers Swap Nodes time: O(n) space: O(1)
    public static ListNode swapNodes_tp_swapNode(ListNode head, int k) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode preLeft = dummyNode;
        ListNode left = head;
        ListNode preRight = dummyNode;
        ListNode right = head;

        for (int i = 1; i < k; i++) {
            preLeft = preLeft.next;
            left = left.next;
        }

        ListNode curNode = left;
        while (curNode.next != null) {
            curNode = curNode.next;
            preRight = preRight.next;
            right = right.next;
        }

        ListNode tempNode = left.next;
        if (preLeft == right) {
            preRight.next = left;
            left.next = right;
            right.next = tempNode;
        } else if (left == preRight) {
            preLeft.next = right;
            left.next = right.next;
            right.next = left;
        } else {
            preLeft.next = right;
            preRight.next = left;
            left.next = right.next;
            right.next = tempNode;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
//        swapNodes_tp(tst1, 2);
        swapNodes_tp_swapNode(tst1, 2);

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4});
        swapNodes_tp_swapNode(tst2, 2);

        ListNode tst3 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        swapNodes_tp_swapNode(tst3, 1);

        ListNode tst4 = LinkedListNodeUtils.constructListNode(new int[]{100, 90});
        swapNodes_tp_swapNode(tst4, 2);
    }
}
