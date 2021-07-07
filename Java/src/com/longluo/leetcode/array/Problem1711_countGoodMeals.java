package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1711. 大餐计数
 * <p>
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第i道餐品的美味程度餐品的美味程度，
 * 返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 * <p>
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * <p>
 * 示例 1：
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * <p>
 * 示例 2：
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 * <p>
 * 提示：
 * 1 <= deliciousness.length <= 10^5
 * 0 <= deliciousness[i] <= 2^20
 * <p>
 * https://leetcode-cn.com/problems/count-good-meals/
 */
public class Problem1711_countGoodMeals {

    public static int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int ans = 0;
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                if (isPowerOfTwo(sum)) {
                    ans++;
                }
            }
        }

        return ans % MOD;
    }

    public static boolean isPowerOfTwo(int number) {
        return number > 0 && (number & (number - 1)) == 0;
    }

    public static int countPairs_hash(int[] deliciousness) {
        int MOD = 1000000007;
        int ans = 0;
        int n = deliciousness.length;
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, deliciousness[i]);
        }
        int maxSum = maxVal * 2;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int sum = 1; sum <= maxSum; sum = sum << 1) {
                int count = freqMap.getOrDefault(sum - deliciousness[i], 0);
                ans = (ans + count) % MOD;
            }
            freqMap.put(deliciousness[i], freqMap.getOrDefault(deliciousness[i], 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + countPairs(new int[]{1}));
        System.out.println("0 ?= " + countPairs_hash(new int[]{1}));
        System.out.println("1 ?= " + countPairs(new int[]{1, 1}));
        System.out.println("1 ?= " + countPairs_hash(new int[]{1, 1}));
        System.out.println("0 ?= " + countPairs(new int[]{1, 5}));
        System.out.println("0 ?= " + countPairs_hash(new int[]{1, 5}));
        System.out.println("4 ?= " + countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println("4 ?= " + countPairs_hash(new int[]{1, 3, 5, 7, 9}));
        System.out.println("15 ?= " + countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println("15 ?= " + countPairs_hash(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println("53 ?= " + countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}));
        System.out.println("53 ?= " + countPairs_hash(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}));
    }
}
