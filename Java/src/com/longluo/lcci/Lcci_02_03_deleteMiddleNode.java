package com.longluo.lcci;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.LinkedListNodeUtils;

/**
 * 面试题 02.03. 删除中间节点
 * <p>
 * 若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
 * <p>
 * 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。
 * <p>
 * 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f
 * <p>
 * 示例：
 * 输入：节点 5 （位于单向链表 4->5->1->9 中）
 * 输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
 * <p>
 * https://leetcode.cn/problems/delete-middle-node-lcci/?favorite=xb9lfcwi
 */
public class Lcci_02_03_deleteMiddleNode {

    // TODO: 2022/9/26  
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode test1 = LinkedListNodeUtils.constructListNode(new int[]{4, 5, 1, 9});
        deleteNode(test1);
        System.out.println("[4,1,9] ?= " + LinkedListNodeUtils.printLinkedList(test1));
    }
}
