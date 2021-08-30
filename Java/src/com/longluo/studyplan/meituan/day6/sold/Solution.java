package com.longluo.studyplan.meituan.day6.sold;

import java.util.*;

/**
 * meituan-011. 搭配出售
 * <p>
 * 服装店新进了 a 条领带，b 条裤子，c 个帽子，d 件衬衫，现在要把这些搭配起来售卖。
 * 有三种搭配方式，一条领带和一件衬衫，一条裤子和一件衬衫，一个帽子和一件衬衫。
 * 卖出一套领带加衬衫可以得到 e 元，卖出一套裤子加衬衫可以得到 f 元，卖出一套帽子加衬衫可以得到 g 元。
 * 现在你需要输出最大获利。
 * <p>
 * 格式：
 * 输入：
 * - 一行 7 个整数分别表示 a, b, c, d, e, f, g 。
 * 输出：
 * - 最大获利。
 * <p>
 * 示例：
 * 输入：2 3 4 5 6 7 8
 * 输出：39
 * 解释：4 个帽子加 4 件衬衫获利 32 元，1 条裤子加 1 件衬衫获利 7 元，一共得到 39 元。
 * <p>
 * https://leetcode-cn.com/problems/0JzXQB/
 */
public class Solution {

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long max = 0;
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextInt();
        }
        long[][] prices = new long[3][2];
        for (int i = 0; i < 3; i++) {
            prices[i][0] = i;
            prices[i][1] = sc.nextInt();
        }
        Arrays.sort(prices, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                if (o1[1] == o2[1]) {
                    return (int) (o1[0] - o2[0]);
                }
                return (int) (o2[1] - o1[1]);
            }
        });
        for (int i = 0; i < 3; i++) {
            if (nums[3] >= nums[(int) prices[i][0]]) {
                max += nums[(int) prices[i][0]] * prices[i][1];
                nums[3] -= nums[(int) prices[i][0]];
            } else {
                max += nums[3] * prices[i][1];
                nums[3] = 0;
            }
        }
        System.out.println(max);
    }

    */

    public static void main(String[] args) {
        PriorityQueue<AbstractMap.SimpleEntry<Long, Long>> priorityQueue = new PriorityQueue<>(new Comparator<AbstractMap.SimpleEntry<Long, Long>>() {
            @Override
            public int compare(AbstractMap.SimpleEntry<Long, Long> o1, AbstractMap.SimpleEntry<Long, Long> o2) {
                return (int) (o2.getValue() - o1.getValue());
            }
        });

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);
        long c = Long.parseLong(str[2]);
        long d = Long.parseLong(str[3]);
        long e = Long.parseLong(str[4]);
        long f = Long.parseLong(str[5]);
        long g = Long.parseLong(str[6]);

        priorityQueue.add(new AbstractMap.SimpleEntry<>(a, e));
        priorityQueue.add(new AbstractMap.SimpleEntry<>(b, f));
        priorityQueue.add(new AbstractMap.SimpleEntry<>(c, g));

        long res = 0;
        while (d > 0 && !priorityQueue.isEmpty()) {
            Map.Entry<Long, Long> head = priorityQueue.poll();
            Long num = head.getKey();
            if (d <= num) {
                res += d * head.getValue();
                break;
            } else {
                res += num * head.getValue();
                d -= num;
            }
        }
        System.out.println(res);
    }
}
