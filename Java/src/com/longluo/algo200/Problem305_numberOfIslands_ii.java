package com.longluo.algo200;

import java.util.ArrayList;
import java.util.List;

/**
 * 305. 岛屿数量 II
 * <p>
 * 给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。
 * 最初，grid 中的所有单元格都是水单元格（即，所有单元格都是 0）。
 * <p>
 * 可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，
 * 其中 positions[i] = [ri, ci] 是要执行第 i 次操作的位置 (ri, ci) 。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。
 * <p>
 * 岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。
 * 你可以假设地图网格的四边均被无边无际的「水」所包围。
 * <p>
 * 示例 1：
 * 输入：m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
 * 输出：[1,1,2,3]
 * 解释：
 * 起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
 * - 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。此时存在 1 个岛屿。
 * - 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。此时存在 1 个岛屿。
 * - 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。此时存在 2 个岛屿。
 * - 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。此时存在 3 个岛屿。
 * <p>
 * 示例 2：
 * 输入：m = 1, n = 1, positions = [[0,0]]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= m, n, positions.length <= 10^4
 * 1 <= m * n <= 10^4
 * positions[i].length == 2
 * 0 <= ri < m
 * 0 <= ci < n
 * <p>
 * 进阶：你可以设计一个时间复杂度 O(klog(mn)) 的算法解决此问题吗？（其中 k == positions.length）
 * <p>
 * https://leetcode.cn/problems/number-of-islands-ii/
 */
public class Problem305_numberOfIslands_ii {

    // UnionFind time: O(k*mn*aplha(mn) space: O(mn)
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        List<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[m * n];

        UnionFind uf = new UnionFind(m, n);

        for (int[] pos : positions) {
            int r = pos[0];
            int c = pos[1];

            int idx = r * n + c;
            if (visited[idx]) {
                ans.add(uf.getCount());
                continue;
            }

            visited[idx] = true;
            uf.addCount();

            for (int[] dir : dirs) {
                int nextX = r + dir[0];
                int nextY = c + dir[1];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }

                int nextIdx = nextX * n + nextY;
                if (!visited[nextIdx]) {
                    continue;
                }

                if (!uf.isConnected(idx, nextIdx)) {
                    uf.union(idx, nextIdx);
                }
            }

            ans.add(uf.getCount());
        }

        return ans;
    }

    static class UnionFind {
        int[] parents;
        int[] size;
        int count = 0;

        UnionFind(int m, int n) {
            parents = new int[m * n];
            size = new int[m * n];

            for (int i = 0; i < m * n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        void addCount() {
            count++;
        }

        int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }

            return parents[x];
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int a = find(x);
            int b = find(y);

            if (a != b) {
                if (size[a] > size[b]) {
                    parents[b] = a;
                    size[a] += size[b];
                } else if (size[a] < size[b]) {
                    parents[a] = b;
                    size[b] += size[a];
                } else {
                    parents[a] = b;
                    size[b] += size[a];
                }

                count--;
            }
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("[1, 1, 2, 3] ?= " + numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println("[1] ?= " + numIslands2(3, 3, new int[][]{{0, 0}}));
    }
}
