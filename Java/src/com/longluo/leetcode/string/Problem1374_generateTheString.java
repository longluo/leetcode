package com.longluo.leetcode.string;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 * <p>
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * <p>
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出："pppz"
 * 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出："xy"
 * 解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
 * <p>
 * 示例 3：
 * 输入：n = 7
 * 输出："holasss"
 * <p>
 * 提示：
 * 1 <= n <= 500
 * <p>
 * https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
 */
public class Problem1374_generateTheString {

    // Simulate time: O(n) space: O(1)
    public static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder(n);
        int idx = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                sb.append((char) ('a' + idx));
                idx++;
                n--;
            } else {
                for (int i = 0; i < n; i++) {
                    sb.append((char) ('a' + idx));
                }
                n = 0;
            }
        }

        return sb.toString();
    }

    // Opt time: O(n) space: O(1)
    public static String generateTheString_opt(int n) {
        StringBuilder sb = new StringBuilder(n);
        if (n % 2 == 1) {
            return sb.append("a".repeat(n)).toString();
        }

        return sb.append("a".repeat(n - 1)).append("b").toString();
    }

    public static void main(String[] args) {
        System.out.println("ab ?= " + generateTheString(2));
        System.out.println("abbb ?= " + generateTheString(4));
        System.out.println("abbb ?= " + generateTheString_opt(4));
    }
}
