package com.longluo.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1：
 * 输入：[3,2,3]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * 进阶：
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 * <p>
 * https://leetcode.com/problems/majority-element/
 */
public class Problem169_majorityElement {

    // Sort time: O(nlogn) space: O(logn)
    public static int majorityElement_sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        return nums[n / 2];
    }

    // HashMap time: O(n) space: O(n)
    public static int majorityElement_hash(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > n / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return 0;
    }

    // Vote time: O(n) space: O(1)
    public static int majorityElement_vote(int[] nums) {
        int vote = 0;
        int target = 0;
        for (int x : nums) {
            if (vote > 0 && target == x) {
                vote++;
            } else if (vote == 0) {
                target = x;
                vote++;
            } else {
                vote--;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + majorityElement_sort(new int[]{3, 2, 3}));
        System.out.println("2 ?= " + majorityElement_sort(new int[]{2, 2, 1, 1, 1, 2, 2}));

        System.out.println("3 ?= " + majorityElement_hash(new int[]{3, 2, 3}));
        System.out.println("2 ?= " + majorityElement_hash(new int[]{2, 2, 1, 1, 1, 2, 2}));

        System.out.println("2 ?= " + majorityElement_vote(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
