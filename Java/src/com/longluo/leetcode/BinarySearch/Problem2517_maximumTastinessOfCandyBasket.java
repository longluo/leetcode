package com.longluo.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * 2517. 礼盒的最大甜蜜度
 * <p>
 * 给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。
 * <p>
 * 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。
 * <p>
 * 返回礼盒的 最大 甜蜜度。
 * <p>
 * 示例 1：
 * 输入：price = [13,5,1,8,21,2], k = 3
 * 输出：8
 * 解释：选出价格分别为 [13,5,21] 的三类糖果。
 * 礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
 * 可以证明能够取得的最大甜蜜度就是 8 。
 * <p>
 * 示例 2：
 * 输入：price = [1,3,1], k = 2
 * 输出：2
 * 解释：选出价格分别为 [1,3] 的两类糖果。
 * 礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
 * 可以证明能够取得的最大甜蜜度就是 2 。
 * <p>
 * 示例 3：
 * 输入：price = [7,7,7,7], k = 2
 * 输出：0
 * 解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 * <p>
 * 提示：
 * 1 <= price.length <= 10^5
 * 1 <= price[i] <= 10^9
 * 2 <= k <= price.length
 * <p>
 * https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/
 */
public class Problem2517_maximumTastinessOfCandyBasket {

    // BinarySearch time: O(nlogn) space: O(logn)
    public static int maximumTastiness(int[] price, int k) {
        int n = price.length;

        Arrays.sort(price);

        int min = Integer.MAX_VALUE;
        int max = price[n - 1] - price[0];

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, price[i + 1] - price[i]);
        }

        if (k == 2) {
            return max;
        } else if (k == n) {
            return min;
        }

        int left = min;
        int right = max;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            int cnt = 1;

            int prev = price[0];

            for (int i = 1; i < n; i++) {
                if (price[i] >= prev + mid) {
                    cnt++;
                    prev = price[i];
                }
            }

            if (cnt >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
        System.out.println("2 ?= " + maximumTastiness(new int[]{1, 3, 1}, 2));
        System.out.println("0 ?= " + maximumTastiness(new int[]{7, 7, 7, 7}, 2));
    }
}
