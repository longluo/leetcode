package com.longluo.offer;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 限制：
 * 1 <= s 的长度 <= 8
 * <p>
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class Offer38_permutation {

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }

        if (s.length() == 1) {
            return new String[]{s};
        }

        Set<String> res = new HashSet<>();
        int length = s.length();
        boolean[] vis = new boolean[length];
        backtrace(res, new StringBuilder(), vis, s.toCharArray(), 0, length);
        String[] ans = new String[res.size()];
        Iterator<String> iterator = res.iterator();
        int idx = 0;
        while (iterator.hasNext()) {
            ans[idx++] = iterator.next();
        }
        return ans;
    }

    public static void backtrace(Set<String> ans, StringBuilder one, boolean[] vis, char[] array, int idx, int length) {
        if (idx == length) {
            ans.add(one.toString());
            return;
        }

        for (int i = 0; i < length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            one.append(array[i]);
            backtrace(ans, one, vis, array, idx + 1, length);
            one.deleteCharAt(one.length() - 1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("[abc, acb, bac, bca, cab, cba] ?= " + Arrays.toString(permutation("abc")));
    }
}
