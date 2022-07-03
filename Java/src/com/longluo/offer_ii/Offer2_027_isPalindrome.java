package com.longluo.offer_ii;

import com.longluo.datastructure.ListNode;

/**
 * 剑指 Offer II 027. 回文链表
 * <p>
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * <p>
 * 示例 2：
 * 输入: head = [1,2]
 * 输出: false
 * <p>
 * 提示：
 * 链表 L 的长度范围为 [1, 10^5]
 * 0 <= node.val <= 9
 * <p>
 * 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 注意：本题与主站 234 题相同：https://leetcode.cn/problems/palindrome-linked-list/
 * <p>
 * https://leetcode.cn/problems/aMhZSa/
 */
public class Offer2_027_isPalindrome {

    // TODO: 2022/6/25
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;

        return true;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
