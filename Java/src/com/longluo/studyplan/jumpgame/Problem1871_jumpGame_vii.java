package com.longluo.studyplan.jumpgame;

/**
 * 1871. 跳跃游戏 VII
 * <p>
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。
 * 一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 * <p>
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * <p>
 * 示例 2：
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * <p>
 * 提示：
 * 2 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 * <p>
 * https://leetcode.cn/problems/jump-game-vii/
 */
public class Problem1871_jumpGame_vii {

    // TODO: 2022/8/24
    public static boolean canReach(String s, int minJump, int maxJump) {
        int len = s.length();
        if (s.charAt(len - 1) == '1') {
            return false;
        }

        if (minJump >= len - 1) {
            return true;
        }

        int[] prefixSums = new int[len];
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                prefixSums[i] = prefixSums[i - 1] + 1;
            } else {
                prefixSums[i] = prefixSums[i - 1];
            }
        }




        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canReach("011010", 2, 3));
    }
}
