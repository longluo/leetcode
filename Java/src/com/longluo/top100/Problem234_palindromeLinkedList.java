package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.*;

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
            if (!list.get(i).equals(list.get(len - 1 - i))) {
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
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Fast Slow Pointers time: O(n) space: O(1)
    public static boolean isPalindrome_fastslow(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        ListNode pre = head;
        ListNode prePre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prePre;
            prePre = pre;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }

    // Stack time: O(n) space: O(n)
    public static boolean isPalindrome_stack(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode pNode = head;
        Deque<Integer> stk = new ArrayDeque<>();
        int len = 0;
        while (pNode != null) {
            stk.push(pNode.val);
            pNode = pNode.next;
            len++;
        }

        len /= 2;
        while (len-- >= 0) {
            if (head.val != stk.pop()) {
                return false;
            }

            head = head.next;
        }

        return true;
    }

    // Recursion time: O(n) space: O(n)
    static ListNode temp;

    public static boolean isPalindrome(ListNode head) {
        temp = head;
        return check(head);
    }

    private static boolean check(ListNode head) {
        if (head == null) {
            return true;
        }

        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode tstNode1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 2, 1});
        System.out.println("true ?= " + isPalindrome(tstNode1));
        System.out.println("true ?= " + isPalindrome_bf(tstNode1));
        System.out.println("true ?= " + isPalindrome_opt(tstNode1));
        System.out.println("true ?= " + isPalindrome_fastslow(tstNode1));
        System.out.println("true ?= " + isPalindrome_stack(tstNode1));

        ListNode tstNode2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2});
        System.out.println("false ?= " + isPalindrome_fastslow(tstNode2));
    }
}
