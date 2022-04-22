package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 23. Merge k Sorted Lists
 * <p>
 * Hard
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * <p>
 * Example 2:
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 * <p>
 * Constraints:
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 10^4.
 * <p>
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Problem23_mergeKSortedLists {

    public static ListNode mergeKLists_bf(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ListNode pNode = lists[i];
            while (pNode != null) {
                nums.add(pNode.val);
                pNode = pNode.next;
            }
        }

        Collections.sort(nums);
        int size = nums.size();
        if (size == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode pNode = dummyNode;
        for (int i = 0; i < size; i++) {
            ListNode node = new ListNode(nums.get(i));
            pNode.next = node;
            pNode = pNode.next;
        }

        return dummyNode.next;
    }

    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        } else if (listNode1.val <= listNode2.val) {
            listNode1.next = mergeTwoLists(listNode1.next, listNode2);
            return listNode1;
        } else {
            listNode2.next = mergeTwoLists(listNode1, listNode2.next);
            return listNode2;
        }
    }

    public static ListNode mergeTwoLists_iter(ListNode listNode1, ListNode listNode2) {
        ListNode dummyNode = new ListNode(0);
        ListNode pNode = dummyNode;
        while (listNode1 != null || listNode2 != null) {
            if (listNode1 != null && listNode2 != null) {
                if (listNode1.val <= listNode2.val) {
                    pNode.next = listNode1;
                    pNode = pNode.next;
                    listNode1 = listNode1.next;
                } else {
                    pNode.next = listNode2;
                    pNode = pNode.next;
                    listNode2 = listNode2.next;
                }
            }

            if (listNode1 != null) {
                pNode.next = listNode1;
                pNode = pNode.next;
                listNode1 = listNode1.next;
            }

            if (listNode2 != null) {
                pNode.next = listNode2;
                pNode = pNode.next;
                listNode2 = listNode2.next;
            }
        }

        return dummyNode.next;
    }

    public static ListNode mergeKLists_divide(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;
        ListNode ans = null;
        for (int i = 0; i < len; i++) {
//            ans = mergeTwoLists(ans, lists[i]);
            ans = mergeTwoLists_iter(ans, lists[i]);
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
