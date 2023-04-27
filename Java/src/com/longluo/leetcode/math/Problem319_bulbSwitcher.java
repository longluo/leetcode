package com.longluo.leetcode.math;

import java.util.Arrays;

/**
 * 319. 灯泡开关
 * <p>
 * 初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭一个。
 * 第三轮，你每三个灯泡就切换一个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换一个灯泡的开关。
 * 直到第 n 轮，你只需要切换最后一个灯泡的开关。
 * <p>
 * 找出并返回 n 轮后有多少个亮着的灯泡。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：1
 * 解释：
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭].
 * <p>
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 0 <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/bulb-switcher/
 */
public class Problem319_bulbSwitcher {

    public static int bulbSwitch(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 3) {
            return 1;
        }

        boolean[] bulps = new boolean[n];
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j + 1) % i == 0) {
                    bulps[j] = !bulps[j];
                }
            }
        }

        bulps[n - 1] = !bulps[n - 1];

        int ans = 0;
        for (boolean bulp : bulps) {
            if (!bulp) {
                ans++;
            }
        }

        return ans;
    }

    // Simulate time: O(n^2) space: O(n)
    public static int bulbSwitch_simu(int n) {
        if (n == 0) {
            return 0;
        }

        int[] bulps = new int[n];

        Arrays.fill(bulps, 1);

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    bulps[j - 1] = 1 - bulps[j - 1];
                }
            }
        }

        return Arrays.stream(bulps).sum();
    }

    // Math time: O(logn) space: O(1)
    public static int bulbSwitch_fast(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + bulbSwitch(0));
        System.out.println("1 ?= " + bulbSwitch(1));
        System.out.println("1 ?= " + bulbSwitch(2));
        System.out.println("1 ?= " + bulbSwitch(3));
        System.out.println("2 ?= " + bulbSwitch(4));
        System.out.println("2 ?= " + bulbSwitch(5));
        System.out.println("316 ?= " + bulbSwitch(99999));

        System.out.println("1 ?= " + bulbSwitch_simu(2));
        System.out.println("1 ?= " + bulbSwitch_simu(3));
        System.out.println("2 ?= " + bulbSwitch_simu(4));
        System.out.println("2 ?= " + bulbSwitch_simu(5));
        System.out.println("316 ?= " + bulbSwitch_simu(99999));

        System.out.println("316 ?= " + bulbSwitch_fast(99999));
    }
}
