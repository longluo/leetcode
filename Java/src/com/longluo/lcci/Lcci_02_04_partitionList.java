package com.longluo.lcci;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

/**
 * 面试题 02.04. 分割链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * https://leetcode.cn/problems/partition-list-lcci/
 */
public class Lcci_02_04_partitionList {

    public static ListNode partition(ListNode head, int x) {

        return null;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 4, 3, 2, 5, 2});
        LinkedListNodeUtils.printLinkedList(tst1);
        LinkedListNodeUtils.printLinkedList(partition(tst1, 3));
    }
}
