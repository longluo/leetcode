package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 1781. 所有子字符串美丽值之和
 * <p>
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * <p>
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * <p>
 * 示例 1：
 * 输入：s = "aabcb"
 * 输出：5
 * 解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。
 * <p>
 * 示例 2：
 * 输入：s = "aabcbaa"
 * 输出：17
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/sum-of-beauty-of-all-substrings/
 */
public class Problem1781_sumofBeautyofAllSubstrings {

    // BF time: O(n^3) space: O(n)
    // TLE
    public static int beautySum_bf(String s) {
        char[] array = s.toCharArray();

        int len = s.length();

        int ans = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j < len; j++) {
                ans += calcBeautySum(array, i, j);
            }
        }

        return ans;
    }

    private static int calcBeautySum(char[] arr, int left, int right) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = left; i <= right; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if (map.size() <= 1) {
            return 0;
        }

        int max = 0;
        int min = arr.length;

        for (int x : map.values()) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }

        return max - min;
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + beautySum_bf("aabcb"));
        System.out.println("17 ?= " + beautySum_bf("aabcbaa"));
    }
}
