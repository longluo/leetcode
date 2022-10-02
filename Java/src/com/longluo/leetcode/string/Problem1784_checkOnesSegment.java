package com.longluo.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1784. 检查二进制字符串字段
 * <p>
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * <p>
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 * <p>
 * 如果 s 中 由连续若干个 '1' 组成的字段 数量不超过 1，返回 true 。否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * <p>
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s[i] 为 '0' 或 '1'
 * s[0] 为 '1'
 * <p>
 * https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */
public class Problem1784_checkOnesSegment {

    // Simulate time: O(n) space: O(n)
    public static boolean checkOnesSegment(String s) {
        int len = s.length();

        List<Integer> cntList = new ArrayList<>();

        int idx = 0;
        while (idx < len) {
            int onesCnt = 0;
            while (idx < len && s.charAt(idx) == '1') {
                onesCnt++;
                idx++;
            }

            cntList.add(onesCnt);

            int zeroCnt = 0;
            while (idx < len && s.charAt(idx) == '0') {
                zeroCnt++;
                idx++;
            }

            cntList.add(zeroCnt);
        }

        return cntList.size() <= 2;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + checkOnesSegment("1001"));
        System.out.println("true ?= " + checkOnesSegment("110"));
        System.out.println("true ?= " + checkOnesSegment("111"));
        System.out.println("true ?= " + checkOnesSegment("0"));
        System.out.println("true ?= " + checkOnesSegment("1000"));
    }
}
