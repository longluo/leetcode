package com.longluo.contest.biweekly_contest_113;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-113
 */
public class Problem1 {

    public static int minimumRightShifts(List<Integer> nums) {
        int ans = 0;

        int n = nums.size();

        int first = nums.get(0);

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                continue;
            }

            if (i == n - 1 && nums.get(n - 1) < first) {
                return 1;
            }

            for (int j = i + 1; j < n; j++) {
                if (nums.get(j) > nums.get(j - 1)) {
                    if (j == n - 1 && nums.get(n - 1) < first) {
                        return n - i;
                    } else if (j == n - 1 && nums.get(n - 1) > first) {
                        return -1;
                    }

                    continue;
                }

                return -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<>();
        tst1.add(3);
        tst1.add(4);
        tst1.add(5);
        tst1.add(1);
        tst1.add(2);

        System.out.println("2 ?= " + minimumRightShifts(tst1));

        List<Integer> tst2 = new ArrayList<>();
        tst2.add(2);
        tst2.add(1);
        tst2.add(4);

        System.out.println("-1 ?= " + minimumRightShifts(tst2));
    }
}
