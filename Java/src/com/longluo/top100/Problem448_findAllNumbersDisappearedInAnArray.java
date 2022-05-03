package com.longluo.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，
 * 并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class Problem448_findAllNumbersDisappearedInAnArray {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static List<Integer> findDisappearedNumbers_bf(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            boolean hasFlag = false;
            for (int j = 0; j < len; j++) {
                if (nums[j] == i) {
                    hasFlag = true;
                    break;
                }
            }

            if (!hasFlag) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + findDisappearedNumbers_bf(new int[]{1}));
        System.out.println("2 ?= " + findDisappearedNumbers_bf(new int[]{1, 1}));
    }
}
