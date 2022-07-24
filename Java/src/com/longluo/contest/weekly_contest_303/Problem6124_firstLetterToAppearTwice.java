package com.longluo.contest.weekly_contest_303;

import java.util.*;

/**
 * 6124. 第一个出现两次的字母
 * <p>
 * 给你一个由小写英文字母组成的字符串 s ，请你找出并返回第一个出现 两次 的字母。
 * <p>
 * 注意：
 * 如果 a 的 第二次 出现比 b 的 第二次 出现在字符串中的位置更靠前，则认为字母 a 在字母 b 之前出现两次。
 * s 包含至少一个出现两次的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abccbaacz"
 * 输出："c"
 * 解释：
 * 字母 'a' 在下标 0 、5 和 6 处出现。
 * 字母 'b' 在下标 1 和 4 处出现。
 * 字母 'c' 在下标 2 、3 和 7 处出现。
 * 字母 'z' 在下标 8 处出现。
 * 字母 'c' 是第一个出现两次的字母，因为在所有字母中，'c' 第二次出现的下标是最小的。
 * <p>
 * 示例 2：
 * 输入：s = "abcdd"
 * 输出："d"
 * 解释：
 * 只有字母 'd' 出现两次，所以返回 'd' 。
 * <p>
 * 提示：
 * 2 <= s.length <= 100
 * s 由小写英文字母组成
 * s 包含至少一个重复字母
 * <p>
 * https://leetcode.cn/problems/first-letter-to-appear-twice/
 */
public class Problem6124_firstLetterToAppearTwice {

    // HashMap time: O(n) space: O(n)
    public static char repeatedCharacter(String s) {
        int len = s.length();
        if (len <= 2) {
            return s.charAt(0);
        }

        Map<Character, List<Integer>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(ch, new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.get(ch).add(i);
        }

        int min = len;
        char ans = ' ';
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> idxList = entry.getValue();
            if (idxList.size() >= 2) {
                int second = idxList.get(1);
                if (second < min) {
                    min = second;
                    ans = entry.getKey();
                }
            }
        }

        return ans;
    }

    // HashSet time: O(n) space: O(26)
    public static char repeatedCharacter_hashset(String s) {
        int len = s.length();
        int min = len;
        char ans = ' ';
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                if (i < min) {
                    min = i;
                    ans = ch;
                }
            } else {
                set.add(ch);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("c ?= " + repeatedCharacter("abccbaacz"));
        System.out.println("d ?= " + repeatedCharacter("abcdd"));

        System.out.println("c ?= " + repeatedCharacter_hashset("abccbaacz"));
        System.out.println("d ?= " + repeatedCharacter_hashset("abcdd"));
    }
}
