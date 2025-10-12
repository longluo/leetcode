package com.longluo.contest.biweekly_contest_107;

/**
 * 2746. 字符串连接删减字母
 * <p>
 * 中等
 * <p>
 * 给你一个下标从 0 开始的数组 words ，它包含 n 个字符串。
 * <p>
 * 定义 连接 操作 join(x, y) 表示将字符串 x 和 y 连在一起，得到 xy 。如果 x 的最后一个字符与 y 的第一个字符相等，连接后两个字符中的一个会被 删除 。
 * <p>
 * 比方说 join("ab", "ba") = "aba" ， join("ab", "cde") = "abcde" 。
 * <p>
 * 你需要执行 n - 1 次 连接 操作。令 str0 = words[0] ，从 i = 1 直到 i = n - 1 ，对于第 i 个操作，你可以执行以下操作之一：
 * <p>
 * 令 stri = join(stri - 1, words[i])
 * 令 stri = join(words[i], stri - 1)
 * 你的任务是使 strn - 1 的长度 最小 。
 * <p>
 * 请你返回一个整数，表示 strn - 1 的最小长度。
 * <p>
 * 示例 1：
 * 输入：words = ["aa","ab","bc"]
 * 输出：4
 * 解释：这个例子中，我们按以下顺序执行连接操作，得到 str2 的最小长度：
 * str0 = "aa"
 * str1 = join(str0, "ab") = "aab"
 * str2 = join(str1, "bc") = "aabc"
 * str2 的最小长度为 4 。
 * <p>
 * 示例 2：
 * 输入：words = ["ab","b"]
 * 输出：2
 * 解释：这个例子中，str0 = "ab"，可以得到两个不同的 str1：
 * join(str0, "b") = "ab" 或者 join("b", str0) = "bab" 。
 * 第一个字符串 "ab" 的长度最短，所以答案为 2 。
 * <p>
 * 示例 3：
 * 输入：words = ["aaa","c","aba"]
 * 输出：6
 * 解释：这个例子中，我们按以下顺序执行连接操作，得到 str2 的最小长度：
 * str0 = "aaa"
 * str1 = join(str0, "c") = "aaac"
 * str2 = join("aba", str1) = "abaaac"
 * str2 的最小长度为 6 。
 * <p>
 * <p>
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 50
 * words[i] 中只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/decremental-string-concatenation/description/
 * <p>
 * https://leetcode.cn/contest/biweekly-contest-107
 */
public class Problem3 {

    public static int minimizeConcatenatedLength(String[] words) {
        int n = words.length;

        String[][] dp = new String[n][2];

        dp[0][0] = words[0];
        dp[0][1] = words[0];

        for (int i = 1; i < n; i++) {
            String word = words[i];

            String prevJoin = dp[i - 1][0];
            String lastJoin = dp[i - 1][1];

            if (prevJoin.charAt(prevJoin.length() - 1) == word.charAt(0)) {
                dp[i][0] = prevJoin.substring(0, prevJoin.length() - 1) + word;
                dp[i][1] = word + prevJoin.substring(1);
            } else if (prevJoin.charAt(0) == word.charAt(word.length() - 1)) {
                dp[i][0] = prevJoin.substring(0, prevJoin.length() - 1) + word;
                dp[i][1] = word + prevJoin.substring(1);
            } else {
                dp[i][0] = prevJoin + word;
                dp[i][1] = lastJoin + word;
            }
        }

        return Math.min(dp[n - 1][0].length(), dp[n - 1][1].length());
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + minimizeConcatenatedLength(new String[]{"aa", "ab", "bc"}));
        System.out.println("2 ?= " + minimizeConcatenatedLength(new String[]{"ab", "b"}));
        System.out.println("6 ?= " + minimizeConcatenatedLength(new String[]{"aaa", "c", "aba"}));
    }
}
