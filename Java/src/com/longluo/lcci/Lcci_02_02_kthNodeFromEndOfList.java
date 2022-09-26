package com.longluo.lcci;

import com.longluo.datastructure.ListNode;

/**
 * 面试题 02.02. 返回倒数第 k 个节点
 *
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * <p>
 * 说明：
 * 给定的 k 保证是有效的。
 *
 */
public class Lcci_02_02_kthNodeFromEndOfList {

    public static int kthToLast(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int dest = n - k;
        curr = head;
        int idx = 0;
        while (idx < dest) {
            idx++;
            curr = curr.next;
        }

        return curr.val;
    }

    public static int kthToLast2(ListNode head, int k) {
        if (k == 0) {
            return head.val;
        }

        return head.val;
    }

    public static void main(String[] args) {

    }
}
