package com.longluo.contest.weekly_contest_355;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-355
 */
public class Problem1 {

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            sb.append("\\").append(separator);
            String[] strs = word.split(sb.toString());

            for (String x : strs) {
                if (x != null && x.length() > 0) {
                    ans.add(x);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();
        tst1.add("one.two.three");
        tst1.add("four.five");
        tst1.add("six");

        System.out.println("[one, two, three, four, five, six] ?= " + splitWordsBySeparator(tst1, '.'));

        List<String> tst2 = new ArrayList<>();
        tst2.add("$easy$");
        tst2.add("$problem$");

        System.out.println(" " + splitWordsBySeparator(tst2, '$'));
    }
}
