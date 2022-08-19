package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. 分割数组为连续子序列
 * <p>
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，
 * 其中每个子序列都由连续整数组成。
 * <p>
 * 如果可以完成上述分割，则返回 true；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * <p>
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * <p>
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * 提示：
 * 1 <= nums.length <= 10000
 * <p>
 * https://leetcode.cn/problems/split-array-into-consecutive-subsequences/
 */
public class Problem659_splitArrayIntoConsecutiveSubsequences {

    // HashMap time: O(n) space: O(n)
    public static boolean isPossible_map(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return false;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        }

        Map<Integer, Integer> tailMap = new HashMap<>();

        for (int x : nums) {
            int cnt = freqMap.getOrDefault(x, 0);
            if (cnt <= 0) {
                continue;
            }

            if (tailMap.getOrDefault(x - 1, 0) > 0) {
                freqMap.put(x, cnt - 1);
                tailMap.put(x - 1, tailMap.get(x - 1) - 1);
                tailMap.put(x, tailMap.getOrDefault(x, 0) + 1);
            } else if (freqMap.getOrDefault(x + 1, 0) > 0 && freqMap.getOrDefault(x + 2, 0) > 0) {
                freqMap.put(x, cnt - 1);
                freqMap.put(x + 1, freqMap.getOrDefault(x + 1, 0) - 1);
                freqMap.put(x + 2, freqMap.getOrDefault(x + 2, 0) - 1);
                tailMap.put(x + 2, tailMap.getOrDefault(x + 2, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isPossible_map(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println("false ?= " + isPossible_map(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
