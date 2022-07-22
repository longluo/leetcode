package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
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
 * https://leetcode.cn/problems/partition-list/
 */
public class Problem86_partitionList {

    public static ListNode partition_bf(ListNode head, int x) {
        List<ListNode> nodeList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        ListNode pNode = head;
        while (pNode != null) {
            nodeList.add(pNode);
            min = Math.min(min, pNode.val);
            max = Math.max(max, pNode.val);
            pNode = pNode.next;
        }

        if (x <= min || x >= max) {
            return head;
        }



        return head;
    }

    public static void main(String[] args) {
        ListNode tstNode1 = LinkedListNodeUtils.constructListNode(new int[]{1, 4, 3, 2, 5, 2});
        partition_bf(tstNode1, 3);
        System.out.println(LinkedListNodeUtils.printLinkedList(tstNode1));
    }
}
