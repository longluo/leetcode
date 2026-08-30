package com.longluo.contest.weekly_contest_517;

import java.util.HashMap;
import java.util.Map;

/**
 * 4038. 统计特殊整数个数
 * <p>
 * 简单
 * <p>
 * 如果整数 x 在 nums 中的所有出现位置都位于同一个 连续 区间内，则称 x 为 特殊整数。
 * 返回 nums 中 不同 特殊整数的数量。
 * <p>
 * 示例 1：
 * 输入： nums = [1,2,2,1]
 * 输出： 1
 * 解释：
 * 1 出现在下标 0 和 3，形成了两个分离的区间，因此它不是特殊整数。
 * 2 在下标 [1, 2] 处形成一个连续区间，因此它是特殊整数。
 * 因此，共有一个特殊整数。
 * <p>
 * 示例 2：
 * 输入： nums = [3,3,1,2,2,1]
 * 输出： 2
 * 解释：
 * 3 在下标 [0, 1] 处形成一个连续区间，因此它是特殊整数。
 * 1 出现在下标 2 和 5，形成了两个分离的区间，因此它不是特殊整数。
 * 2 在下标 [3, 4] 处形成一个连续区间，因此它是特殊整数。
 * 因此，共有两个特殊整数。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode.cn/problems/count-integers-appearing-in-a-single-block/description/
 */
public class Problem1 {

    public static int countSpecialIntegers(int[] nums) {
        int ans = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : nums) {
            counts.put(x, counts.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            int cnt = counts.get(nums[i]);
            if (cnt == 1) {
                ans++;
            } else {
                while (cnt > 1 && i + cnt - 1 < nums.length && nums[i + cnt - 1] == nums[i]) {
                    cnt--;
                }

                if (cnt == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countSpecialIntegers(new int[]{1, 2, 2, 1}));
        System.out.println("2 ?= " + countSpecialIntegers(new int[]{3, 3, 1, 2, 2, 1}));
        System.out.println("1 ?= " + countSpecialIntegers(new int[]{25, 25, 25, 30, 25}));
    }
}
