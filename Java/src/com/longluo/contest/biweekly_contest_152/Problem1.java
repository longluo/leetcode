package com.longluo.contest.biweekly_contest_152;

/**
 * 3483. 不同三位偶数的数目
 * <p>
 * 简单
 * <p>
 * 给你一个数字数组 digits，你需要从中选择三个数字组成一个三位偶数，你的任务是求出 不同 三位偶数的数量。
 * 注意：每个数字在三位偶数中都只能使用 一次 ，并且 不能 有前导零。
 * <p>
 * 示例 1：
 * 输入： digits = [1,2,3,4]
 * 输出： 12
 * 解释： 可以形成的 12 个不同的三位偶数是 124，132，134，142，214，234，312，314，324，342，412 和 432。注意，不能形成 222，因为数字 2 只有一个。
 * <p>
 * 示例 2：
 * 输入： digits = [0,2,2]
 * 输出： 2
 * 解释： 可以形成的三位偶数是 202 和 220。注意，数字 2 可以使用两次，因为数组中有两个 2 。
 * <p>
 * 示例 3：
 * 输入： digits = [6,6,6]
 * 输出： 1
 * 解释： 只能形成 666。
 * <p>
 * 示例 4：
 * 输入： digits = [1,3,5]
 * 输出： 0
 * 解释： 无法形成三位偶数。
 * <p>
 * 提示：
 * 3 <= digits.length <= 10
 * 0 <= digits[i] <= 9
 * <p>
 * https://leetcode.cn/problems/unique-3-digit-even-numbers/description/
 */
public class Problem1 {

    public static int totalNumbers(int[] digits) {
        int n = digits.length;
        boolean[] visited = new boolean[1000];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j || digits[k] % 2 != 0) {
                        continue;
                    }

                    int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (!visited[x]) {
                        visited[x] = true;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + totalNumbers(new int[]{1, 2, 3, 4}));
        System.out.println("2 ?= " + totalNumbers(new int[]{0, 2, 2}));
        System.out.println("1 ?= " + totalNumbers(new int[]{6, 6, 6}));
        System.out.println("0 ?= " + totalNumbers(new int[]{1, 3, 5}));
    }
}
