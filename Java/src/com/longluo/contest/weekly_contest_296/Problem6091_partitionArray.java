package com.longluo.contest.weekly_contest_296;

import java.util.Arrays;

/**
 * 6091. 划分数组使最大差为 K
 * <p>
 * 给你一个整数数组 nums 和一个整数 k 。你可以将 nums 划分成一个或多个 子序列 ，使 nums 中的每个元素都 恰好 出现在一个子序列中。
 * <p>
 * 在满足每个子序列中最大值和最小值之间的差值最多为 k 的前提下，返回需要划分的 最少 子序列数目。
 * <p>
 * 子序列 本质是一个序列，可以通过删除另一个序列中的某些元素（或者不删除）但不改变剩下元素的顺序得到。
 * <p>
 * 示例 1：
 * 输入：nums = [3,6,1,2,5], k = 2
 * 输出：2
 * 解释：
 * 可以将 nums 划分为两个子序列 [3,1,2] 和 [6,5] 。
 * 第一个子序列中最大值和最小值的差值是 3 - 1 = 2 。
 * 第二个子序列中最大值和最小值的差值是 6 - 5 = 1 。
 * 由于创建了两个子序列，返回 2 。可以证明需要划分的最少子序列数目就是 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3], k = 1
 * 输出：2
 * 解释：
 * 可以将 nums 划分为两个子序列 [1,2] 和 [3] 。
 * 第一个子序列中最大值和最小值的差值是 2 - 1 = 1 。
 * 第二个子序列中最大值和最小值的差值是 3 - 3 = 0 。
 * 由于创建了两个子序列，返回 2 。注意，另一种最优解法是将 nums 划分成子序列 [1] 和 [2,3] 。
 * <p>
 * 示例 3：
 * 输入：nums = [2,2,4,5], k = 0
 * 输出：3
 * 解释：
 * 可以将 nums 划分为三个子序列 [2,2]、[4] 和 [5] 。
 * 第一个子序列中最大值和最小值的差值是 2 - 2 = 0 。
 * 第二个子序列中最大值和最小值的差值是 4 - 4 = 0 。
 * 第三个子序列中最大值和最小值的差值是 5 - 5 = 0 。
 * 由于创建了三个子序列，返回 3 。可以证明需要划分的最少子序列数目就是 3 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 0 <= k <= 10^5
 * <p>
 * https://leetcode.cn/problems/partition-array-such-that-maximum-difference-is-k/
 */
public class Problem6091_partitionArray {

    // Sort + Greedy time: O(nlogn) space: O(logn)
    public static int partitionArray(int[] nums, int k) {
        int len = nums.length;

        Arrays.sort(nums);

        if (nums[len - 1] - nums[0] <= k) {
            return 1;
        }

        int ans = 1;
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > min + k) {
                min = nums[i];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + partitionArray(new int[]{2, 2, 4, 5}, 0));
        System.out.println("2 ?= " + partitionArray(new int[]{3, 6, 1, 2, 5}, 2));
        System.out.println("2 ?= " + partitionArray(new int[]{1, 2, 3}, 1));
    }
}
