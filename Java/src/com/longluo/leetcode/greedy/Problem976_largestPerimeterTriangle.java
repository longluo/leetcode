package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * <p>
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,1]
 * 输出：0
 * <p>
 * 提示：
 * 3 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 */
public class Problem976_largestPerimeterTriangle {

    // Use Greedy
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int idx = nums.length - 1;
        while (idx >= 2 && nums[idx] >= nums[idx - 1] + nums[idx - 2]) {
            idx--;
        }

        if (idx >= 2) {
            ans += nums[idx] + nums[idx - 1] + nums[idx - 2];
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
