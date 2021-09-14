package com.longluo.leetcode.array;

import java.util.*;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * <p>
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * <p>
 * 示例 1：
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * <p>
 * 示例 2：
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class Problem524_findLongestWord {

    public static String findLongestWord(String s, List<String> dictionary) {
        if (dictionary == null || dictionary.size() == 0 || s == null || s.length() == 0) {
            return "";
        }

        List<String> ans = new ArrayList<>();
        for (String word : dictionary) {
            if (isSubString(s, word)) {
                ans.add(word);
            }
        }

        if (ans.size() > 0) {
            Collections.sort(ans, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }

                    return o2.length() - o1.length();
                }
            });

            return ans.get(0);
        }

        return "";
    }

    public static boolean isSubString(String src, String dest) {
        int srcIdx = 0;
        int destIdx = 0;

        while (srcIdx < src.length() && destIdx < dest.length()) {

            while (srcIdx < src.length() && destIdx < dest.length() && src.charAt(srcIdx) == dest.charAt(destIdx)) {
                srcIdx++;
                destIdx++;
            }

            if (destIdx == dest.length()) {
                return true;
            }

            while (srcIdx < src.length() && destIdx < dest.length() && src.charAt(srcIdx) != dest.charAt(destIdx)) {
                srcIdx++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();
        tst1.add("ale");
        tst1.add("apple");
        tst1.add("monkey");
        tst1.add("plea");
        System.out.println("apple ?= " + findLongestWord("abpcplea", tst1));
    }
}
