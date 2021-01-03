package com.longluo.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 */
public class Offer38_permutation {

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }

        if (s.length() == 1) {
            return new String[]{s};
        }

        List<String> res = new ArrayList<>();

        return res.toArray(new String[res.size()]);
    }

    public static void backtrace(List<String> ans) {

    }

    public static void main(String[] args) {
        System.out.println("[abc, acb, bac, bca, cab, cba] ?=" + permutation("abc"));
    }
}
