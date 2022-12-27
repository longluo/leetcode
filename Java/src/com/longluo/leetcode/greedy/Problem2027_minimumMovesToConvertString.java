package com.longluo.leetcode.greedy;

/**
 * 2027. 转换字符串的最少操作次数
 * <p>
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * <p>
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。
 * 注意，如果字符已经是 'O' ，只需要保持 不变 。
 * <p>
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * 示例 1：
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * <p>
 * 示例 2：
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 * <p>
 * 示例 3：
 * 输入：s = "OOOO"
 * 输出：0
 * 解释：s 中不存在需要转换的 'X' 。
 * <p>
 * 提示：
 * 3 <= s.length <= 1000
 * s[i] 为 'X' 或 'O'
 * <p>
 * https://leetcode.cn/problems/minimum-moves-to-convert-string/
 */
public class Problem2027_minimumMovesToConvertString {

    // BF time: O(n) space: O(1)
    public static int minimumMoves(String s) {
        int len = s.length();

        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'O') {
                continue;
            }

            boolean flag = false;
            for (int j = i; j < len && j < i + 3; j++) {
                if (s.charAt(j) == 'X') {
                    flag = true;
                    break;
                }
            }

            i += 2;
            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumMoves("XXX"));
        System.out.println("2 ?= " + minimumMoves("XXOX"));
        System.out.println("0 ?= " + minimumMoves("OOOO"));
        System.out.println("1 ?= " + minimumMoves("OXOX"));
        System.out.println("3 ?= " + minimumMoves("XOXXXOX"));
    }
}
