package com.longluo.top100;

/**
 * 72. 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/edit-distance/
 */
public class Problem72_editDistance {

    /**
     * 讲一下我自己对状态转移方程的理解,麻烦大家看看我说得对不对有没有道理:
     * (一)、当word1[i]==word2[j]时,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,
     * 由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
     * (二)、当word1[i]!=word2[j]时,可以进行的操作有3个:
     *       ① 替换操作:可能word1的0~i-1位置与word2的0~j-1位置的字符都相同,
     *            只是当前位置的字符不匹配,进行替换操作后两者变得相同,
     *            所以此时dp[i][j]=dp[i-1][j-1]+1(这个加1代表执行替换操作)
     *       ②删除操作:若此时word1的0~i-1位置与word2的0~j位置已经匹配了,
     *          此时多出了word1的i位置字符,应把它删除掉,才能使此时word1的0~i(这个i是执行了删除操作后新的i)
     *          和word2的0~j位置匹配,因此此时dp[i][j]=dp[i-1][j]+1(这个加1代表执行删除操作)
     *       ③插入操作:若此时word1的0~i位置只是和word2的0~j-1位置匹配,
     *           此时只需要在原来的i位置后面插入一个和word2的j位置相同的字符使得
     *           此时的word1的0~i(这个i是执行了插入操作后新的i)和word2的0~j匹配得上,
     *           所以此时dp[i][j]=dp[i][j-1]+1(这个加1代表执行插入操作)
     *       ④由于题目所要求的是要最少的操作数:所以当word1[i] != word2[j] 时,
     *           需要在这三个操作中选取一个最小的值赋格当前的dp[i][j]
     * (三)总结:状态方程为:
     * if(word1[i] == word2[j]):
     *       dp[i][j] = dp[i-1][j-1]
     * else:
     *        min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
     */
    // DP time: O(mn) space: O(mn)
    public static int minDistance_dp(String word1, String word2) {
        int sLen = word1.length();
        int tLen = word2.length();

        int[][] dp = new int[sLen + 1][tLen + 1];

        for (int i = 1; i <= sLen; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= tLen; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minDistance_dp("horse", "ros"));
        System.out.println("5 ?= " + minDistance_dp("intention", "execution"));
    }
}
