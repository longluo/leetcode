package com.longluo.tencent_50;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 148. 排序链表
 * <p>
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/sort-list/
 */
public class Problem148_sortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pNode = head;
        List<Integer> list = new ArrayList<>();
        while (pNode != null) {
            list.add(pNode.val);
            pNode = pNode.next;
        }

        Collections.sort(list);
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = new ListNode(list.get(0));
        pNode = dummyNode;
        for (int i = 1; i < list.size(); i++) {
            dummyNode = dummyNode.next;
            dummyNode.next = new ListNode(list.get(i));
        }

        return pNode.next;
    }

    public static ListNode sortList_fast(ListNode head) {
        return sortList_merge(head, null);
    }

    public static ListNode sortList_merge(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }

        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode node1 = sortList_merge(head, mid);
        ListNode node2 = sortList_merge(mid, tail);
        ListNode pNode = mergeList(node1, node2);
        return pNode;
    }

    public static ListNode mergeList(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(0);
        ListNode head = dummyNode;
        ListNode temp1 = node1;
        ListNode temp2 = node2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                head.next = temp1;
                temp1 = temp1.next;
            } else {
                head.next = temp2;
                temp2 = temp2.next;
            }

            head = head.next;
        }

        while (temp1 != null) {
            head.next = temp1;
            temp1 = temp1.next;
            head = head.next;
        }

        while (temp2 != null) {
            head.next = temp2;
            temp2 = temp2.next;
            head = head.next;
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{4, 2, 1, 3});
        System.out.println(LinkedListNodeUtils.printLinkedList(sortList_fast(tst1)));
    }
}
