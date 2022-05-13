package com.longluo.interview;

/**
 * 面试题 01.05. 一次编辑
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
 * 编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * <p>
 * https://leetcode-cn.com/problems/one-away-lcci/
 */
public class Interview_01_05_one_away_lcci {

    // Two Pointers time: O(n) space: O(1)
    public static boolean oneEditAway_tp(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        boolean flag = true;
        for (int i = 0, j = 0; i < len1 || j < len2; i++, j++) {
            if (i < len1 && j < len2 && first.charAt(i) == second.charAt(j)) {
                continue;
            }

            if (flag) {
                if (i + 1 < len1 && first.charAt(i + 1) == second.charAt(j)) {
                    i++;
                } else if (j + 1 < len2 && first.charAt(i) == second.charAt(j + 1)) {
                    j++;
                } else if (i + 1 < len1 && j + 1 < len2 && first.charAt(i + 1) == second.charAt(j + 1)) {
                    i++;
                    j++;
                }

                flag = false;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + oneEditAway_tp("ab", "bc"));
        System.out.println("true ?= " + oneEditAway_tp("pale", "ple"));
        System.out.println("false ?= " + oneEditAway_tp("intention", "execution"));
        System.out.println("false ?= " + oneEditAway_tp("pales", "pal"));
    }
}
