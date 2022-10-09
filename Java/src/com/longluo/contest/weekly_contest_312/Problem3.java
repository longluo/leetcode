package com.longluo.contest.weekly_contest_312;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;


        return ans;
    }

    private static boolean isAscend(int[] nums, int begin, int end) {
        if (begin > end) {
            return false;
        }

        for (int i = begin; i < end; i++) {
            if (i + 1 < end && nums[i + 1] < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
