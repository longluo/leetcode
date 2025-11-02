package com.longluo.contest.weekly_contest_351;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-351
 */
public class Problem2 {

    public static int makeTheIntegerZero(int num1, int num2) {
        if (num1 == 0) {
            return 0;
        }

        if ((num1 > 0 && num1 <= num2) || (num1 < 0 && num2 >= 0)) {
            return -1;
        }

        List<Long> ops = new ArrayList<>();

        for (int i = 0; i <= 60; i++) {
            ops.add((long) (num2 + Math.pow(2, i)));
        }

        if (ops.get(0) >= 0 && num1 < 0) {
            return -1;
        }

        int ans = 0;

        while (num1 != 0) {
            for (int i = 0; i <= 60; i++) {
                if (ops.get(i) == 0) {
                    continue;
                }

                if (ops.get(i) == num1) {
                    ans++;
                    return ans;
                } else if (i > 0 && ops.get(i - 1) <= num1 && ops.get(i) > num1) {
                    num1 -= ops.get(i - 1);
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + makeTheIntegerZero(3, -2));
        System.out.println("-1 ?= " + makeTheIntegerZero(5, 7));
    }
}
