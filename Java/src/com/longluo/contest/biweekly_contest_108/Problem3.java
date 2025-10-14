package com.longluo.contest.biweekly_contest_108;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/contest/biweekly-contest-108
 */
public class Problem3 {

    public static int minimumBeautifulSubstrings(String s) {
        if (s.charAt(0) == '0') {
            return -1;
        }

        List<Integer> lens = new ArrayList<>();
        Set<String> exists = new HashSet<>();
        for (int i = 1, j = 1; i <= 6; i++, j *= 5) {
            String bi = Integer.toBinaryString(j);
            exists.add(bi);
            lens.add(bi.length());
        }

        if (exists.contains(s)) {
            return 1;
        }

        int ans = 0;

        for (int i = 0; i < s.length(); ) {

            for (int j = lens.size() - 1; j >= 0; j--) {
                if (i + lens.get(j) > s.length()) {
                    continue;
                }

                String substr = s.substring(i, i + lens.get(j));
                if (exists.contains(substr)) {
                    ans++;
                    i += lens.get(j);
                }
            }
        }

        return ans > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + minimumBeautifulSubstrings("0"));
        System.out.println("3 ?= " + minimumBeautifulSubstrings("111"));
        System.out.println("2 ?= " + minimumBeautifulSubstrings("1011"));
    }
}
