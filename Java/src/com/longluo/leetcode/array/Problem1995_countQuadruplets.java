package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1995. 统计特殊四元组
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,3,6,4,5]
 * 输出：0
 * 解释：[3,3,6,4,5] 中不存在满足要求的四元组。
 * <p>
 * 示例 3：
 * 输入：nums = [1,1,1,3,5]
 * 输出：4
 * 解释：满足要求的 4 个四元组如下：
 * - (0, 1, 2, 3): 1 + 1 + 1 == 3
 * - (0, 1, 3, 4): 1 + 1 + 3 == 5
 * - (0, 2, 3, 4): 1 + 1 + 3 == 5
 * - (1, 2, 3, 4): 1 + 1 + 3 == 5
 * <p>
 * 提示：
 * 4 <= nums.length <= 50
 * 1 <= nums[i] <= 100
 * <p>
 * https://leetcode-cn.com/problems/count-special-quadruplets/
 */
public class Problem1995_countQuadruplets {

    public static int countQuadruplets(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                for (int k = j + 1; k < len - 1; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    for (int m = k + 1; m < len; m++) {
                        if (nums[m] == sum) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static int countQuadruplets_hash(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int c = len - 2; c >= 2; c--) {
            cntMap.put(nums[c + 1], cntMap.getOrDefault(nums[c + 1], 0) + 1);
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    int sum = nums[a] + nums[b] + nums[c];
                    ans += cntMap.getOrDefault(sum, 0);
                }
            }
        }

        return ans;
    }

    public static int countQuadruplets_hash_better(int[] nums) {
        if (nums == null || nums.length < 4) {
            return 0;
        }

        int ans = 0;
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int b = len - 3; b >= 1; b--) {
            for (int d = b + 2; d < len; d++) {
                int delta = nums[d] - nums[b + 1];
                cntMap.put(delta, cntMap.getOrDefault(delta, 0) + 1);
            }
            for (int a = 0; a < b; a++) {
                ans += cntMap.getOrDefault(nums[a] + nums[b], 0);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countQuadruplets_hash_better(new int[]{1, 2, 3, 6}));
    }
}
