package com.longluo.contest.weekly_contest_312;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-312/
 */

/**
 * 2418. 按身高排序
 * <p>
 * 给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * 示例 1：
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * <p>
 * 示例 2：
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * 提示：
 * n == names.length == heights.length
 * 1 <= n <= 103
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 10^5
 * names[i] 由大小写英文字母组成
 * heights 中的所有值互不相同
 * <p>
 * https://leetcode.cn/problems/sort-the-people/
 */
public class Problem2418_sortThePeople {

    // Sort time: O(nlogn) space: O(n)
    public static String[] sortPeople(String[] names, int[] heights) {
        int len = names.length;
        String[][] sorted = new String[len][2];

        for (int i = 0; i < len; i++) {
            sorted[i][0] = names[i];
            sorted[i][1] = String.valueOf(heights[i]);
        }

        Arrays.sort(sorted, (a, b) -> {
            int h1 = Integer.parseInt(a[1]);
            int h2 = Integer.parseInt(b[1]);
            return h2 - h1;
        });

        for (int i = 0; i < len; i++) {
            names[i] = sorted[i][0];
        }

        return names;
    }

    // Opt time: O(nlogn) space: O(n)
    public static String[] sortPeople_opt(String[] names, int[] heights) {
        int n = names.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> heights[b] - heights[a]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {
            ans[i] = names[indices[i]];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[Mary, Emma, John] ?= " + Arrays.toString(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
        System.out.println("[Mary, Emma, John] ?= " + Arrays.toString(sortPeople_opt(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
}
