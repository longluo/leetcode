package com.longluo.leetcode.dp;

/**
 * 583. 两个字符串的删除操作
 * <p>
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例 1：
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * <p>
 * 示例  2:
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * <p>
 * 提示：
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 * <p>
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 */
public class Problem583_deleteOperationForTwoStrings {

    // DP time: O(mn) space: O(mn)
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minDistance("sea", "eat"));
        System.out.println("4 ?= " + minDistance("leetcode", "etco"));
    }
}
