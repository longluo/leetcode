package com.longluo.studyplan.efficientwinning;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
public class Day01_1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.putIfAbsent(nums[i], i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(" " + twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
