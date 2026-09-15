package com.longluo.contest.weekly_contest_319;

/**
 * 2472. 不重叠回文子字符串的最大数目
 * <p>
 * 困难
 * <p>
 * 给你一个字符串 s 和一个 正 整数 k 。
 * <p>
 * 从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串：
 * 每个子字符串的长度 至少 为 k 。
 * 每个子字符串是一个 回文串 。
 * 返回最优方案中能选择的子字符串的 最大 数目。
 * <p>
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * 示例 1 ：
 * 输入：s = "abaccdbbd", k = 3
 * 输出：2
 * 解释：可以选择 s = "abaccdbbd" 中斜体加粗的子字符串。"aba" 和 "dbbd" 都是回文，且长度至少为 k = 3 。
 * 可以证明，无法选出两个以上的有效子字符串。
 * <p>
 * 示例 2 ：
 * 输入：s = "adbcda", k = 2
 * 输出：0
 * 解释：字符串中不存在长度至少为 2 的回文子字符串。
 * <p>
 * 提示：
 * 1 <= k <= s.length <= 2000
 * s 仅由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings/description/
 */
public class Problem4 {

    public static int maxPalindromes(String s, int k) {
        int len = s.length();

        char[] array = s.toCharArray();

        int ans = 0;

        for (int i = 0; i <= len - k; i++) {
            for (int l = k; l <= len - i; l++) {
                if (check(array, i, i + l - 1)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static boolean check(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + maxPalindromes("abaccdbbd", 3));
        System.out.println("0 ?= " + maxPalindromes("adbcda", 2));
    }
}


