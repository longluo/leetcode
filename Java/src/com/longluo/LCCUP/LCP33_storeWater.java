package com.longluo.LCCUP;

import java.util.PriorityQueue;

/**
 * LCP 33. 蓄水
 * <p>
 * 给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。
 * <p>
 * 小扣有以下两种操作：
 * <p>
 * 升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
 * 蓄水：将全部水桶接满水，倒入各自对应的水缸
 * <p>
 * 每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
 * <p>
 * 注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
 * <p>
 * 示例 1：
 * 输入：bucket = [1,3], vat = [6,8]
 * 输出：4
 * <p>
 * 解释：
 * 第 1 次操作升级 bucket[0]；
 * 第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
 * vat1.gif
 * <p>
 * 示例 2：
 * 输入：bucket = [9,0,1], vat = [0,2,2]
 * 输出：3
 * <p>
 * 解释：
 * 第 1 次操作均选择升级 bucket[1]
 * 第 2~3 次操作选择蓄水，即可完成蓄水要求。
 * <p>
 * 提示：
 * 1 <= bucket.length == vat.length <= 100
 * 0 <= bucket[i], vat[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/o8SXZn/
 */
public class LCP33_storeWater {

    // Greedy + Heap time: O(nlogn) space: O(n)
    public static int storeWater(int[] bucket, int[] vat) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int len = bucket.length;

        int min = 0;
        int max = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (vat[i] == 0) {
                continue;
            }

            if (bucket[i] == 0) {
                bucket[i]++;
                min++;
                pq.offer(new int[]{i, vat[i]});
            } else {
                int times = (vat[i] + bucket[i] - 1) / bucket[i];
                pq.offer(new int[]{i, times});
            }
        }

        while (!pq.isEmpty()) {
            int[] mostTimes = pq.poll();

            int idx = mostTimes[0];
            int needTimes = mostTimes[1];

            if (min >= max) {
                return max;
            }
            max = Math.min(max, needTimes + min);

            bucket[idx]++;
            min++;

            int nowNeedTimes = (vat[idx] + bucket[idx] - 1) / bucket[idx];
            pq.offer(new int[]{idx, nowNeedTimes});
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + storeWater(new int[]{1, 3}, new int[]{6, 8}));
        System.out.println("3 ?= " + storeWater(new int[]{9, 0, 1}, new int[]{0, 2, 2}));
    }
}
