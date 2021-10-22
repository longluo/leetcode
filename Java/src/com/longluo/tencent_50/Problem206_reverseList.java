package com.longluo.tencent_50;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.Stack;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class Problem206_reverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode pHead = stack.pop();
        ListNode res = pHead;
        while (!stack.empty()) {
            ListNode node = stack.pop();
            node.next = null;
            pHead.next = node;
            pHead = pHead.next;
        }

        return res;
    }

    public static ListNode reverseList_opt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode reverseList_rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }



        return head;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
//        System.out.println(LinkedListNodeUtils.printLinkedList(reverseList(tst1)));
        System.out.println(LinkedListNodeUtils.printLinkedList(reverseList_opt(tst1)));
    }
}
