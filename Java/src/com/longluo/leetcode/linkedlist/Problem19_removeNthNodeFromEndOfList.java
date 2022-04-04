package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 19. Remove Nth Node From End of List
 * <p>
 * Medium
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * <p>
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem19_removeNthNodeFromEndOfList {

    // BF + List time: O(n) space: O(n)
    public static ListNode removeNthFromEnd_bf(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode pNode = head;
        int size = 0;
        while (pNode != null) {
            nodeList.add(pNode);
            size++;
            pNode = pNode.next;
        }

        if (n == size) {
            return head.next;
        } else if (n == 1) {
            pNode = nodeList.get(size - 2);
            pNode.next = null;
        } else {
            pNode = nodeList.get(size - n - 1);
            pNode.next = pNode.next.next;
        }

        return head;
    }

    // Slow Fast Two Pointers time: O(n) space: O(1)
    public static ListNode removeNthFromEnd_fastslow(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode preNode = dummyNode;
        dummyNode.next = head;

        ListNode fast = head;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            preNode = preNode.next;
            slow = slow.next;
        }

        preNode.next = slow.next;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        removeNthFromEnd_fastslow(tst1, 2);
//        removeNthFromEnd_bf(tst1, 2);

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        removeNthFromEnd_bf(tst2, 1);
    }
}
