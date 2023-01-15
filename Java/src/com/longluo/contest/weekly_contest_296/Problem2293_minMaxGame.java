package com.longluo.contest.weekly_contest_296;

import java.util.ArrayList;
import java.util.List;

/**
 * 2293. 极大极小游戏
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。
 * <p>
 * 对 nums 执行下述算法：
 * <p>
 * 设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，新数组长度为 n / 2 ，下标从 0 开始。
 * 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
 * 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1]) 。
 * 用 newNums 替换 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 执行算法后，返回 nums 中剩下的那个数字。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,5,2,4,8,2,2]
 * 输出：1
 * 解释：重复执行算法会得到下述数组。
 * 第一轮：nums = [1,5,4,2]
 * 第二轮：nums = [1,4]
 * 第三轮：nums = [1]
 * 1 是最后剩下的那个数字，返回 1 。
 * <p>
 * 示例 2：
 * 输入：nums = [3]
 * 输出：3
 * 解释：3 就是最后剩下的数字，返回 3 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 1024
 * 1 <= nums[i] <= 10^9
 * nums.length 是 2 的幂
 * <p>
 * https://leetcode.cn/problems/min-max-game/
 */
public class Problem2293_minMaxGame {

    // Simulate time: O(nlogn) space: O(n)
    public static int minMaxGame(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(nums[i]);
        }

        int cycle = (int) (Math.log(len) / Math.log(2));
        for (int i = 0; i < cycle; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j < list.size() / 2; j++) {
                if (j % 2 == 0) {
                    newList.add(Math.min(list.get(2 * j), list.get(2 * j + 1)));
                } else {
                    newList.add(Math.max(list.get(2 * j), list.get(2 * j + 1)));
                }
            }

            list = newList;
        }

        return list.get(0);
    }

    // Simulate time: O(logn) space: O(n)
    public static int minMaxGame_array(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }

        while (nums.length > 1) {
            int n = nums.length;

            int[] temp = new int[n / 2];

            for (int i = 0; i < n / 2; i++) {
                if (i % 2 == 0) {
                    temp[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    temp[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }

            nums = temp;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println((Math.log(8) / Math.log(2)));
        System.out.println(minMaxGame(new int[]{93, 40}));
        System.out.println(minMaxGame(new int[]{70, 38, 21, 22}));
        System.out.println("1 ?= " + minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println("1 ?= " + minMaxGame_array(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
    }
}
