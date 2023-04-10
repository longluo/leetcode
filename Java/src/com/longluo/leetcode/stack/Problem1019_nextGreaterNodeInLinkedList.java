package com.longluo.leetcode.stack;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * <p>
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，
 * 这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。
 * 如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 * <p>
 * 示例 1：
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * <p>
 * 示例 2：
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * 提示：
 * 链表中节点数为 n
 * 1 <= n <= 10^4
 * 1 <= Node.val <= 10^9
 * <p>
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 */
public class Problem1019_nextGreaterNodeInLinkedList {

    // BF time: O(n^2) space: O(n)
    public static int[] nextLargerNodes_bf(ListNode head) {
        List<Integer> nums = new ArrayList<>();

        ListNode pNode = head;

        while (pNode != null) {
            nums.add(pNode.val);
            pNode = pNode.next;
        }

        int[] ans = new int[nums.size()];
        int idx = 0;

        while (head != null) {
            int nodeVal = head.val;

            for (int i = idx + 1; i < nums.size(); i++) {
                if (nums.get(i) > nodeVal) {
                    ans[idx] = nums.get(i);
                    break;
                }
            }

            head = head.next;
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{2, 1, 5});

        System.out.println("[5, 5, 0] ?= " + Arrays.toString(nextLargerNodes_bf(tst1)));

    }
}
