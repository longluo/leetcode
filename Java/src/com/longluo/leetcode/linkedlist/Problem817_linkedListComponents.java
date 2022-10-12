package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * <p>
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
 * 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。
 * <p>
 * 示例 1：
 * 输入: head = [0,1,2,3], nums = [0,1,3]
 * 输出: 2
 * 解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * <p>
 * 示例 2：
 * 输入: head = [0,1,2,3,4], nums = [0,3,1,4]
 * 输出: 2
 * 解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * 提示：
 * 链表中节点数为n
 * 1 <= n <= 10^4
 * 0 <= Node.val < n
 * Node.val 中所有值 不同
 * 1 <= nums.length <= n
 * 0 <= nums[i] < n
 * nums 中所有值 不同
 * <p>
 * https://leetcode.cn/problems/linked-list-components/
 */
public class Problem817_linkedListComponents {

    // Simulate time: O(n) space: O(n)
    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        int ans = 0;

        ListNode pNode = head;
        while (pNode != null) {
            if (set.contains(pNode.val)) {
                while (pNode != null && set.contains(pNode.val)) {
                    pNode = pNode.next;
                }

                ans++;
            } else {
                pNode = pNode.next;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{0, 1, 2, 3});
        System.out.println("2 ?= " + numComponents(tst1, new int[]{0, 1, 3}));

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{0, 1, 2, 3, 4});
        System.out.println("2 ?= " + numComponents(tst2, new int[]{0, 3, 1, 4}));

        ListNode tst3 = LinkedListNodeUtils.constructListNode(new int[]{0, 1, 2});
        System.out.println("2 ?= " + numComponents(tst3, new int[]{0, 2}));
    }
}
