package com.longluo.contest.biweekly_contest_111;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-111
 */
public class Problem1 {

    public static int countPairs(List<Integer> nums, int target) {
        int n = nums.size();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<>();
        tst1.add(-1);
        tst1.add(1);
        tst1.add(2);
        tst1.add(3);
        tst1.add(1);

        System.out.println("3 ?= " + countPairs(tst1, 2));
    }
}
