package com.longluo.contest.weekly_contest_310;

import java.util.*;

public class Problem1 {

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
        }

        List<int[]> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] == a[1] ? a[0] - b[0] : b[1] - a[1];
            }
        });

        return list.size() > 0 ? list.get(0)[0] : -1;
    }

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

    }
}
