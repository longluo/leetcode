package com.longluo.studyplan.meituan.day5.divisor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * meituan-009. 小团的装饰物
 * <p>
 * 小团正在装饰自己的书桌，他的书桌上从左到右有 m 个空位需要放上装饰物。商店中每个整数价格的装饰物恰好有一种，
 * 且每种装饰物的数量无限多。
 * 小团去商店的时候，想到了一个购买方案，他要让右边的装饰物价格是左边的倍数。用数学语言来说，
 * 假设小团的 m 个装饰物价格为 a[1], a[2], ..., a[m] ，那么对于任意的 1≤i≤j≤m ，a[j] 是 a[i] 的倍数。
 * 小团是一个节约的人，他希望最贵的装饰物不超过 n 元。现在，请你计算小团有多少种购买的方案？
 * <p>
 * 格式：
 * 输入：
 * - 输入包含两个数，n 和 m 。
 * 输出：
 * - 输出一个数，结果对 998244353 取模，表示购买的方案数。
 * <p>
 * 示例：
 * 输入：4 2
 * 输出：8
 * 解释：[1,1][1,2][1,3][1,4][2,2][2,4][3,3][4,4] 共 8 种。
 * <p>
 * 提示：
 * 对于 40% 的数据，n, m ≤ 10
 * 对于 100% 的数据，1 ≤ n, m ≤ 1000
 * <p>
 * https://leetcode-cn.com/problems/0VvYxa/
 */
public class Solution {

    static int MOD = 998244353;

    public static void main(String[] args) throws Exception {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = BR.readLine().split(" ");
        int max_price = Integer.parseInt(line1[0]);
        int m = Integer.parseInt(line1[1]);

        int[][] dp = new int[m + 1][max_price + 1];
        for (int pri = 1; pri < max_price + 1; pri++)
            dp[1][pri] = 1;
        for (int i = 2; i < m + 1; i++) {
            for (int base = 1; base < max_price + 1; base++) {
                for (int b = base; b < max_price + 1; b += base) {
                    dp[i][b] += dp[i - 1][base];
                    dp[i][b] %= MOD;
                }
            }
        }

        int res = 0;
        for (int pri = 1; pri < max_price + 1; pri++) {
            res += dp[m][pri];
            res %= MOD;
        }
        System.out.println(res);
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(permutation(2, 2));
        System.out.println(permutation(2, 3));

        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorList.add(i);
            }
        }

        int ans = 0;
        int size = divisorList.size();
        for (int i = 0; i < size; i++) {

        }

        System.out.println(ans);
    }
    */

    private static int permutation(int kinds, int boxes) {
        if (kinds == 1) {
            return 1;
        }
        if (boxes == 1) {
            return kinds;
        }
        return permutation(kinds, boxes - 1) + permutation(1, boxes);
    }

    private static int factorial(int n) {
        final int MOD = 998244353;
        if (n == 1) {
            return 1;
        }

        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            nums[i] = (nums[i - 1] * i) % MOD;
        }

        return nums[n];
    }
}
