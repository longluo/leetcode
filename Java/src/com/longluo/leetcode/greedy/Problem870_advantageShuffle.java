package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 870. 优势洗牌
 * <p>
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * 示例 1：
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * 示例 2：
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * 提示：
 * 1 <= nums1.length <= 10^5
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/advantage-shuffle/
 */
public class Problem870_advantageShuffle {

    // Greedy time: O(nlogn + n^2) space: O(n)
    // TLE
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int len = nums1.length;

        Arrays.sort(nums1);

        int[] ans = new int[len];

        int left = 0;
        int right = len - 1;

        boolean[] visited = new boolean[len];

        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = left; j <= right; j++) {
                if (nums1[j] > nums2[i] && !visited[j]) {
                    flag = true;
                    ans[i] = nums1[j];
                    visited[j] = true;
                    break;
                }
            }

            if (!flag) {
                while (visited[left]) {
                    left++;
                }

                ans[i] = nums1[left];
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 11, 7, 15] ?= " + Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println("[24, 32, 8, 12] ?= " + Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println("[1743, 9581, 5532, 5621, 3549] ?= " + Arrays.toString(advantageCount(new int[]{5621, 1743, 5532, 3549, 9581}, new int[]{913, 9787, 4121, 5039, 1481})));
    }
}
