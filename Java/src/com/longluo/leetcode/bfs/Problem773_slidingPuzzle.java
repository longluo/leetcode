package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 773. 滑动谜题
 * <p>
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 {{1,2,3},{4,5,0}} 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * 输入：board = {{1,2,3},{4,0,5}}
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * <p>
 * 输入：board = {{1,2,3},{5,4,0}}
 * 输出：-1
 * 解释：没有办法完成谜板
 * <p>
 * 输入：board = {{4,1,2},{5,0,3}}
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: {{4,1,2},{5,0,3}}
 * 移动 1 次: {{4,1,2},{0,5,3}}
 * 移动 2 次: {{0,1,2},{4,5,3}}
 * 移动 3 次: {{1,0,2},{4,5,3}}
 * 移动 4 次: {{1,2,0},{4,5,3}}
 * 移动 5 次: {{1,2,3},{4,5,0}}
 * 输入：board = {{3,2,4},{1,5,0}}
 * 输出：14
 * <p>
 * 提示：
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <p>
 * https://leetcode-cn.com/problems/sliding-puzzle/
 */
public class Problem773_slidingPuzzle {

    public static int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
        }

        String initStatus = sb.toString();
        if ("123450".equals(initStatus)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(initStatus);
        Set<String> visited = new HashSet<>();
        visited.add(initStatus);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                List<String> statusList = getNextStatus(status);
                for (String nextStatus : statusList) {
                    if (nextStatus.equals("123450")) {
                        return step;
                    }

                    if (visited.contains(nextStatus)) {
                        continue;
                    }

                    visited.add(nextStatus);
                    queue.offer(nextStatus);
                }
            }
        }

        return -1;
    }

    public static List<String> getNextStatus(String status) {
        List<String> res = new ArrayList<>();
        int[][] neighbors = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        char[] array = status.toCharArray();
        int zeroIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0') {
                zeroIdx = i;
                break;
            }
        }

        for (int neighbor : neighbors[zeroIdx]) {
            swap(array, zeroIdx, neighbor);
            res.add(new String(array));
            swap(array, neighbor, zeroIdx);
        }

        return res;
    }

    public static void swap(char[] arr, int x, int y) {
        char ch = arr[x];
        arr[x] = arr[y];
        arr[y] = ch;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println("-1 ?= " + slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println("5 ?= " + slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }
}
