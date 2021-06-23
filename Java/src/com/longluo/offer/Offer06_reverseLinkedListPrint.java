package com.longluo.offer;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

import java.util.*;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * <p>
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class Offer06_reverseLinkedListPrint {

    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int[] res = new int[stack.size()];
        int idx = 0;
        while (!stack.empty()) {
            res[idx++] = stack.pop();
        }

        return res;
    }

    public static int[] reversePrint2(ListNode head) {
        return reverse(head, 0);
    }

    public static int[] reverse(ListNode head, int i) {
        if (head == null) {
            return new int[i];
        }
        int[] arr = reverse(head.next, i + 1);
        int len = arr.length;
        arr[len - 1 - i] = head.val;
        return arr;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{});
        System.out.println("[] ?= " + Arrays.toString(reversePrint(test1)));
        System.out.println("[] ?= " + Arrays.toString(reversePrint2(test1)));

        ListNode test2 = LinkedListNodeUtils.constructListNode(new int[]{1, 3, 2});
        System.out.println("[2,3,1] ?= " + Arrays.toString(reversePrint(test2)));
        System.out.println("[2,3,1] ?= " + Arrays.toString(reversePrint2(test2)));

        ListNode test3 = LinkedListNodeUtils.constructListNode(new int[]{1});
        System.out.println("[1] ?= " + Arrays.toString(reversePrint(test3)));
        System.out.println("[1] ?= " + Arrays.toString(reversePrint2(test3)));
    }
}
