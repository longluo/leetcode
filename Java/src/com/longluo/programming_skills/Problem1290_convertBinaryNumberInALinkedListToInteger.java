package com.longluo.programming_skills;

import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1290. 二进制链表转整数
 * <p>
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * 示例 1：
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * <p>
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 * <p>
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * <p>
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 * <p>
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class Problem1290_convertBinaryNumberInALinkedListToInteger {

    // BF StringBuilder time: O(n) space: O(n)
    public static int getDecimalValue_bf(ListNode head) {
        if (head == null) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    // BF List time: O(n) space: O(n)
    public static int getDecimalValue_list(ListNode head) {
        if (head == null) {
            return 0;
        }

        List<Integer> numList = new ArrayList<>();
        while (head != null) {
            numList.add(head.val);
            head = head.next;
        }

        int ans = 0;
        for (int i = 0; i < numList.size(); i++) {
            ans = 2 * ans + numList.get(i);
        }

        return ans;
    }

    // Bit time: O(n) space: O(1)
    public static int getDecimalValue_bit(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) +  head.val;
            head = head.next;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
