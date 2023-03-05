package com.longluo.studyplan.jumpgame;

import java.util.*;

/**
 * 1345. 跳跃游戏 IV
 * <p>
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标：
 * <p>
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * 示例 1：
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * <p>
 * 示例 2：
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * <p>
 * 示例 3：
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * 示例 4：
 * 输入：arr = [6,1,9]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * <p>
 * https://leetcode.com/problems/jump-game-iv/
 */
public class Problem1345_jumpGame_iv {

    // BFS time: O(n^2) space: O(n)
    // TLE
    public static int minJumps_bfs(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }

        boolean[] vis = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        vis[0] = true;

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                if (curPos == len - 1) {
                    return ans - 1;
                }

                int left = curPos - 1;
                if (left >= 0) {
                    vis[left] = true;
                    queue.offer(left);
                }

                int right = curPos + 1;
                if (right < len) {
                    vis[right] = true;
                    queue.offer(right);
                }

                for (int j = 0; j < len; j++) {
                    if (arr[j] == arr[curPos] && curPos != j) {
                        vis[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        return ans - 1;
    }

    // BFS time: O(n) space: O(n)
    // TLE
    public static int minJumps_bfs_opt(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.putIfAbsent(arr[i], new ArrayList<>());
            idxMap.get(arr[i]).add(i);
        }

        boolean[] vis = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        vis[0] = true;

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                if (curPos == len - 1) {
                    return ans - 1;
                }

                int left = curPos - 1;
                if (left >= 0) {
                    vis[left] = true;
                    queue.offer(left);
                }

                int right = curPos + 1;
                if (right < len) {
                    vis[right] = true;
                    queue.offer(right);
                }

                List<Integer> sameValList = idxMap.get(arr[curPos]);
                for (Integer idx : sameValList) {
                    if (idx != curPos) {
                        vis[idx] = true;
                        queue.offer(idx);
                    }
                }
            }
        }

        return ans - 1;
    }

    // BFS time: O(n^2) space: O(n)
    // TLE
    public static int minJumps(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return 0;
        }

        boolean[] vis = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        vis[0] = true;

        int ans = 0;

        while (!queue.isEmpty()) {
            ans++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();

                if (curPos == len - 1) {
                    return ans - 1;
                }

                int left = curPos - 1;
                if (left >= 0 && !vis[left]) {
                    vis[left] = true;
                    queue.offer(left);
                }

                int right = curPos + 1;
                if (right < len && !vis[right]) {
                    vis[right] = true;
                    queue.offer(right);
                }

                for (int j = 0; j < len; j++) {
                    if (arr[j] == arr[curPos] && curPos != j && !vis[j]) {
                        vis[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }

        return ans - 1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minJumps_bfs(new int[]{7}));
        System.out.println("2 ?= " + minJumps_bfs(new int[]{6, 1, 9}));
        System.out.println("1 ?= " + minJumps_bfs(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        System.out.println("3 ?= " + minJumps_bfs(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
        System.out.println("3 ?= " + minJumps_bfs(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));

        System.out.println("3 ?= " + minJumps_bfs_opt(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));

        System.out.println("3 ?= " + minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }
}
