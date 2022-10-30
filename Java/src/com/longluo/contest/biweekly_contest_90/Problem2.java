package com.longluo.contest.biweekly_contest_90;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/words-within-two-edits-of-dictionary/
 */
public class Problem2 {

    // BF time: O(n*k^2) space: O(n)
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        int len = queries.length;

        for (int i = 0; i < len; i++) {
            String s = queries[i];
            for (int j = 0; j < dictionary.length; j++) {
                if (check(s, dictionary[j])) {
                    ans.add(s);
                    break;
                }
            }
        }

        return ans;
    }

    private static boolean check(String src, String dest) {
        if (src.equals(dest)) {
            return true;
        }

        int len = src.length();

        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (src.charAt(i) != dest.charAt(i)) {
                cnt++;
            }
        }

        return cnt <= 2;
    }

    // Opt time: O(mkn) space: O(m)
    public static List<String> twoEditWords_opt(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String query : queries) {
            for (String dic : dictionary) {
                boolean flag = true;
                int cnt = 0;
                for (int i = 0; i < dic.length(); i++) {
                    if (query.charAt(i) != dic.charAt(i)) {
                        cnt++;
                        if (cnt > 2) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    ans.add(query);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[word, note, wood] ?= " + twoEditWords(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"}));
        System.out.println("[word, note, wood] ?= " + twoEditWords_opt(new String[]{"word", "note", "ants", "wood"}, new String[]{"wood", "joke", "moat"}));
    }
}
