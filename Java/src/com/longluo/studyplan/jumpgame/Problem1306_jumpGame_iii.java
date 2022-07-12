package com.longluo.studyplan.jumpgame;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1306. 跳跃游戏 III
 * <p>
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * 示例 1：
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 示例 2：
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * <p>
 * 示例 3：
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * <p>
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * <p>
 * https://leetcode.cn/problems/jump-game-iii/
 */
public class Problem1306_jumpGame_iii {

    // BFS time: O(n) space: O(n)
    public static boolean canReach_bfs(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        return bfs(arr, start + arr[start]) || bfs(arr, start - arr[start]);
    }

    public static boolean bfs(int[] arr, int start) {
        int len = arr.length;
        if (start < 0 || start >= len) {
            return false;
        }

        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            if (arr[curPos] == 0) {
                return true;
            }

            int right = curPos + arr[curPos];
            if (right >= 0 && right < len && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
            }

            int left = curPos - arr[curPos];
            if (left >= 0 && left < len && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
            }
        }

        return false;
    }

    // BFS opt time: O(n) space: O(n)
    public static boolean canReach_bfs_opt(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int len = arr.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            if (arr[curPos] == 0) {
                return true;
            }

            int right = curPos + arr[curPos];
            if (right >= 0 && right < len && !visited[right]) {
                visited[right] = true;
                queue.offer(right);
            }

            int left = curPos - arr[curPos];
            if (left >= 0 && left < len && !visited[left]) {
                visited[left] = true;
                queue.offer(left);
            }
        }

        return false;
    }

    // DFS time: O(n) space: O(n)
    public static boolean canReach_dfs(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int len = arr.length;
        return dfs(arr, new boolean[len], start + arr[start]) || dfs(arr, new boolean[len], start - arr[start]);
    }

    public static boolean dfs(int[] arr, boolean[] vis, int start) {
        int len = arr.length;
        if (start < 0 || start >= len) {
            return false;
        }

        vis[start] = true;
        if (arr[start] == 0) {
            return true;
        }

        int nextLeftPos = start - arr[start];
        boolean left = nextLeftPos >= 0 && nextLeftPos < len && vis[nextLeftPos];

        int nextRightPos = start + arr[start];
        boolean right = nextRightPos >= 0 && nextRightPos < len && vis[nextRightPos];

        return (left && dfs(arr, vis, nextLeftPos)) || (right && dfs(arr, vis, nextRightPos));
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canReach_bfs(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println("false ?= " + canReach_bfs(new int[]{3, 0, 2, 1, 2}, 2));

        System.out.println("false ?= " + canReach_bfs_opt(new int[]{3, 0, 2, 1, 2}, 2));

        System.out.println("true ?= " + canReach_dfs(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println("false ?= " + canReach_dfs(new int[]{3, 0, 2, 1, 2}, 2));
    }
}
