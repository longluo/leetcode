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

    public static boolean oneEditAway(String first, String second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null && second.length() <= 1) {
            return true;
        } else if (first.length() <= 1 && second == null) {
            return true;
        } else if (first.length() <= 1 && second.length() <= 1) {
            return true;
        }

        if (Math.abs(first.length() - second.length()) >= 2) {
            return false;
        }

        int len = Math.max(first.length(), second.length());
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                index = i;
                break;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + oneEditAway("pale", "ple"));
        System.out.println("false ?= " + oneEditAway("pales", "pal"));
    }
}
