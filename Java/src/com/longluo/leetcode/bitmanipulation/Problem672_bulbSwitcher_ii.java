package com.longluo.leetcode.bitmanipulation;

/**
 * 672. 灯泡开关 Ⅱ
 * <p>
 * 房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。
 * <p>
 * 这 4 个开关各自都具有不同的功能，其中：
 * <p>
 * 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开）
 * 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...）
 * 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...）
 * 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...）
 * 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。
 * <p>
 * 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。
 * <p>
 * 示例 1：
 * 输入：n = 1, presses = 1
 * 输出：2
 * 解释：状态可以是：
 * - 按压开关 1 ，[关]
 * - 按压开关 2 ，[开]
 * <p>
 * 示例 2：
 * 输入：n = 2, presses = 1
 * 输出：3
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关]
 * - 按压开关 2 ，[开, 关]
 * - 按压开关 3 ，[关, 开]
 * <p>
 * 示例 3：
 * 输入：n = 3, presses = 1
 * 输出：4
 * 解释：状态可以是：
 * - 按压开关 1 ，[关, 关, 关]
 * - 按压开关 2 ，[关, 开, 关]
 * - 按压开关 3 ，[开, 关, 开]
 * - 按压开关 4 ，[关, 开, 开]
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * 0 <= presses <= 1000
 * <p>
 * https://leetcode.cn/problems/bulb-switcher-ii/
 */
public class Problem672_bulbSwitcher_ii {

    // TODO: 2022/9/15
    public static int flipLights(int n, int presses) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + flipLights(1, 1));
        System.out.println("4 ?= " + flipLights(3, 1));
    }
}
