package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * <p>
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Problem1512_numIdenticalPairs {

    public static int numIdenticalPairs(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println("6 ?= " + numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println("0 ?= " + numIdenticalPairs(new int[]{1, 2, 3}));
    }
}
