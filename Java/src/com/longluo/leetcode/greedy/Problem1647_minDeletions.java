package com.longluo.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1647. 字符频次唯一的最小删除次数
 * <p>
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * <p>
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * <p>
 * 示例 1：
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * <p>
 * 示例 2：
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * <p>
 * 示例 3：
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 仅含小写英文字母
 * <p>
 * https://leetcode.cn/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
public class Problem1647_minDeletions {

    // Greedy time: O(n + 26*log26) space: O(C)
    public static int minDeletions(String s) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        Arrays.sort(cnt);

        int ans = 0;
        int freq = cnt[25];
        for (int i = 24; i >= 0; i--) {
            if (cnt[i] == 0) {
                break;
            }

            if (freq == 0) {
                ans += cnt[i];
            } else {
                if (cnt[i] > freq) {
                    freq--;
                    ans += cnt[i] - freq;
                    cnt[i] = freq;
                } else if (cnt[i] == freq) {
                    freq--;
                    ans++;
                    cnt[i] = freq;
                } else {
                    freq = cnt[i];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minDeletions("bbcebab"));
        System.out.println("3 ?= " + minDeletions("abcabc"));
        System.out.println("0 ?= " + minDeletions("aab"));
        System.out.println("2 ?= " + minDeletions("aaabbbcc"));
        System.out.println("2 ?= " + minDeletions("ceabaacb"));
    }
}
