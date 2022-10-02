package com.longluo.contest.weekly_contest_313;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {

    public static int commonFactors(int a, int b) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                set.add(i);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {

    }
}
