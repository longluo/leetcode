package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.ListNode;

/**
 * 237. 删除链表中的节点
 * <p>
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，
 * 只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 * <p>
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * <p>
 * 示例 2：
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 * <p>
 * 示例 3：
 * 输入：head = [1,2,3,4], node = 3
 * 输出：[1,2,4]
 * <p>
 * 示例 4：
 * 输入：head = [0,1], node = 0
 * 输出：[1]
 * <p>
 * 示例 5：
 * 输入：head = [-3,5,-99], node = -3
 * 输出：[5,-99]
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [2, 1000]
 * -1000 <= Node.val <= 1000
 * 链表中每个节点的值都是唯一的
 * 需要删除的节点 node 是 链表中的一个有效节点 ，且 不是末尾节点
 * <p>
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * <p>
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Problem237_deleteNodeInALinkedList {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
