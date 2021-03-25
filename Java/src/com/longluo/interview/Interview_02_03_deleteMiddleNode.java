package com.longluo.interview;

import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.Utils;

/**
 * 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * <p>
 * 示例：
 * 输入：单向链表a->b->c->d->e->f中的节点c
 * 结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class Interview_02_03_deleteMiddleNode {

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode test1 = Utils.makeListNode(new int[]{4, 5, 1, 9});
        deleteNode(test1);
        System.out.println("[4,1,9] ?= " + Utils.printLinkedList(test1));
    }
}
