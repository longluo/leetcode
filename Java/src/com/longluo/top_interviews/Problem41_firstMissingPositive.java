package com.longluo.top_interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数
 * <p>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * 提示：
 * 1 <= nums.length <= 5 * 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class Problem41_firstMissingPositive {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static int firstMissingPositive_bf(int[] nums) {
        int ans = 1;
        int len = nums.length;
        for (int i = 1; i > 0; i++) {
            boolean flag = false;
            for (int j = 0; j < len; j++) {
                if (nums[j] == i) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // HashSet time: O(n) space: O(n)
    public static int firstMissingPositive_hash(int[] nums) {
        int ans = 1;
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (x > 0) {
                seen.add(x);
            }
        }

        for (int i = 1; i > 0; i++) {
            if (!seen.contains(i)) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + firstMissingPositive_bf(new int[]{3, 4, -1, 1}));
        System.out.println("2 ?= " + firstMissingPositive_hash(new int[]{3, 4, -1, 1}));
    }
}
