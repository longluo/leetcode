package com.longluo.leetcode.recursion;

/**
 * 779. 第K个语法符号
 * <p>
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。
 * 接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * 示例 1:
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * <p>
 * 示例 2:
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 示例 3:
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 提示:
 * 1 <= n <= 30
 * 1 <= k <= 2^(n - 1)
 * <p>
 * https://leetcode.cn/problems/k-th-symbol-in-grammar/
 */
public class Problem779_kThSymbolInGrammar {

    // BF time: O(nm) space: O(mn)
    // Memory Out
    public static int kthGrammar_bf(int n, int k) {
        String[] symbols = new String[n];
        symbols[0] = "0";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : symbols[i - 1].toCharArray()) {
                if (ch == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }

            symbols[i] = sb.toString();
        }

        return symbols[n - 1].charAt(k - 1) - '0';
    }

    // Memory Out
    public static int kthGrammar_bf_opt(int n, int k) {
        String s = "0";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch == '0') {
                    sb.append("01");
                } else {
                    sb.append("10");
                }
            }

            s = sb.toString();
        }

        return s.charAt(k - 1) - '0';
    }

    // Recursion time: O(n) space: O(n)
    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int ret = kthGrammar(n - 1, (k + 1) / 2);
        if (ret == 0) {
            return k % 2 == 0 ? 1 : 0;
        } else {
            return k % 2 == 0 ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + kthGrammar_bf(1, 1));
        System.out.println("0 ?= " + kthGrammar_bf(2, 1));
        System.out.println("1 ?= " + kthGrammar_bf(2, 2));
        System.out.println("1 ?= " + kthGrammar_bf_opt(2, 2));

        System.out.println("0 ?= " + kthGrammar(1, 1));
        System.out.println("0 ?= " + kthGrammar(2, 1));
        System.out.println("1 ?= " + kthGrammar(2, 2));
        System.out.println("1 ?= " + kthGrammar(3, 2));
        System.out.println("1 ?= " + kthGrammar(3, 3));
        System.out.println("1 ?= " + kthGrammar(4, 5));
    }
}
