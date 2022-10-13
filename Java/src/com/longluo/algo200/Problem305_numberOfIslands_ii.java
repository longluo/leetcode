package com.longluo.algo200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        List<Integer> ans = new ArrayList<>();

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        UnionFind uf = new UnionFind(m * n);

        boolean[] visited = new boolean[m * n];

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];

            int idx = x * n + y;

            if (visited[idx]) {
                ans.add(uf.getCount());
                continue;
            }

            uf.setParent(idx);
            visited[idx] = true;

            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];

                int nextIdx = nextX * n + nextY;

                if (inArea(m, n, nextX, nextY) && uf.isValid(nextIdx) && visited[nextIdx]) {
                    uf.union(idx, nextIdx);
                }
            }

            ans.add(uf.getCount());
        }

        return ans;
    }

    private static boolean inArea(int rows, int cols, int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    static class UnionFind {
        int[] parents;
        int[] rank;
        int count = 0;

        UnionFind(int n) {
            parents = new int[n];
            rank = new int[n];
            count = 0;

            Arrays.fill(parents, -1);
        }

        boolean isValid(int x) {
            return parents[x] != -1;
        }

        void setParent(int x) {
            if (parents[x] != x) {
                count++;
            }

            parents[x] = x;
        }

        int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }

            return x;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] > rank[rootY]) {
                parents[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parents[rootX] = rootY;
            } else {
                parents[rootY] = rootX;
                rank[rootX]++;
            }

            count--;
        }

        int getCount() {
            return count;
        }
    }

    public static List<Integer> numIslands2_ref(int m, int n, int[][] positions) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        List<Integer> ans = new LinkedList<>();

        UnionFind_ref uf = new UnionFind_ref(m * n);

        for (int[] position : positions) {
            int row = position[0];
            int col = position[1];

            //当前加入的位置，把这个二维坐标转化为一维坐标
            int index = row * n + col;
            //初始化加入位置的parent数组
            uf.setParent(index);

            //检查周围是否有陆地
            List<Integer> around = new LinkedList<>();
            for (int[] dir : directions) {
                int newX = row + dir[0];
                int newY = col + dir[1];

                if (inArea(m, n, newX, newY) && uf.isValid(newX * n + newY)) {
                    around.add(newX * n + newY);
                }
            }

            //union当前的和周围的
            for (int round : around) {
                uf.union(index, round);
            }

            ans.add(uf.getCount());
        }

        return ans;
    }

    static class UnionFind_ref {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind_ref(int n) {
            count = 0;
            parent = new int[n];
            rank = new int[n];

            //因为还不知道land加在哪，parent先赋值为-1
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                rank[i] = 0;
            }
        }

        public int find(int p) {
            //路径压缩
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }

            if (rank[pRoot] > rank[qRoot]) {
                parent[qRoot] = pRoot;
            } else if (rank[qRoot] > rank[pRoot]) {
                parent[pRoot] = qRoot;
            } else {
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }

            count--;
        }

        public int getCount() {
            return count;
        }

        public boolean isValid(int p) {
            return parent[p] != -1;
        }

        //根据添加做初始化
        public void setParent(int p) {
            if (parent[p] != p) {
                count++;
            }
            parent[p] = p;
        }
    }

    public static void main(String[] args) {
        System.out.println("[1] ?= " + numIslands2(3, 3, new int[][]{{0, 0}}));
        System.out.println("[1, 1, 2, 3] ?= " + numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
        System.out.println("[1, 1, 2, 3, 3, 3, 2, 2, 1, 1] ?= " + numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 0}, {2, 2}, {1, 2}, {1, 1}, {0, 1}}));

        System.out.println("[1, 1, 2, 3, 3, 3, 2, 2, 1, 1] ?= " + numIslands2_ref(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 0}, {2, 2}, {1, 2}, {1, 1}, {0, 1}}));
    }
}
