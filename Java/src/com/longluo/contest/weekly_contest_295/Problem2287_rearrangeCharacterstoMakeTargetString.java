package com.longluo.contest.weekly_contest_295;

import java.util.HashMap;
import java.util.Map;

/**
 * 2287.重排字符形成目标字符串
 * <p>
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 * <p>
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 * <p>
 * 示例 1：
 * 输入：s = "ilovecodingonleetcode", target = "code"
 * 输出：2
 * 解释：
 * 对于 "code" 的第 1 个副本，选取下标为 4 、5 、6 和 7 的字符。
 * 对于 "code" 的第 2 个副本，选取下标为 17 、18 、19 和 20 的字符。
 * 形成的字符串分别是 "ecod" 和 "code" ，都可以重排为 "code" 。
 * 可以形成最多 2 个 "code" 的副本，所以返回 2 。
 * <p>
 * 示例 2：
 * 输入：s = "abcba", target = "abc"
 * 输出：1
 * 解释：
 * 选取下标为 0 、1 和 2 的字符，可以形成 "abc" 的 1 个副本。
 * 可以形成最多 1 个 "abc" 的副本，所以返回 1 。
 * 注意，尽管下标 3 和 4 分别有额外的 'a' 和 'b' ，但不能重用下标 2 处的 'c' ，所以无法形成 "abc" 的第 2 个副本。
 * <p>
 * 示例 3：
 * 输入：s = "abbaccaddaeea", target = "aaaaa"
 * 输出：1
 * 解释：
 * 选取下标为 0 、3 、6 、9 和 12 的字符，可以形成 "aaaaa" 的 1 个副本。
 * 可以形成最多 1 个 "aaaaa" 的副本，所以返回 1 。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * 1 <= target.length <= 10
 * s 和 target 由小写英文字母组成
 * <p>
 * https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */
public class Problem2287_rearrangeCharacterstoMakeTargetString {

    // Count time: O(S + T + 26) space: O(26)
    public static int rearrangeCharacters(String s, String target) {
        int lenS = s.length();
        int lenT = target.length();
        if (lenT > lenS) {
            return 0;
        }

        int[] srcCnt = new int[26];
        for (char ch : s.toCharArray()) {
            srcCnt[ch - 'a']++;
        }

        int[] targetCnt = new int[26];
        for (char ch : target.toCharArray()) {
            targetCnt[ch - 'a']++;
        }

        int ans = 0;
        int max = lenS / lenT;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 26; j++) {
                if (srcCnt[j] >= targetCnt[j]) {
                    srcCnt[j] -= targetCnt[j];
                } else {
                    return ans;
                }
            }

            ans++;
        }

        return ans;
    }

    // Simulate time: O(S + T + 26) space: O(26)
    public static int rearrangeCharacters_opt(String s, String target) {
        int[] srcCnt = new int[26];
        for (char ch : s.toCharArray()) {
            srcCnt[ch - 'a']++;
        }

        int[] targetCnt = new int[26];
        for (char ch : target.toCharArray()) {
            targetCnt[ch - 'a']++;
        }

        int ans = s.length() / target.length();
        for (int i = 0; i < 26; i++) {
            if (targetCnt[i] > 0) {
                ans = Math.min(ans, srcCnt[i] / targetCnt[i]);
            }
        }

        return ans;
    }

    public static int rearrangeCharacters_hash(String s, String target) {
        if (s.length() < target.length()) {
            return 0;
        }

        Map<Character, Integer> srcMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            srcMap.put(ch, srcMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> tgtMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            tgtMap.put(ch, tgtMap.getOrDefault(ch, 0) + 1);
        }

        int ans = s.length() / target.length();
        for (char ch : tgtMap.keySet()) {
            ans = Math.min(ans, srcMap.getOrDefault(ch, 0) / tgtMap.get(ch));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + rearrangeCharacters("ilovecodingonleetcode", "code"));
        System.out.println("2 ?= " + rearrangeCharacters_opt("ilovecodingonleetcode", "code"));
        System.out.println("2 ?= " + rearrangeCharacters_hash("ilovecodingonleetcode", "code"));
    }
}
