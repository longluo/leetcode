package com.longluo.leetcode.array;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，
 * 所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * <p>
 * 示例：
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * <p>
 * 提示：
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 */
public class Problem1052_maxSatisfied {

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }

        int ans = 0;
        int length = customers.length;

        for (int i = 0; i < length; i++) {
            int total = 0;
            int idx = i;
            for (int k = 0; k < idx; k++) {
                if (grumpy[k] == 0) {
                    total += customers[k];
                }
            }

            int remain = X;
            while (idx < length && remain > 0) {
                total += customers[idx];
                remain--;
                idx++;
            }

            for (int j = idx; j < length; j++) {
                if (grumpy[j] == 0) {
                    total += customers[j];
                }
            }

            ans = Math.max(ans, total);
        }

        return ans;
    }

    public static int maxSatisfied_N(int[] customers, int[] grumpy, int X) {
        if (customers == null || customers.length == 0) {
            return 0;
        }

        int ans = 0;
        int length = customers.length;
        int left = 0;
        int right = 0;
        int total = 0;

        for (int i = 0; i < length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }

        while (left < length && right < length && left <= right) {

            while (right < length && X > 0) {
                if (grumpy[right] == 1) {
                    total += customers[right];
                }
                X--;
                right++;
            }

            ans = Math.max(ans, total);

            while (left < length && right < length) {
                if (grumpy[right] == 1) {
                    total += customers[right];
                }
                right++;

                if (grumpy[left] == 1) {
                    total -= customers[left];
                }
                left++;

                ans = Math.max(ans, total);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("16 ?= " + maxSatisfied(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println("23 ?= " + maxSatisfied(new int[]{3, 8, 8, 7, 1}, new int[]{1, 1, 1, 1, 1}, 3));

        System.out.println("16 ?= " + maxSatisfied_N(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3));
        System.out.println("23 ?= " + maxSatisfied_N(new int[]{3, 8, 8, 7, 1}, new int[]{1, 1, 1, 1, 1}, 3));
    }
}
