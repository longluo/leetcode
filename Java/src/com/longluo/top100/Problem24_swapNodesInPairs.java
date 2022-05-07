package com.longluo.top100;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题
 * （即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Problem24_swapNodesInPairs {

    // BF List Store Nodes Swap Values time: O(n) space: O(n)
    public static ListNode swapPairs_bf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> nodeList = new ArrayList<>();
        ListNode pNode = head;
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        for (int i = 0; i + 1 < nodeList.size(); i += 2) {
            int temp = nodeList.get(i).val;
            nodeList.get(i).val = nodeList.get(i + 1).val;
            nodeList.get(i + 1).val = temp;
        }

        return head;
    }

    // Swap Nodes time: O(n) space: O(1)
    public static ListNode swapPairs_node(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode leftNode = head;
        ListNode rightNode = head.next;
        while (rightNode != null) {
            preNode.next = rightNode;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;

            preNode = leftNode;
            if (leftNode.next == null) {
                break;
            }
            leftNode = leftNode.next;
            rightNode = leftNode.next;
        }

        return dummyNode.next;
    }

    // Recursive time: O(n) space: O(n)
    public static ListNode swapPairs_rec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs_rec(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode tstNode1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4});
        swapPairs_bf(tstNode1);
        swapPairs_node(tstNode1);
        swapPairs_rec(tstNode1);
    }
}
