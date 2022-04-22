package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * Easy
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * <p>
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * <p>
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Problem21_mergeTwoSortedList {

    // Iteration time: O(n) space: O(1)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    pNode.next = list1;
                    pNode = pNode.next;
                    list1 = list1.next;
                } else {
                    pNode.next = list2;
                    pNode = pNode.next;
                    list2 = list2.next;
                }
            }

            while (list1 == null && list2 != null) {
                pNode.next = list2;
                pNode = pNode.next;
                list2 = list2.next;
            }

            while (list2 == null && list1 != null) {
                pNode.next = list1;
                pNode = pNode.next;
                list1 = list1.next;
            }
        }

        return dummyNode.next;
    }

    // Recursion time: O(n) space: O(n)
    public static ListNode mergeTwoLists_rec(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists_rec(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists_rec(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 4});
        ListNode list2 = LinkedListNodeUtils.constructListNode(new int[]{1, 3, 4});
        System.out.println("  ?= " + mergeTwoLists(list1, list2));
        System.out.println("  ?= " + mergeTwoLists_rec(list1, list2));
    }
}
