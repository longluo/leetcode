package com.longluo.contest.weekly_contest_294;

import java.util.Arrays;

public class Problem2279_maximumBagsWithFullCapacityOfRocks {

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int len = capacity.length;
        int[] count = new int[len];
        for (int i = 0; i < len; i++) {
            count[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(count);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (additionalRocks >= count[i]) {
                ans++;
                additionalRocks -= count[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maximumBags(new int[]{2, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));
    }
}
