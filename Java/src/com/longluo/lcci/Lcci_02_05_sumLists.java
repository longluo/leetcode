package com.longluo.lcci;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

/**
 * 面试题 02.05. 链表求和
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 * <p>
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * https://leetcode.cn/problems/sum-lists-lcci/
 */
public class Lcci_02_05_sumLists {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{7, 1, 6});
        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{5, 9, 2});
        LinkedListNodeUtils.printLinkedList(addTwoNumbers(tst1, tst2));
    }
}
