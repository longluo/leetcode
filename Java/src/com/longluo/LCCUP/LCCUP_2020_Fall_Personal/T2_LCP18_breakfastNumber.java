package com.longluo.LCCUP.LCCUP_2020_Fall_Personal;

import java.util.Arrays;

/**
 * LCP 18. 早餐组合
 * <p>
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。
 * <p>
 * 小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 * 输出：6
 * <p>
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 * <p>
 * 示例 2：
 * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
 * 输出：8
 * <p>
 * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
 * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
 * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
 * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
 * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
 * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
 * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
 * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
 * <p>
 * 提示：
 * 1 <= staple.length <= 10^5
 * 1 <= drinks.length <= 10^5
 * 1 <= staple[i],drinks[i] <= 10^5
 * 1 <= x <= 2*10^5
 * <p>
 * https://leetcode.cn/problems/2vYnGI/
 */
public class T2_LCP18_breakfastNumber {

    // BF time: O(mn) space: O(1)
    // TLE
    public static int breakfastNumber_bf(int[] staple, int[] drinks, int x) {
        int MOD = 1_000_000_007;

        int ans = 0;

        for (int i = 0; i < staple.length; i++) {
            for (int j = 0; j < drinks.length; j++) {
                if (staple[i] + drinks[j] <= x) {
                    ans++;
                    ans %= MOD;
                }
            }
        }

        return ans % MOD;
    }

    // Sort + Two Pointers time: O(nlogn + n) space: O(logn)
    public static int breakfastNumber(int[] staple, int[] drinks, int x) {
        int mod = 1_000_000_007;

        Arrays.sort(staple);
        Arrays.sort(drinks);

        int m = staple.length;
        int n = drinks.length;

        long ans = 0;

        for (int i = 0, j = n - 1; i < m; i++) {
            while (j >= 0 && staple[i] + drinks[j] > x) {
                j--;
            }

            if (j < 0) {
                break;
            }

            ans += (j + 1);
            ans %= mod;
        }

        return (int) ans;
    }

    // BinarySearch time: O(nlogn) space: O(logn)
    public static int breakfastNumber_bs(int[] staple, int[] drinks, int x) {
        int mod = 1_000_000_007;

        Arrays.sort(staple);
        Arrays.sort(drinks);

        long ans = 0;

        int foodMax = binarySearch(staple, x - drinks[0]);
        for (int i = 0; i <= foodMax; i++) {
            int drink = binarySearch(drinks, x - staple[i]);
            ans += drink + 1;
            ans %= mod;
        }

        return (int) ans;
    }

    private static int binarySearch(int[] arr, int target) {
        if (arr[0] > target) {
            return -1;
        } else if (arr[arr.length - 1] <= target) {
            return arr.length - 1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println("8 ?= " + breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
        System.out.println("8 ?= " + breakfastNumber_bs(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
        System.out.println("8 ?= " + breakfastNumber_bf(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));
    }
}
