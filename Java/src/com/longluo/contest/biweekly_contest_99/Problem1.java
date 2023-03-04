package com.longluo.contest.biweekly_contest_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-99
 */
public class Problem1 {

    public static int splitNum(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        Collections.sort(list);

        int n = list.size();

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < n; i += 2) {
            num1 = 10 * num1 + list.get(i);
            if (i < n - 1) {
                num2 = 10 * num2 + list.get(i + 1);
            }
        }

        return num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + splitNum(10));
        System.out.println("75 ?= " + splitNum(687));
        System.out.println("59 ?= " + splitNum(4325));
    }
}
