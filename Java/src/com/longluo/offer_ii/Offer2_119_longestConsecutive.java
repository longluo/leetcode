package com.longluo.offer_ii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 119. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * <p>
 * https://leetcode-cn.com/problems/WhsWhI/
 */
public class Offer2_119_longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        int ans = 1;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int temp = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == num) {
                    continue;
                } else if (nums[j] - num == 1) {
                    num = nums[j];
                    temp++;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, temp);
        }

        return ans;
    }

    public static int longestConsecutive_1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        int ans = 1;
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int curNum = x;
                int curLen = 1;
                while (set.contains(curNum + 1)) {
                    curLen++;
                    curNum++;
                }

                ans = Math.max(ans, curLen);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("4 ?= " + longestConsecutive_1(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("9 ?= " + longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println("9 ?= " + longestConsecutive_1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
