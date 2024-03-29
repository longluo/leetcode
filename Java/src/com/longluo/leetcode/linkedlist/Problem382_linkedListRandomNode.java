package com.longluo.leetcode.linkedlist;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 382. 链表随机节点
 * <p>
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * <p>
 * 实现 Solution 类：
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 * <p>
 * 示例：
 * 输入
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * 输出
 * [null, 1, 3, 2, 2, 3]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // 返回 1
 * solution.getRandom(); // 返回 3
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 2
 * solution.getRandom(); // 返回 3
 * // getRandom() 方法应随机返回 1、2、3中的一个，每个元素被返回的概率相等。
 * <p>
 * 提示：
 * 链表中的节点数在范围 [1, 10^4] 内
 * -10^4 <= Node.val <= 10^4
 * 至多调用 getRandom 方法10^4次
 * <p>
 * 进阶：
 * 如果链表非常大且长度未知，该怎么处理？
 * 你能否在不使用额外空间的情况下解决此问题？
 * <p>
 * https://leetcode.cn/problems/linked-list-random-node/
 */
public class Problem382_linkedListRandomNode {

    // ArrayList time: O(n) space: O(n)
    static class Solution {

        List<Integer> nums;
        Random random;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            nums = new ArrayList<>();

            int cnt = 0;

            ListNode pNode = head;
            while (pNode != null) {
                cnt++;
                nums.add(pNode.val);
                pNode = pNode.next;
            }

            random = new Random(cnt);
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int idx = random.nextInt(nums.size());
            return nums.get(idx);
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */
    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3});
        Solution s1 = new Solution(tst1);
        System.out.println(s1.getRandom());
        System.out.println(s1.getRandom());
        System.out.println(s1.getRandom());
    }
}
