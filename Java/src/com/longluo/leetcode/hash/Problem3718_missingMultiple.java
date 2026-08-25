package com.longluo.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 3718. 缺失的最小倍数
 * <p>
 * 简单
 * <p>
 * 给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
 * <p>
 * 倍数 指能被 k 整除的任意正整数。
 * <p>
 * 示例 1：
 * 输入： nums = [8,2,3,4,6], k = 2
 * 输出： 10
 * 解释：
 * 当 k = 2 时，其倍数为 2、4、6、8、10、12……，其中在 nums 中缺失的最小倍数是 10。
 * <p>
 * 示例 2：
 * 输入： nums = [1,4,7,10,15], k = 5
 * 输出： 5
 * 解释：
 * 当 k = 5 时，其倍数为 5、10、15、20……，其中在 nums 中缺失的最小倍数是 5。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 * <p>
 * https://leetcode.cn/problems/smallest-missing-multiple-of-k/description/
 */
public class Problem3718_missingMultiple {

    public static int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            seen.add(x);
        }

        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("10 ?= " + missingMultiple(new int[]{8, 2, 3, 4, 6}, 2));
    }
}
