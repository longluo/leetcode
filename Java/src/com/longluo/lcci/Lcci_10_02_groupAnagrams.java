package com.longluo.lcci;

import com.longluo.datastructure.ArrayUtils;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * https://leetcode.cn/problems/group-anagrams-lcci/
 */
public class Lcci_10_02_groupAnagrams {

    // Count time: O(n^2) space: O(n)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        int len = strs.length;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> grp = new ArrayList<>();
            grp.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < len; j++) {
                if (!visited[j] && isAnagram(strs[i], strs[j])) {
                    grp.add(strs[j]);
                    visited[j] = true;
                }
            }

            ans.add(grp);
        }

        return ans;
    }

    private static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }

        for (int x : cnt) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[[eat, tea, ate][tan, nat][bat]] ?= " + ArrayUtils.print2DListString(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
    }
}
