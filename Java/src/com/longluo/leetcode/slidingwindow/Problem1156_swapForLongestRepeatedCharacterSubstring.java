package com.longluo.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 1156. 单字符重复子串的最大长度
 * <p>
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * 示例 1：
 * 输入：text = "ababa"
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：text = "aaabaaa"
 * 输出：6
 * <p>
 * 示例 3：
 * 输入：text = "aaabbaaa"
 * 输出：4
 * <p>
 * 示例 4：
 * 输入：text = "aaaaa"
 * 输出：5
 * <p>
 * 示例 5：
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * 提示：
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 * <p>
 * https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/
 */
public class Problem1156_swapForLongestRepeatedCharacterSubstring {

    // HashMap + SlidingWindow time: O(n) space: O(n)
    public static int maxRepOpt1(String text) {
        int left = getMaxRep(text);
        int right = getMaxRep(new StringBuilder(text).reverse().toString());

        return Math.max(left, right);
    }

    private static int getMaxRep(String text) {
        int maxFreq = 1;

        Map<Character, Integer> countMap = new HashMap<>();

        for (char ch : text.toCharArray()) {
            int freq = countMap.getOrDefault(ch, 0) + 1;
            countMap.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        int n = text.length();

        if (countMap.size() == 1) {
            return n;
        } else if (countMap.size() == n) {
            return 1;
        }

        int ans = 1;

        int left = 0;
        int right = left + 1;

        while (left < right && right < n) {
            char ch = text.charAt(left);

            int cnt = 1;

            int freq = countMap.get(ch);

            while (right < n && text.charAt(right) == ch) {
                right++;
                cnt++;
            }

            if (right < n && text.charAt(right) != ch && cnt < freq) {
                right++;
                cnt++;
            }

            while (right < n && text.charAt(right) == ch) {
                right++;
                cnt++;
            }

            if (cnt > freq) {
                cnt = freq;
            }

            ans = Math.max(ans, cnt);

            left++;
            right = left + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxRepOpt1("ababa"));
        System.out.println("3 ?= " + maxRepOpt1("aabbaba"));
        System.out.println("4 ?= " + maxRepOpt1("acbaaa"));
        System.out.println("6 ?= " + maxRepOpt1("aaabaaa"));
        System.out.println("4 ?= " + maxRepOpt1("aaabbaaa"));
        System.out.println("5 ?= " + maxRepOpt1("aaaaa"));
        System.out.println("1 ?= " + maxRepOpt1("abcdef"));
    }
}
