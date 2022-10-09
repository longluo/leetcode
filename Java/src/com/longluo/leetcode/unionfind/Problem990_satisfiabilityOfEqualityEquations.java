package com.longluo.leetcode.unionfind;

/**
 * 990. 等式方程的可满足性
 * <p>
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
 * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * <p>
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 * <p>
 * 示例 2：
 * 输入：["b==a","a==b"]
 * 输出：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 * <p>
 * 示例 3：
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 * <p>
 * https://leetcode.cn/problems/satisfiability-of-equality-equations/
 */
public class Problem990_satisfiabilityOfEqualityEquations {

    // TODO: 2022/9/26
    public static boolean equationsPossible(String[] equations) {
        int len = equations.length;


        return false;
    }

    static class UnionFind {
        private int count;

        private char[] parent;
        private int[] size;

        UnionFind(int n) {
            this.count = n;
            parent = new char[n];
            size = new int[n];

        }

    }

    public static void main(String[] args) {
        System.out.println("false ?= " + equationsPossible(new String[]{"a==b", "b!=a"}));
        System.out.println("true ?= " + equationsPossible(new String[]{"a==b", "b==a"}));
        System.out.println("true ?= " + equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
    }
}
