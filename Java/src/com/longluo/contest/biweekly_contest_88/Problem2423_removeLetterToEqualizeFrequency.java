package com.longluo.contest.biweekly_contest_88;

/**
 * https://leetcode.cn/contest/biweekly-contest-88/
 */

/**
 * 2423. 删除字符使频率相同
 * <p>
 * 给你一个下标从 0 开始的字符串 word ，字符串只包含小写英文字母。你需要选择 一个 下标并 删除 下标处的字符，
 * 使得 word 中剩余每个字母出现 频率 相同。
 * <p>
 * 如果删除一个字母后，word 中剩余所有字母的出现频率都相同，那么返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * 字母 x 的 频率 是这个字母在字符串中出现的次数。
 * 你 必须 恰好删除一个字母，不能一个字母都不删除。
 * <p>
 * 示例 1：
 * 输入：word = "abcc"
 * 输出：true
 * 解释：选择下标 3 并删除该字母，word 变成 "abc" 且每个字母出现频率都为 1 。
 * <p>
 * 示例 2：
 * 输入：word = "aazz"
 * 输出：false
 * 解释：我们必须删除一个字母，所以要么 "a" 的频率变为 1 且 "z" 的频率为 2 ，要么两个字母频率反过来。所以不可能让剩余所有字母出现频率相同。
 * <p>
 * 提示：
 * 2 <= word.length <= 100
 * word 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/remove-letter-to-equalize-frequency/
 */
public class Problem2423_removeLetterToEqualizeFrequency {

    // Count time: O(n + C^2) space: O(C)
    private static boolean equalFrequency(String s) {
        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }

            int freq = cnt[i] - 1;
            boolean flag = true;

            for (int j = 0; j < 26; j++) {
                if (j != i && cnt[j] > 0 && freq == 0) {
                    freq = cnt[j];
                    continue;
                }

                if (j != i && cnt[j] > 0 && cnt[j] != freq) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + equalFrequency("abcc"));
        System.out.println("true ?= " + equalFrequency("bac"));
        System.out.println("false ?= " + equalFrequency("aazz"));
        System.out.println("false ?= " + equalFrequency("ddaccb"));
    }
}
