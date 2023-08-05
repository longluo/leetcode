package com.longluo.contest.biweekly_contest_110;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-110
 */
public class Problem2 {

    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        ListNode pNode = head;

        while (pNode != null) {
            nums.add(pNode.val);
            pNode = pNode.next;
        }

        for (int i = nums.size() - 1; i > 0; i--) {
            int first = nums.get(i);
            int second = nums.get(i - 1);

            int result = gcd(first, second);
            nums.add(i, result);
        }

        pNode = head;

        for (int i = 1; i < nums.size(); i++) {
            pNode.next = new ListNode(nums.get(i));
            pNode = pNode.next;
        }

        return head;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {

    }
}
