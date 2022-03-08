package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子
 * <p>
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1:
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * <p>
 * 示例 2:
 * ex-2
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 * <p>
 * 提示：
 * 3 <= s.length <= 10^5
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 * <p>
 * https://leetcode-cn.com/problems/plates-between-candles/
 */
public class Problem2055_platesBetweenCandles {

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            String str = s.substring(queries[i][0], queries[i][1] + 1);
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                while (left < right && str.charAt(left) == '*') {
                    left++;
                }

                while (right > left && str.charAt(right) == '*') {
                    right--;
                }

                if (str.charAt(left) == '|' && str.charAt(right) == '|') {
                    for (int k = left; k < right; k++) {
                        if (str.charAt(k) == '*') {
                            ans[i]++;
                        }
                    }

                    break;
                }
            }
        }

        return ans;
    }

    public static int[] platesBetweenCandles_prefix(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = s.length();
        int[] prefixSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            while (left < right) {
                while (left < right && s.charAt(left) == '*') {
                    left++;
                }

                while (right > left && s.charAt(right) == '*') {
                    right--;
                }

                if (s.charAt(left) == '|' && s.charAt(right) == '|') {
                    ans[i] = prefixSum[right + 1] - prefixSum[left];
                    break;
                }
            }
        }

        return ans;
    }

    public static int[] platesBetweenCandles_bs(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        int len = s.length();
        int[] candlesSum = new int[len + 1];
        int[] platesSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '*') {
                platesSum[i + 1] = platesSum[i] + 1;
                candlesSum[i + 1] = candlesSum[i];
            } else {
                platesSum[i + 1] = platesSum[i];
                candlesSum[i + 1] = candlesSum[i] + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if (candlesSum[right + 1] - 1 <= candlesSum[left]) {
                ans[i] = 0;
                break;
            } else {
                while (left < right) {
                    while (left < right && s.charAt(left) == '*') {
                        left++;
                    }

                    while (right > left && s.charAt(right) == '*') {
                        right--;
                    }

                    if (s.charAt(left) == '|' && s.charAt(right) == '|') {
                        ans[i] = platesSum[right + 1] - platesSum[left];
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static int[] binarySearch(String s, int low, int high) {
        int[] ans = new int[2];
        if (s.charAt(low) == '|') {
            ans[0] = low;
        }
        if (s.charAt(high) == '|') {
            ans[1] = high;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] ?= " + Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
        System.out.println("[2, 3] ?= " + Arrays.toString(platesBetweenCandles_prefix("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
        System.out.println("[2, 3] ?= " + Arrays.toString(platesBetweenCandles_bs("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
    }
}
