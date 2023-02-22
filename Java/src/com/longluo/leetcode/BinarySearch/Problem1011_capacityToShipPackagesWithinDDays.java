package com.longluo.leetcode.BinarySearch;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * <p>
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10)
 * 是不允许的。
 * <p>
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 * <p>
 * https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days/
 */
public class Problem1011_capacityToShipPackagesWithinDDays {

    // BF time: O(mn) space: O(1)
    // AC
    public static int shipWithinDays_bf(int[] weights, int days) {
        int sum = 0;
        int max = 0;

        for (int x : weights) {
            sum += x;
            max = Math.max(max, x);
        }

        int start = Math.max(max, sum / days);
        int ans = start;
        for (int i = start; i <= sum; i++) {
            int cnt = 1;
            int remain = i;
            for (int j = 0; j < weights.length; j++) {
                if (remain < weights[j]) {
                    remain = i - weights[j];
                    cnt++;
                } else {
                    remain -= weights[j];
                }
            }

            if (cnt <= days) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // Binary Search Optimize
    private static boolean feasible(int[] weights, int c, int days) {
        int daysNeeded = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > c) {
                daysNeeded++;
                currentLoad = weight;
            }
        }

        return daysNeeded <= days;
    }

    public static int shipWithinDays_bs(int[] weights, int days) {
        int totalLoad = 0;
        int maxLoad = 0;

        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }

        int l = Math.max(maxLoad, totalLoad / days);
        int r = Math.min(totalLoad, totalLoad / days + maxLoad);

        while (l < r) {
            int mid = (l + r) / 2;
            if (feasible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static int shipWithinDays(int[] weights, int D) {
        if (weights == null || weights.length == 0 || D <= 0) {
            return 0;
        }

        if (weights.length == 1 && D == 1) {
            return weights[0];
        }

        int maxPackage = 0;
        int sumPackage = 0;
        for (int i = 0; i < weights.length; i++) {
            sumPackage += weights[i];
            if (weights[i] > maxPackage) {
                maxPackage = weights[i];
            }
        }

        if (D == 1) {
            return sumPackage;
        }

        int ans = 0;
        int low = maxPackage;
        int high = sumPackage;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, D, mid)) {
                high = mid;
                ans = mid;
                if (!canShip(weights, D, mid - 1)) {
                    return ans;
                }
            } else if (!canShip(weights, D, mid)) {
                low = mid;
            }
        }

        return ans;
    }

    public static boolean canShip(int[] weights, int D, int cap) {
        int idx = 0;
        for (int i = 0; i < D; i++) {
            int capTemp = cap;
            while (idx < weights.length && capTemp - weights[idx] >= 0) {
                capTemp -= weights[idx];
                idx++;
                if (idx >= weights.length) {
                    return true;
                }
            }
        }

        if (idx < weights.length - 1) {
            return false;
        }

        return false;
    }

    public static int shipWithinDays_answer(int[] weights, int D) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while (low < high) {
            int mid = low + (high - low) / 2;

            int need = 1;
            int cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }

            if (need <= D) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println("3 ?= " + shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println("15 ?= " + shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));

        System.out.println("6 ?= " + shipWithinDays_answer(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println("3 ?= " + shipWithinDays_answer(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println("15 ?= " + shipWithinDays_answer(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));

        System.out.println("6 ?= " + shipWithinDays_bf(new int[]{3, 2, 2, 4, 1, 4}, 3));
        System.out.println("3 ?= " + shipWithinDays_bf(new int[]{1, 2, 3, 1, 1}, 4));
        System.out.println("15 ?= " + shipWithinDays_bf(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }
}
