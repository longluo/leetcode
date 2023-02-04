package com.longluo.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1798. 你能构造出连续值的最大数目
 * <p>
 * 给你一个长度为 n 的整数数组 coins ，它代表你拥有的 n 个硬币。第 i 个硬币的值为 coins[i] 。
 * 如果你从这些硬币中选出一部分硬币，它们的和为 x ，那么称，你可以 构造 出 x 。
 * <p>
 * 请返回从 0 开始（包括 0 ），你最多能 构造 出多少个连续整数。
 * <p>
 * 你可能有多个相同值的硬币。
 * <p>
 * 示例 1：
 * 输入：coins = [1,3]
 * 输出：2
 * 解释：你可以得到以下这些值：
 * - 0：什么都不取 []
 * - 1：取 [1]
 * 从 0 开始，你可以构造出 2 个连续整数。
 * <p>
 * 示例 2：
 * 输入：coins = [1,1,1,4]
 * 输出：8
 * 解释：你可以得到以下这些值：
 * - 0：什么都不取 []
 * - 1：取 [1]
 * - 2：取 [1,1]
 * - 3：取 [1,1,1]
 * - 4：取 [4]
 * - 5：取 [4,1]
 * - 6：取 [4,1,1]
 * - 7：取 [4,1,1,1]
 * 从 0 开始，你可以构造出 8 个连续整数。
 * <p>
 * 示例 3：
 * 输入：nums = [1,4,10,3,1]
 * 输出：20
 * <p>
 * 提示：
 * coins.length == n
 * 1 <= n <= 4 * 10^4
 * 1 <= coins[i] <= 4 * 10^4
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 */
public class Problem1798_maximumNumberofConsecutiveValuesYouCanMake {

    // BF time: O(n^2) space: O(n)
    // TLE
    public static int getMaximumConsecutive_bf(int[] coins) {
        Set<Integer> set = new HashSet<>();

        for (int x : coins) {
            List<Integer> nums = new ArrayList<>(set);
            for (int item : nums) {
                set.add(x + item);
            }

            set.add(x);
        }

        int ans = 1;
        while (ans > 0) {
            if (set.contains(ans)) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + getMaximumConsecutive_bf(new int[]{1, 3}));
        System.out.println("8 ?= " + getMaximumConsecutive_bf(new int[]{1, 1, 1, 4}));
        System.out.println("20 ?= " + getMaximumConsecutive_bf(new int[]{1, 4, 10, 3, 1}));
    }
}
