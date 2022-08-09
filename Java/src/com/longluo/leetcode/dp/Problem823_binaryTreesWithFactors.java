package com.longluo.leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823. 带因子的二叉树
 * <p>
 * 给出一个含有不重复整数元素的数组 arr ，每个整数 arr[i] 均大于 1。
 * 用这些整数来构建二叉树，每个整数可以使用任意次数。其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
 * 满足条件的二叉树一共有多少个？答案可能很大，返回 对 109 + 7 取余 的结果。
 * <p>
 * 示例 1:
 * 输入: arr = [2, 4]
 * 输出: 3
 * 解释: 可以得到这些二叉树: [2], [4], [4, 2, 2]
 * <p>
 * 示例 2:
 * 输入: arr = [2, 4, 5, 10]
 * 输出: 7
 * 解释: 可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * 2 <= arr[i] <= 10^9
 * arr 中的所有值 互不相同
 * <p>
 * https://leetcode.cn/problems/binary-trees-with-factors/
 */
public class Problem823_binaryTreesWithFactors {

    // DP time: O(n^2) space: O(n)
    public static int numFactoredBinaryTrees(int[] arr) {
        int mod = 1_000_000_007;
        int len = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }

        long[] dp = new long[len];
        Arrays.fill(dp, 1);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int result = arr[i] / arr[j];
                    if (map.containsKey(result)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(result)]) % mod;
                    }
                }
            }
        }

        long ans = 0;
        for (long x : dp) {
            ans += x;
        }

        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numFactoredBinaryTrees(new int[]{2, 4}));
    }
}
