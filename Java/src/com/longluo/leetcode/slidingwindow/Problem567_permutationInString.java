package com.longluo.leetcode.slidingwindow;

/**
 * 567. 字符串的排列
 * <p>
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 示例 1：
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 示例 2：
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 10^4
 * s1 和 s2 仅包含小写字母
 * <p>
 * https://leetcode.cn/problems/permutation-in-string/
 */
public class Problem567_permutationInString {

    // Count time: O(26n) space: O(26)
    public static boolean checkInclusion(String pat, String src) {
        if (pat.equals(src)) {
            return true;
        }

        int pLen = pat.length();
        int sLen = src.length();
        if (pLen > sLen) {
            return false;
        }

        int[] cnt = new int[26];
        for (char ch : pat.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int left = 0;
        int right = pLen;
        int[] winCnt = new int[26];
        for (int i = 0; i < right; i++) {
            winCnt[src.charAt(i) - 'a']++;
        }

        if (check(cnt, winCnt)) {
            return true;
        }

        while (left < right && right < sLen) {
            winCnt[src.charAt(left) - 'a']--;
            left++;
            winCnt[src.charAt(right) - 'a']++;
            right++;
            if (check(cnt, winCnt)) {
                return true;
            }
        }

        return false;
    }

    private static boolean check(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + checkInclusion("ab", "eidbaooo"));
    }
}
