package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * <p>
 * Easy
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 * <p>
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * <p>
 * Constraints:
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * <p>
 * Follow up: Could you do it in O(n) time and O(1) space?
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class Problem234_palindromeLinkedList {

    // BF time: O(n) space: O(n)
    public static boolean isPalindrome_bf(ListNode head) {
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

    // BF Opt time: O(n) space: O(n)
    public static boolean isPalindrome_opt(ListNode head) {
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

    // Two Pointers time: O(n) space: O(1)
    public static boolean isPalindrome_fastslow(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode current = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            current.next = pre;
            pre = current;
            current = slow;
        }

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }

    // Recursion
    public static boolean isPalindrome_rec(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }


        return false;
    }

    public static void main(String[] args) {
        ListNode tstNode1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 2, 1});
        System.out.println("true ?= " + isPalindrome_bf(tstNode1));
        System.out.println("true ?= " + isPalindrome_opt(tstNode1));
        System.out.println("true ?= " + isPalindrome_fastslow(tstNode1));
        System.out.println("true ?= " + isPalindrome_rec(tstNode1));

        ListNode tstNode2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("false ?= " + isPalindrome_fastslow(tstNode2));
    }
}
