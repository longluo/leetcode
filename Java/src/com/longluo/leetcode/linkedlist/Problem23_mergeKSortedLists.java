package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;

/**
 * 23. 合并K个升序链表
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Problem23_mergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 || lists[0] == null) {
            return null;
        }

        int len = lists.length;
        if (len == 1) {
            return lists[0];
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode pNode = dummyNode;
        int[] array = new int[len];
        ListNode[] nodes = new ListNode[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = lists[i];
        }


        return dummyNode.next;
    }

    public static void main(String[] args) {

    }
}
