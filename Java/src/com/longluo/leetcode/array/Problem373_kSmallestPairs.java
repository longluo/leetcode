package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 373. 查找和最小的K对数字
 * <p>
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * 提示:
 * 1 <= nums1.length, nums2.length <= 10^4
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 * <p>
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 */
public class Problem373_kSmallestPairs {

    // MLE
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> sorted = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> item = new ArrayList<>();

                item.add(nums1[i]);
                item.add(nums2[j]);
                sorted.add(item);
            }
        }

        Collections.sort(sorted, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0) + a.get(1) - (b.get(0) + b.get(1));
            }
        });

        return k >= sorted.size() ? sorted : sorted.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println("[1, 2],[1,4],[1,6] ?= " + kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println("[1,1],[1,1] ?= " + kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println("[[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]] ?= " + kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));
        System.out.println("[1,3],[2,3] ?= " + kSmallestPairs(new int[]{1, 2}, new int[]{3}, 2));
    }
}
