package com.longluo.contest.biweekly_contest_85;

/**
 * https://leetcode.cn/contest/biweekly-contest-85/
 */

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * <p>
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。
 * 字符 'W' 和 'B' 分别表示白色和黑色。
 * <p>
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 * <p>
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 * <p>
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 * <p>
 * 示例 1：
 * 输入：blocks = "WBBWWBBWBW", k = 7
 * 输出：3
 * 解释：
 * 一种得到 7 个连续黑色块的方法是把第 0 ，3 和 4 个块涂成黑色。
 * 得到 blocks = "BBBBBBBWBW" 。
 * 可以证明无法用少于 3 次操作得到 7 个连续的黑块。
 * 所以我们返回 3 。
 * <p>
 * 示例 2：
 * 输入：blocks = "WBWBBBW", k = 2
 * 输出：0
 * 解释：
 * 不需要任何操作，因为已经有 2 个连续的黑块。
 * 所以我们返回 0 。
 * <p>
 * 提示：
 * n == blocks.length
 * 1 <= n <= 100
 * blocks[i] 要么是 'W' ，要么是 'B' 。
 * 1 <= k <= n
 * <p>
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 */
public class Problem2379_minimumRecolors {

    // BF time: O(n^2) space: O(1)
    // 2023年3月9日
    public static int minimumRecolors_bf(String blocks, int k) {
        int len = blocks.length();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= len - k; i++) {
            int cnt = 0;
            for (int j = 0; j < k; j++) {
                if (blocks.charAt(i + j) == 'W') {
                    cnt++;
                }
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    public static int minimumRecolors(String blocks, int k) {
        int len = blocks.length();

        int ans = k;

        for (int i = 0; i <= len - k; i++) {
            int cnt = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    cnt++;
                }
            }

            ans = Math.min(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minimumRecolors("WBWBBBW", 2));
        System.out.println("3 ?= " + minimumRecolors("WBBWWBBWBW", 7));

        System.out.println("0 ?= " + minimumRecolors_bf("WBWBBBW", 2));
        System.out.println("3 ?= " + minimumRecolors_bf("WBBWWBBWBW", 7));
        System.out.println("3 ?= " + minimumRecolors_bf("BWWWBB", 6));
    }
}
