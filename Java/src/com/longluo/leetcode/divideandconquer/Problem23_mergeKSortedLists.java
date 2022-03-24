package com.longluo.leetcode.divideandconquer;

import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Problem23_mergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
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

    public static void main(String[] args) {

    }
}
