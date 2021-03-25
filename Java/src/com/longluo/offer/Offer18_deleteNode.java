package com.longluo.offer;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * <p>
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * <p>
 * 说明：
 * 题目保证链表中节点的值互不相同
 * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class Offer18_deleteNode {

    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (dummy != null) {
            if (dummy.next != null && dummy.next.next != null && dummy.next.val == val) {
                dummy.next = dummy.next.next;
            } else if (dummy.next != null && dummy.next.next == null && dummy.next.val == val) {
                dummy.next = null;
            } else {
                dummy = dummy.next;
            }
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode test1 = Utils.makeListNode(new int[]{4, 5, 1, 9});
        System.out.println("[4,1,9] ?= " + Utils.printLinkedList(deleteNode(test1, 5)));

        ListNode test2 = Utils.makeListNode(new int[]{4, 5, 1, 9});
        System.out.println("[4,5,9] ?= " + Utils.printLinkedList(deleteNode(test2, 1)));

        ListNode test3 = Utils.makeListNode(new int[]{-3, 5, -99});
        System.out.println("[-3,5] ?= " + Utils.printLinkedList(deleteNode(test3, -99)));
    }
}
