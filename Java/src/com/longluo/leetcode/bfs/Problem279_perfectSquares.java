package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 279. 完全平方数
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，
 * 而 3 和 11 不是。
 * <p>
 * 示例 1：
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * 1 <= n <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class Problem279_perfectSquares {

    static class Res {
        int value;
        List<Integer> list;

        Res(int value, List<Integer> list) {
            this.value = value;
            this.list = list;
        }
    }

    public static int numSquares_bfs(int n) {
        List<Integer> squares = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        int ans = n;
        Queue<Res> queue = new LinkedList<>();
        queue.offer(new Res(n, new ArrayList<>()));
        while (!queue.isEmpty()) {
            Res res = queue.poll();
            if (res.value == 0) {
                ans = Math.min(ans, res.list.size());
            }
            for (int i = 0; i < squares.size(); i++) {
                if (res.value < squares.get(i)) {
                    break;
                }
                List list = new ArrayList(res.list);
                list.add(squares.get(i));
                queue.offer(new Res(res.value - squares.get(i), list));
            }
        }

        return ans;
    }

    public static int numSquares_bfs_2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                for (int j = 1; j * j <= value; j++) {
                    int tmp = value - j * j;
                    if (tmp == 0) {
                        return level;
                    }

                    if (!visited.contains(tmp)) {
                        visited.add(tmp);
                        queue.offer(tmp);
                    }
                }
            }
        }

        return level;
    }

    public static int numSquares_dp(int n) {
        List<Integer> squares = new ArrayList();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < squares.size(); j++) {
                if (i >= squares.get(j)) {
                    dp[i] = Math.min(dp[i], dp[i - squares.get(j)] + 1);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numSquares_bfs(1));
        System.out.println("1 ?= " + numSquares_bfs_2(1));
        System.out.println("1 ?= " + numSquares_dp(1));
        System.out.println("2 ?= " + numSquares_bfs(2));
        System.out.println("2 ?= " + numSquares_bfs_2(2));
        System.out.println("2 ?= " + numSquares_dp(2));
        System.out.println("3 ?= " + numSquares_bfs(3));
        System.out.println("3 ?= " + numSquares_dp(3));
        System.out.println("1 ?= " + numSquares_bfs(4));
        System.out.println("1 ?= " + numSquares_dp(4));
        System.out.println("2 ?= " + numSquares_bfs(5));
        System.out.println("2 ?= " + numSquares_dp(5));
        System.out.println("3 ?= " + numSquares_bfs(12));
        System.out.println("3 ?= " + numSquares_dp(12));
        System.out.println("2 ?= " + numSquares_bfs(13));
        System.out.println("2 ?= " + numSquares_dp(13));
        System.out.println("2 ?= " + numSquares_bfs(41));
        System.out.println("2 ?= " + numSquares_bfs_2(41));
        System.out.println("2 ?= " + numSquares_dp(41));
    }
}
