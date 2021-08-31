package com.longluo.studyplan.meituan.day2.paotui;

import java.util.*;

/**
 * meituan-003. 小美的跑腿代购
 * <p>
 * 小美的一个兼职是美团的一名跑腿代购员，她有 n 个订单可以接，订单编号是 1~n ，但是因为订单的时效性，
 * 他只能选择其中 m 个订单接取，精明的小美当然希望自己总的获利是最大的，已知，一份订单会提供以下信息，跑腿价格 v ，
 * 商品重量 w kg，商品每重 1kg ，代购费用要加 2 元，而一份订单可以赚到的钱是跑腿价格和重量加价之和。
 * 小美可是开兰博基尼送货的人，所以自然不会在意自己会累这种事情。请问小美应该选择哪些订单，使得自己获得的钱最多。
 * 请你按照选择的订单编号的从小到大顺序，如果存在多种方案，输出订单编号字典序较小的方案。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含两个正整数 n，m，表示订单的数量和小美可以接的订单数量。
 * - 接下来有 n 行，第 i 行表示 i-1 号订单的信息。每行有两个正整数 v 和 w  ，表示一个订单的跑腿价格和商品重量。
 * 输出：
 * - 输出包含 m 个 1~n 之间的正整数，中间用空格隔开，表示选择的订单编号。
 * <p>
 * 示例：
 * 输入：
 * 5 2
 * 5 10
 * 8 9
 * 1 4
 * 7 9
 * 6 10
 * 输出：2 5
 * <p>
 * 提示：
 * 1 <= n, m <= 10000
 * 1 <= v, w <= 1000
 * <p>
 * https://leetcode-cn.com/problems/GXV5dX/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderTotal = scanner.nextInt();
        int orderAllow = scanner.nextInt();
        scanner.nextLine();
        int[][] orders = new int[orderTotal][2];
        for (int i = 0; i < orderTotal; i++) {
            orders[i][0] = scanner.nextInt();
            orders[i][1] = scanner.nextInt();
        }

        Queue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        for (int i = 0; i < orderTotal; i++) {
            int money = orders[i][0] + orders[i][1] * 2;
            priorityQueue.add(new int[]{i + 1, money});
        }

        int[] result = new int[orderAllow];
        int idx = 0;
        while (orderAllow-- > 0) {
            result[idx++] = priorityQueue.poll()[0];
        }
        Arrays.sort(result);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderTotal = scanner.nextInt();
        int orderAllow = scanner.nextInt();
        scanner.nextLine();
        List<int[]> orders = new ArrayList<>();
        for (int i = 0; i < orderTotal; i++) {
            int[] order = new int[3];
            order[0] = scanner.nextInt();
            order[1] = scanner.nextInt();
            order[2] = i + 1;
            orders.add(order);
        }

        Collections.sort(orders, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[0] + o1[1] * 2;
                int b = o2[0] + o2[1] * 2;
                if (a == b) {
                    return o1[2] - o2[2];
                }
                return b - a;
            }
        });

        int[] res = new int[orderAllow];
        for (int i = 0; i < orderAllow; i++) {
            res[i] = orders.get(i)[2];
        }
        Arrays.sort(res);
        for (int i = 0; i < orderAllow; i++) {
            System.out.print(res[i] + " ");
        }
    }
    */
}
