package com.longluo.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 821. 字符的最短距离
 * <p>
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 * <p>
 * 示例 1：
 * 输入：s = "loveleetcode", c = "e"
 * 输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * 距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * 距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
 * 对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * 距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 * <p>
 * 示例 2：
 * 输入：s = "aaab", c = "b"
 * 输出：[3,2,1,0]
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s[i] 和 c 均为小写英文字母
 * 题目数据保证 c 在 s 中至少出现一次
 * <p>
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */
public class Problem821_shortestDistanceToACharacter {

    // BF time: O(n*k) space: O(k)
    public static int[] shortestToChar(String s, char c) {
        int len = s.length();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                indexes.add(i);
            }
        }

        int[] ans = new int[len];
        int k = indexes.size();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                continue;
            }

            int min = len;
            for (int j = 0; j < k; j++) {
                if (i <= indexes.get(0)) {
                    min = Math.abs(i - indexes.get(0));
                    break;
                } else if (i >= indexes.get(k - 1)) {
                    min = Math.abs(i - indexes.get(k - 1));
                    break;
                }

                int dist = Math.abs(i - indexes.get(j));
                min = Math.min(min, dist);
                if (indexes.get(j) - i >= dist) {
                    break;
                }
            }

            ans[i] = min;
        }

        return ans;
    }

    // Two Pointers time: O(n) space: O(n)
    public static int[] shortestToChar_tp(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        int p = 0;
        int q = 0;
        while (p < len && q < len) {
            while (q < len && s.charAt(q) != c) {
                q++;
            }

            if (s.charAt(p) == c) {
                ans[p] = 0;

                if (p > q) {
                    int mid = (p + q) / 2 + 1;
                    while (mid < p) {
                        ans[mid] = p - mid;
                        mid++;
                    }
                    q = p;
                }
            } else {
                ans[p] = Math.abs(q - p);
            }

            p++;
        }

        return ans;
    }

    // Reverse Scan time: O(n) space: O(n)
    public static int[] shortestToChar_scan(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        for (int i = 0, idx = -len; i < len; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }

            ans[i] = i - idx;
        }

        for (int i = len - 1, idx = 2 * len; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }

            ans[i] = Math.min(ans[i], idx - i);
        }

        return ans;
    }

    // Center time: O(n * k) space: O(1)
    public static int[] shortestToChar_center(String s, char c) {
        int len = s.length();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                continue;
            }

            int left = i;
            int right = i;
            int dist = len;
            while (left >= 0 || right < len) {
                if (s.charAt(left) == c) {
                    dist = i - left;
                    break;
                }

                if (s.charAt(right) == c) {
                    dist = right - i;
                    break;
                }

                if (left > 0) {
                    left--;
                }

                if (right < len - 1) {
                    right++;
                }
            }

            ans[i] = dist;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0] ?= " + Arrays.toString(shortestToChar("loveleetcode", 'e')));
        System.out.println("[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0] ?= " + Arrays.toString(shortestToChar_tp("loveleetcode", 'e')));
        System.out.println("[3, 2, 1, 0] ?= " + Arrays.toString(shortestToChar("aaab", 'b')));
        System.out.println("[3, 2, 1, 0] ?= " + Arrays.toString(shortestToChar_tp("aaab", 'b')));
        System.out.println("[3, 2, 1, 0] ?= " + Arrays.toString(shortestToChar_scan("aaab", 'b')));
        System.out.println("[3, 2, 1, 0] ?= " + Arrays.toString(shortestToChar_center("aaab", 'b')));
    }
}
