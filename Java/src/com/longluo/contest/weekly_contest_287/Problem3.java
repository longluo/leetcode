package com.longluo.contest.weekly_contest_287;

import java.util.Arrays;

public class Problem3 {

    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int candy : candies) {
            sum += candy;
            maxValue = Math.max(maxValue, candy);
            minValue = Math.min(minValue, candy);
        }
        if (sum < k) {
            return 0;
        }
        if (k <= 1) {
            return maxValue;
        }
        int left = 0;
        int right = maxValue;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int cnt = 0;
            for (int i = 0; i < candies.length; i++) {
                if (candies[i] > mid) {
                    cnt++;
                }
            }

            if (cnt >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        maximumCandies(new int[]{5, 8, 6}, 3);
    }
}
