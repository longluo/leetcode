package com.longluo.leetcode.twopointers;

/**
 * 777. 在LR字符串中交换相邻字符
 * <p>
 * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，
 * 或者用一个"XR"替换一个"RX"。
 * 现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
 * <p>
 * 示例 :
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * <p>
 * 提示：
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 * <p>
 * https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */
public class Problem777_swapAdjacentInLRString {

    // Two Pointers
    public static boolean canTransform(String start, String end) {
        int len = start.length();

        int p = 0;
        int q = 0;

        while (p < len && q < len) {
            while (p < len && q < len && start.charAt(p) == end.charAt(q)) {
                p++;
                q++;
            }

            while (p < len && q < len && start.charAt(p) == 'X' && end.charAt(q) == 'L') {
                p++;
            }

            if (p + 1 < len && q + 1 < len && start.charAt(p + 1) == 'L' && end.charAt(q + 1) == 'X') {
                p += 2;
                q += 2;
            }

            while (p < len && q < len && start.charAt(p) == 'R' && end.charAt(q) == 'X') {
                q++;
            }

            if (p + 1 < len && q + 1 < len && start.charAt(p + 1) == 'X' && end.charAt(q + 1) == 'R') {
                p += 2;
                q += 2;
            }

            p++;
            q++;
        }

        return p == len && q == len;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + canTransform("X", "L"));
        System.out.println("true ?= " + canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println("true ?= " + canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
}
