package com.longluo.leetcode.dp;

/**
 * 474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * <p>
 * 示例 2：
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * <p>
 * 提示：
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */
public class Problem474_onesAndZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }

        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {
            int[] temp = getOnesAndZeroes(strs[i - 1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= temp[0] && k >= temp[1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - temp[0]][k - temp[1]] + 1);
                    }
                }
            }
        }

        return dp[len][m][n];
    }

    public static int[] getOnesAndZeroes(String str) {
        int[] nums = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                nums[0]++;
            } else {
                nums[1]++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println("2 ?= " + findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }
}
