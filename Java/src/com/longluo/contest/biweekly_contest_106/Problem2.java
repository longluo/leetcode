package com.longluo.contest.biweekly_contest_106;

import java.util.HashMap;
import java.util.Map;

/**
 * 2730. 找到最长的半重复子字符串
 * <p>
 * <p>
 * https://leetcode.cn/contest/biweekly-contest-106
 * <p>
 * https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/
 */
public class Problem2 {

    public static int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();

        int left = 0;
        int right = 1;

        Map<Character, Integer> countMap = new HashMap<>();
        countMap.put(s.charAt(left), 1);

        int max = 0;
        int cnt = 0;

        while (left < right && right < n) {
            char ch = s.charAt(right);

            while (right < n && countMap.getOrDefault(s.charAt(right), 0) < 2 && cnt < 2) {
                int freq = countMap.getOrDefault(s.charAt(right), 0);

                if (freq == 1) {
                    cnt++;
                    if (cnt == 2) {
                        cnt--;
                        right--;
                        break;
                    }
                }

                countMap.put(s.charAt(right), freq + 1);
                right++;
            }


            max = Math.max(max, right - left);

            int leftFreq = countMap.get(s.charAt(left));
            if (leftFreq == 2) {
                cnt--;
            }
            countMap.put(s.charAt(left), leftFreq - 1);
            left++;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + longestSemiRepetitiveSubstring("52233"));
        System.out.println("4 ?= " + longestSemiRepetitiveSubstring("5494"));
        System.out.println("2 ?= " + longestSemiRepetitiveSubstring("1111111"));
    }
}
