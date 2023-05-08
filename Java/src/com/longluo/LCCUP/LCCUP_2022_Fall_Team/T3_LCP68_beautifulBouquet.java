package com.longluo.LCCUP.LCCUP_2022_Fall_Team;

import java.util.HashMap;
import java.util.Map;

/**
 * LCP 68. 美观的花束
 * <p>
 * 力扣嘉年华的花店中从左至右摆放了一排鲜花，记录于整型一维矩阵 flowers 中每个数字表示该位置所种鲜花的品种编号。
 * 你可以选择一段区间的鲜花做成插花，且不能丢弃。
 * <p>
 * 在你选择的插花中，如果每一品种的鲜花数量都不超过 cnt 朵，那么我们认为这束插花是 「美观的」。
 * <p>
 * 例如：[5,5,5,6,6] 中品种为 5 的花有 3 朵， 品种为 6 的花有 2 朵，每一品种 的数量均不超过 3
 * 请返回在这一排鲜花中，共有多少种可选择的区间，使得插花是「美观的」。
 * <p>
 * 注意：
 * 答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * 输入：flowers = [1,2,3,2], cnt = 1
 * 输出：8
 * 解释：相同的鲜花不超过 1 朵，共有 8 种花束是美观的；
 * 长度为 1 的区间 [1]、[2]、[3]、[2] 均满足条件，共 4 种可选择区间
 * 长度为 2 的区间 [1,2]、[2,3]、[3,2] 均满足条件，共 3 种可选择区间
 * 长度为 3 的区间 [1,2,3] 满足条件，共 1 种可选择区间。
 * 区间 [2,3,2],[1,2,3,2] 都包含了 2 朵鲜花 2 ，不满足条件。
 * 返回总数 4+3+1 = 8
 * <p>
 * 示例 2：
 * 输入：flowers = [5,3,3,3], cnt = 2
 * 输出：8
 * <p>
 * 提示：
 * 1 <= flowers.length <= 10^5
 * 1 <= flowers[i] <= 10^5
 * 1 <= cnt <= 10^5
 * <p>
 * https://leetcode.cn/problems/1GxJYY/
 */
public class T3_LCP68_beautifulBouquet {

    // BF time: O(n^3) space: O(n)
    // TLE
    public static int beautifulBouquet_bf(int[] flowers, int cnt) {
        int mod = 1_000_000_007;

        int len = flowers.length;

        int ans = len;

        for (int i = 0; i < len; i++) {
            for (int j = 2; j <= len && i + j <= len; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                boolean flag = true;
                for (int k = i; k < i + j && k < len; k++) {
                    int freq = map.getOrDefault(flowers[k], 0);
                    if (freq + 1 > cnt) {
                        flag = false;
                        break;
                    }

                    map.put(flowers[k], freq + 1);
                }

                if (flag) {
                    ans++;
                    ans = ans % mod;
                }
            }
        }

        return ans % mod;
    }

    // Two Pointers time: O(n) space: O(n)
    public static int beautifulBouquet_tp(int[] flowers, int cnt) {
        int mod = 1_000_000_007;

        int len = flowers.length;

        int ans = 0;

        int left = 0;
        int right = 0;

        Map<Integer, Integer> count = new HashMap<>();

        while (left <= right && right <= len) {
            while (right < len && count.getOrDefault(flowers[right], 0) <= cnt - 1) {
                count.put(flowers[right], count.getOrDefault(flowers[right], 0) + 1);
                right++;
            }

            ans += right - left;
            ans %= mod;

            count.put(flowers[left], count.get(flowers[left]) - 1);
            left++;
            if (left == len) {
                break;
            }
        }

        return ans % mod;
    }

    // Two Pointers Opt
    public static int beautifulBouquet_tp_opt(int[] flowers, int cnt) {
        int mod = 1_000_000_007;

        int len = flowers.length;
        int ans = 0;

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0, j = 0; i < len && j < len; j++) {
            int x = flowers[j];
            int freq = count.getOrDefault(x, 0);
            count.put(x, freq + 1);
            while (count.getOrDefault(x, 0) > cnt) {
                count.put(flowers[i], count.getOrDefault(flowers[i], 0) - 1);
                i++;
            }

            ans += j - i + 1;
            ans %= mod;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + beautifulBouquet_bf(new int[]{1, 2, 3, 2}, 1));

        System.out.println("8 ?= " + beautifulBouquet_tp(new int[]{1, 2, 3, 2}, 1));
        System.out.println("18 ?= " + beautifulBouquet_tp(new int[]{1, 10, 1, 10, 1, 10}, 2));

        System.out.println("18 ?= " + beautifulBouquet_tp_opt(new int[]{1, 10, 1, 10, 1, 10}, 2));
    }
}
