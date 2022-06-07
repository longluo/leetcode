package com.longluo.top100;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 示例 2：
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 * <p>
 * 进阶：
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * https://leetcode.com/problems/sort-colors/
 */
public class Problem75_sortColors {

    // Sort time: O(nlogn) space: O(logn)
    public static void sortColors_bf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        Arrays.sort(nums);
    }

    // Count Sort time: O(n) space: O(1)
    public static void sortColors_CntSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int len = nums.length;
        int[] cnt = new int[3];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
        }

        int idx = 0;
        int color = 0;
        while (idx < len) {
            while (cnt[color] > 0) {
                nums[idx++] = color;
                cnt[color]--;
            }

            if (cnt[color] == 0) {
                color++;
            }
        }
    }

    public static void main(String[] args) {
        sortColors_bf(new int[]{2, 0, 2, 1, 1, 0});
        sortColors_CntSort(new int[]{2, 0, 2, 1, 1, 0});
    }
}
