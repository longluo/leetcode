package com.longluo.studyplan.binary_search.i;

/**
 * 875. 爱吃香蕉的珂珂
 * <p>
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 示例 1：
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * <p>
 * 示例 3：
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * 提示：
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class Problem875_kokoEatingBananas {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;

        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (len >= h) {
            return max;
        }

        int ans = max;
        for (int i = 1; i < max; i++) {
            int cnt = 0;

            for (int j = 0; j < len; j++) {
                int mod = piles[j] % i;
                cnt += mod == 0 ? piles[j] / i : piles[j] / i + 1;
                if (cnt > h) {
                    break;
                }
            }

            if (cnt <= h) {
                ans = i;
                break;
            }
        }

        return ans;
    }

    // TLE
    // Worse than from small to big
    public static int minEatingSpeed_bf(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (piles.length >= h) {
            return max;
        }

        int ans = max;
        for (int i = max; i > 0; i--) {
            int cnt = 0;

            for (int pile : piles) {
                int mod = pile % i;
                cnt += mod == 0 ? pile / i : pile / i + 1;
            }

            if (cnt <= h) {
                ans = Math.min(ans, i);
            } else {
                break;
            }
        }

        return ans;
    }

    // BinarySearch time: O(nlogn) space: O(1)
    public static int minEatingSpeed_bs(int[] piles, int h) {
        int len = piles.length;

        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        if (len >= h) {
            return max;
        }

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int pile : piles) {
                int mod = pile % mid;
                cnt += mod == 0 ? pile / mid : pile / mid + 1;
            }

            if (cnt > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // BinarySearch Opt time: O(nlogn) space: O(1)
    // remove mod
    public static int minEatingSpeed_bs_opt(int[] piles, int h) {
        int max = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1;
        int right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;

            for (int pile : piles) {
                cnt += (pile + mid - 1) / mid;
            }

            if (cnt > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println("4 ?= " + minEatingSpeed_bf(new int[]{3, 6, 7, 11}, 8));

        System.out.println("4 ?= " + minEatingSpeed_bs(new int[]{3, 6, 7, 11}, 8));
        System.out.println("4 ?= " + minEatingSpeed_bs_opt(new int[]{3, 6, 7, 11}, 8));
    }
}
