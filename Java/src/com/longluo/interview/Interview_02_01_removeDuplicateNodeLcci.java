package com.longluo.interview;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 02.01. 移除重复节点
 * <p>
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * <p>
 * 示例2:
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * <p>
 * 进阶：
 * 如果不得使用临时缓冲区，该怎么解决？
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class Interview_02_01_removeDuplicateNodeLcci {

    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode res = head;
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head.val)) {
                preNode.next = head.next;
            } else {
                map.put(head.val, head);
                preNode = head;
            }

            head = head.next;
        }

        return res;
    }

    public static ListNode removeDuplicateNodes_2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }



        return head;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 3, 2, 1});
        LinkedListNodeUtils.printLinkedList(removeDuplicateNodes(tst1));

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{1, 1, 1, 1, 2});
        LinkedListNodeUtils.printLinkedList(removeDuplicateNodes(tst2));
    }
}
