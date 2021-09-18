package com.longluo.leetcode.math;

/**
 * 292. Nim 游戏
 * <p>
 * 你和你的朋友，两个人一起玩 Nim 游戏：
 * <p>
 * 桌子上有一堆石头。
 * 你们轮流进行自己的回合，你作为先手。
 * 每一回合，轮到的人拿掉 1 - 3 块石头。
 * 拿掉最后一块石头的人就是获胜者。
 * <p>
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；
 * 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 4
 * 输出：false
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
 * 因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：n = 2
 * 输出：true
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * https://leetcode-cn.com/problems/nim-game/
 */
public class Problem292_nimGame {

    public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }

        if (n % 4 == 0) {
            return false;
        }

        return true;
    }

    public static boolean canWinNim_2(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canWinNim(1));
        System.out.println("true ?= " + canWinNim(2));
        System.out.println("true ?= " + canWinNim(3));
        System.out.println("false ?= " + canWinNim(4));
        System.out.println("true ?= " + canWinNim(5));
        System.out.println("true ?= " + canWinNim(6));
        System.out.println("true ?= " + canWinNim(7));
        System.out.println("false ?= " + canWinNim(8));
        System.out.println("true ?= " + canWinNim(9));
        System.out.println("true ?= " + canWinNim(10));
        System.out.println("true ?= " + canWinNim(11));
        System.out.println("false ?= " + canWinNim(12));
    }
}
