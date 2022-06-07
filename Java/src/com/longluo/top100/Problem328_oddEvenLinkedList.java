package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 328. 奇偶链表
 * <p>
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 * <p>
 * 示例 1:
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * <p>
 * 示例 2:
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 * <p>
 * 提示:
 * n ==  链表中的节点数
 * 0 <= n <= 10^4
 * -10^6 <= Node.val <= 10^6
 * <p>
 * https://leetcode.com/problems/odd-even-linked-list/
 */
public class Problem328_oddEvenLinkedList {

    // BF time: O(n) space: O(n)
    public static ListNode oddEvenList_bf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pNode = head;
        List<ListNode> nodeList = new ArrayList<>();
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        pNode = head;
        for (int i = 2; i < nodeList.size(); i += 2) {
            pNode.next = nodeList.get(i);
            pNode = pNode.next;
        }

        for (int i = 1; i < nodeList.size(); i += 2) {
            pNode.next = nodeList.get(i);
            pNode = pNode.next;
        }

        pNode.next = null;

        return head;
    }

    // OK time: O(n) space: O(1)
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pNode = head;
        ListNode pOdd = head;
        ListNode pEven = head.next;

        int len = 0;
        while (pNode != null) {
            len++;
            pNode = pNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(LinkedListNodeUtils.printLinkedList(oddEvenList_bf(tst1)));
        System.out.println(LinkedListNodeUtils.printLinkedList(oddEvenList(tst1)));
    }
}
