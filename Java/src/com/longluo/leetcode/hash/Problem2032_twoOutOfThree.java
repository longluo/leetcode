package com.longluo.leetcode.hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2032. 至少在两个数组中出现的值
 * <p>
 * 给你三个整数数组 nums1、nums2 和 nums3 ，请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。
 * 数组中的元素可以按 任意 顺序排列。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
 * 输出：[3,2]
 * 解释：至少在两个数组中出现的所有值为：
 * - 3 ，在全部三个数组中都出现过。
 * - 2 ，在数组 nums1 和 nums2 中出现过。
 * <p>
 * 示例 2：
 * 输入：nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
 * 输出：[2,3,1]
 * 解释：至少在两个数组中出现的所有值为：
 * - 2 ，在数组 nums2 和 nums3 中出现过。
 * - 3 ，在数组 nums1 和 nums2 中出现过。
 * - 1 ，在数组 nums1 和 nums3 中出现过。
 * <p>
 * 示例 3：
 * 输入：nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
 * 输出：[]
 * 解释：不存在至少在两个数组中出现的值。
 * <p>
 * 提示：
 * 1 <= nums1.length, nums2.length, nums3.length <= 100
 * 1 <= nums1[i], nums2[j], nums3[k] <= 100
 * <p>
 * https://leetcode.cn/problems/two-out-of-three/
 */
public class Problem2032_twoOutOfThree {

    // Hash time: O(n) space: O(n)
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> wholeSet = new HashSet<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int x : nums1) {
            wholeSet.add(x);
            set1.add(x);
        }

        for (int x : nums2) {
            wholeSet.add(x);
            set2.add(x);
        }

        for (int x : nums3) {
            wholeSet.add(x);
            set3.add(x);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : wholeSet) {
            int cnt = 0;

            if (set1.contains(x)) {
                cnt++;
            }

            if (set2.contains(x)) {
                cnt++;
            }

            if (set3.contains(x)) {
                cnt++;
            }

            if (cnt >= 2) {
                ans.add(x);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 2] ?= " + twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3}));
    }
}
