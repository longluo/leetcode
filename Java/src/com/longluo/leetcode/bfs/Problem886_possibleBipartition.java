package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 886. 可能的二分法
 * <p>
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：n = 4, dislikes = [[1,2},{1,3},{2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * <p>
 * 示例 2：
 * 输入：n = 3, dislikes = [[1,2},{1,3},{2,3]]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 5, dislikes = [[1,2},{2,3},{3,4},{4,5},{1,5]]
 * 输出：false
 * <p>
 * 提示：
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 10^4
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 * <p>
 * https://leetcode.cn/problems/possible-bipartition/
 */
public class Problem886_possibleBipartition {

    // BF 不是很明白
    // TODO: 2022/10/19
    public static boolean possibleBipartition_bf(int n, int[][] dislikes) {
        if (dislikes == null || dislikes.length < 2) {
            return true;
        }

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        setA.add(dislikes[0][0]);
        setB.add(dislikes[0][1]);

        int ql = dislikes.length - 1;
        int[] q = new int[ql];

        int head = -1;
        int tail = -1;

        for (int i = 1; i < dislikes.length; i++) {
            int[] dislike = dislikes[i];
            if ((setA.contains(dislike[0]) && setA.contains(dislike[1]))
                    || (setB.contains(dislike[0]) && setB.contains(dislike[1]))) {
                return false;
            }

            if (setA.contains(dislike[0])) {
                setB.add(dislike[1]);
                continue;
            }

            if (setB.contains(dislike[0])) {
                setA.add(dislike[1]);
                continue;
            }

            if (setA.contains(dislike[1])) {
                setB.add(dislike[0]);
                continue;
            }

            if (setB.contains(dislike[1])) {
                setA.add(dislike[0]);
                continue;
            }

            q[++tail] = i;
        }

        while (head != tail) {
            if (head == ql - 1) {
                head = -1;
            }

            int i = q[++head];

            if ((setA.contains(dislikes[i][0]) && setA.contains(dislikes[i][1]))
                    || (setB.contains(dislikes[i][0]) && setB.contains(dislikes[i][1]))) {
                return false;
            }

            if (setA.contains(dislikes[i][0])) {
                setB.add(dislikes[i][1]);
                continue;
            }

            if (setA.contains(dislikes[i][1])) {
                setB.add(dislikes[i][0]);
                continue;
            }

            if (setB.contains(dislikes[i][0])) {
                setA.add(dislikes[i][1]);
                continue;
            }

            if (setB.contains(dislikes[i][1])) {
                setA.add(dislikes[i][0]);
                continue;
            }

            if (tail == ql - 1) {
                setA.add(dislikes[i][0]);
                setB.add(dislikes[i][1]);
                tail = -1;
            } else {
                q[++tail] = i;
            }
        }

        return true;
    }

    // BFS time: O(mn) space: O(mn)
    public static boolean possibleBipartition_bfs(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] > 0) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int curNode = queue.poll();
                if (color[curNode] == 0) {
                    color[curNode] = 1;
                }

                List<Integer> neighbors = graph[curNode];
                for (int node : neighbors) {
                    if (color[curNode] == color[node]) {
                        return false;
                    }

                    if (color[node] == 0) {
                        color[node] = 3 - color[curNode];
                        queue.offer(node);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + possibleBipartition_bf(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println("false ?= " + possibleBipartition_bf(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println("false ?= " + possibleBipartition_bf(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}));
        System.out.println("true ?= " + possibleBipartition_bf(10, new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}));

        System.out.println("false ?= " + possibleBipartition_bfs(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}));
        System.out.println("true ?= " + possibleBipartition_bfs(10, new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}));
    }
}
