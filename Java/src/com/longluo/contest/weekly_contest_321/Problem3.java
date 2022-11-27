package com.longluo.contest.weekly_contest_321;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-321
 */
public class Problem3 {

    public static ListNode removeNodes(ListNode head) {
        ListNode pNode = head;
        Stack<ListNode> stk = new Stack<>();

        while (pNode != null) {
            if (stk.empty()) {
                stk.push(pNode);
                pNode = pNode.next;
            } else if (!stk.empty() && pNode.val <= stk.peek().val) {
                stk.push(pNode);
                pNode = pNode.next;
            } else {
                while (!stk.empty() && pNode.val > stk.peek().val) {
                    stk.pop();
                }

                stk.push(pNode);
                pNode = pNode.next;
            }
        }

        if (stk.empty()) {
            return null;
        }

        List<Integer> nums = new ArrayList<>();
        while (!stk.empty()) {
            nums.add(stk.pop().val);
        }

        int size = nums.size();
        pNode = new ListNode(nums.get(size - 1));
        ListNode back = pNode;
        for (int i = size - 2; i >= 0; i--) {
            back.next = new ListNode(nums.get(i));
            back = back.next;
        }

        return pNode;
    }

    // Stack time: O(n) space: O(n)
    public static ListNode removeNodes_opt(ListNode head) {
        Deque<Integer> stk = new ArrayDeque<>();

        while (head != null) {
            if (stk.isEmpty()) {
                stk.push(head.val);
                head = head.next;
            } else if (!stk.isEmpty() && head.val <= stk.peek()) {
                stk.push(head.val);
                head = head.next;
            } else {
                while (!stk.isEmpty() && head.val > stk.peek()) {
                    stk.pop();
                }

                stk.push(head.val);
                head = head.next;
            }
        }

        if (stk.isEmpty()) {
            return null;
        }

        ListNode pNode = new ListNode(stk.pollLast());
        ListNode curNode = pNode;
        while (!stk.isEmpty()) {
            curNode.next = new ListNode(stk.pollLast());
            curNode = curNode.next;
        }

        return pNode;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{5, 2, 13, 3, 8});
        LinkedListNodeUtils.printLinkedList(removeNodes(tst1));
        LinkedListNodeUtils.printLinkedList(removeNodes_opt(tst1));

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{1, 1, 1, 1});
        LinkedListNodeUtils.printLinkedList(removeNodes(tst2));
        LinkedListNodeUtils.printLinkedList(removeNodes_opt(tst2));
    }
}
