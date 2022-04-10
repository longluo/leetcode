package com.longluo.studyplan.data_structure;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;
import com.longluo.datastructure.TreeNode;
import com.longluo.datastructure.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * 提示：
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
 * <p>
 * https://leetcode-cn.com/problems/reorder-list/
 */
public class Problem143_reorderList {

    // BF Swap Nodes time: O(2*n) space: O(n)
    public static void reorderList_bf(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode pNode = head;
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

        int len = nodeList.size();
        for (int i = 0; i < (len + 1) / 2; i++) {
            ListNode leftNode = nodeList.get(i);
            ListNode rightNode = nodeList.get(len - 1 - i);
            if (leftNode.next == rightNode) {
                rightNode.next = null;
                break;
            }
            if (i == ((len + 1) / 2 - 1)) {
                nodeList.get(i).next = null;
                break;
            }
            rightNode.next = leftNode.next;
            leftNode.next = rightNode;
        }
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4});
        reorderList_bf(tst1);

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5});
        reorderList_bf(tst2);
    }
}
