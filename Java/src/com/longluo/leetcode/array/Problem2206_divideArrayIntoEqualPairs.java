package com.longluo.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs/
 * <p>
 * https://leetcode-cn.com/problems/divide-array-into-equal-pairs/
 */
public class Problem2206_divideArrayIntoEqualPairs {

    public boolean divideArray_sort(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 1; i += 2) {
            if (nums[i] == nums[i + 1]) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean divideArray(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
