package com.longluo.top100;

import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * Easy
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 *
 * Example 2:
 * Input: head = [1,2]
 * Output: false

 * Constraints:
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 *
 * Follow up: Could you do it in O(n) time and O(1) space?
 *
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Problem234_palindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int len = list.size();
        for (int i = 0; i < len / 2; i++) {
            if (list.get(i) != list.get(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome_better(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindrome_rec(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
