package com.longluo.hot100;

import com.longluo.datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 141. Linked List Cycle
 * Easy
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * The number of the nodes in the list is in the range [0, 10^4].
 * -10^5 <= Node.val <= 10^5
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class Problem141_linkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        int idx = 0;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, idx);
            head = head.next;
            idx++;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
