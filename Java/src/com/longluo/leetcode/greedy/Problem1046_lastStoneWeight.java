package com.longluo.leetcode.greedy;

import java.util.*;

/**
 * 1046. 最后一块石头的重量
 * <p>
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * <p>
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * <p>
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/last-stone-weight/
 */
public class Problem1046_lastStoneWeight {

    // BF time: O(nlogn) space: O(logn)
    public static int lastStoneWeight_bf(int[] stones) {
        int len = stones.length;
        if (len <= 1) {
            return stones[0];
        }

        while (true) {
            Arrays.sort(stones);
            if (stones[len - 1] > 0 && stones[len - 2] > 0) {
                stones[len - 2] = stones[len - 1] - stones[len - 2];
                stones[len - 1] = 0;
            } else if (stones[len - 2] == 0) {
                break;
            }
        }

        return stones[len - 1];
    }

    // List time: O(nlogn) space: O(n)
    public static int lastStoneWeight_list(int[] stones) {
        List<Integer> list = new ArrayList<>();

        for (int x : stones) {
            list.add(x);
        }

        while (list.size() > 1) {
            Collections.sort(list, Collections.reverseOrder());

            int first = list.get(0);
            int second = list.get(1);

            list.remove(Integer.valueOf(first));
            list.remove(Integer.valueOf(second));

            if (first > second) {
                list.add(first - second);
            }
        }

        return list.size() > 0 ? list.get(0) : 0;
    }

    // LinkedList time: O(nlogn) space: O(logn)
    public static int lastStoneWeight(int[] stones) {
        List<Integer> res = new LinkedList<>();

        for (int x : stones) {
            res.add(x);
        }

        while (res.size() > 1) {
            Collections.sort(res, Collections.reverseOrder());

            if (res.get(0).equals(res.get(1))) {
                res.remove(0);
                res.remove(0);
            } else {
                res.set(0, res.get(0) - res.get(1));
                res.remove(1);
            }
        }

        return res.size() > 0 ? res.get(0) : 0;
    }

    // Max Heap time: O(nlogn) space: O(n)
    public static int lastStoneWeight_pq(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int x : stones) {
            pq.offer(x);
        }

        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            if (a > b) {
                pq.offer(a - b);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + lastStoneWeight_bf(new int[]{2, 7, 4, 1, 8, 1}));

        System.out.println("1 ?= " + lastStoneWeight_list(new int[]{2, 7, 4, 1, 8, 1}));

        System.out.println("1 ?= " + lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("2 ?= " + lastStoneWeight(new int[]{1, 3}));
        System.out.println("0 ?= " + lastStoneWeight(new int[]{2, 2}));
        System.out.println("2 ?= " + lastStoneWeight(new int[]{10, 4, 2, 10}));

        System.out.println("1 ?= " + lastStoneWeight_pq(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println("2 ?= " + lastStoneWeight_pq(new int[]{1, 3}));
        System.out.println("0 ?= " + lastStoneWeight_pq(new int[]{2, 2}));
        System.out.println("2 ?= " + lastStoneWeight_pq(new int[]{10, 4, 2, 10}));
    }
}
