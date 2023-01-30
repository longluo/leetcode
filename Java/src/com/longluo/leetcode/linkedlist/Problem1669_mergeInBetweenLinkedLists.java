package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1669. 合并两个链表
 * <p>
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * <p>
 * 下图中蓝色边和节点展示了操作后的结果：
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * 示例 1：
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中下标为 3 和 4 的两个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * <p>
 * 示例 2：
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * <p>
 * 提示：
 * 3 <= list1.length <= 10^4
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 10^4
 * <p>
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 */
public class Problem1669_mergeInBetweenLinkedLists {

    // BF time: O(n) space: O(n)
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        List<Integer> nums = new ArrayList<>();

        ListNode pNode = list1;

        while (pNode != null) {
            nums.add(pNode.val);
            pNode = pNode.next;
        }

        ListNode dummyHead = new ListNode(list1.val);
        pNode = dummyHead;

        for (int i = 1; i < a; i++) {
            pNode.next = new ListNode(nums.get(i));
            pNode = pNode.next;
        }

        while (list2 != null) {
            pNode.next = list2;
            pNode = pNode.next;
            list2 = list2.next;
        }

        for (int i = b + 1; i < nums.size(); i++) {
            pNode.next = new ListNode(nums.get(i));
            pNode = pNode.next;
        }

        return dummyHead;
    }


    public static void main(String[] args) {

    }
}
