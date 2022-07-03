package com.longluo.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 397. 整数替换
 * <p>
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 * <p>
 * 示例 1：
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * <p>
 * 示例 2：
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * <p>
 * 示例 3：
 * 输入：n = 4
 * 输出：2
 * <p>
 * 提示：
 * 1 <= n <= 2^31 - 1
 * <p>
 * https://leetcode.com/problems/integer-replacement/
 */
public class Problem397_integerReplacement {

    // TODO: 2022/7/3  
    public static int integerReplacement_bf(int n) {
        if (n <= 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }

        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }

    public static int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        long start = 1;
        for (int i = 1; i <= 31; i++) {
            map.put(start, i - 1);
            start = start * 2;
        }

        long temp = n;
        while (temp > 1) {
            if (map.containsKey(temp)) {
                ans += map.get(temp);
                return ans;
            } else {
                long plus = temp + 1;
                long minus = temp - 1;
                if (map.containsKey(minus)) {
                    ans += map.get(minus) + 1;
                    return ans;
                } else if (map.containsKey(plus)) {
                    ans += map.get(plus) + 1;
                    return ans;
                }

                if (temp % 2 == 0) {
                    temp /= 2;
                    ans++;
                } else {
                    temp = minus;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + integerReplacement(1));
        System.out.println("1 ?= " + integerReplacement(2));
        System.out.println("2 ?= " + integerReplacement(3));
        System.out.println("2 ?= " + integerReplacement(4));
        System.out.println("3 ?= " + integerReplacement(6));

        System.out.println("4 ?= " + integerReplacement(7));
        System.out.println("3 ?= " + integerReplacement(8));
        System.out.println("12 ?= " + integerReplacement(1000));
        System.out.println("14 ?= " + integerReplacement(1234));
        System.out.println("16 ?= " + integerReplacement(10000));
        System.out.println("17 ?= " + integerReplacement(65535));
    }
}
