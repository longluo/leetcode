package com.longluo.contest.weekly_contest_310;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-310/
 */

/**
 * 2404. 出现最频繁的偶数元素
 * <p>
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * <p>
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * <p>
 * 示例 2：
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * <p>
 * 示例 3：
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 * <p>
 * 提示：
 * 1 <= nums.length <= 2000
 * 0 <= nums[i] <= 10^5
 * <p>
 * https://leetcode.cn/problems/most-frequent-even-element/
 */
public class Problem2404_mostFrequentEvenElement {

    // HashMap + Sort time: O(n+nlogn) space: O(n)
    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
            }
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(list, (a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

        return list.size() > 0 ? list.get(0)[0] : -1;
    }

    // HashMap time: O(n) space: O(n)
    public static int mostFrequentEven_hashmap(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (int x : nums) {
            if (x % 2 == 0) {
                int freq = countMap.getOrDefault(x, 0) + 1;
                if (freq > maxFreq) {
                    maxFreq = freq;
                    ans = x;
                } else if (freq == maxFreq) {
                    ans = Math.min(ans, x);
                }

                countMap.put(x, freq);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // PriorityQueue time: O(n + nlogn) space: O(n)
    public static int mostFrequentEven_pq(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] == p2[1] ? p1[0] - p2[0] : p2[1] - p1[1]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        return pq.size() > 0 ? pq.poll()[0] : -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));

        System.out.println("2 ?= " + mostFrequentEven_hashmap(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println("-1 ?= " + mostFrequentEven_hashmap(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));

        System.out.println("2 ?= " + mostFrequentEven_pq(new int[]{0, 1, 2, 2, 4, 4, 1}));
        System.out.println("-1 ?= " + mostFrequentEven_pq(new int[]{29, 47, 21, 41, 13, 37, 25, 7}));
    }
}
