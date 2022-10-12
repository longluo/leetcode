package com.longluo.algo200;

import java.util.*;

/**
 * 499. 迷宫 III
 * <p>
 * 由空地和墙组成的迷宫中有一个球。球可以向上（u）下（d）左（l）右（r）四个方向滚动，但在遇到墙壁前不会停止滚动。
 * 当球停下时，可以选择下一个方向。迷宫中还有一个洞，当球运动经过洞时，就会掉进洞里。
 * <p>
 * 给定球的起始位置，目的地和迷宫，找出让球以最短距离掉进洞里的路径。 距离的定义是球从起始位置（不包括）到目的地（包括）经过的空地个数。
 * 通过'u', 'd', 'l' 和 'r'输出球的移动方向。 由于可能有多条最短路径， 请输出字典序最小的路径。如果球无法进入洞，输出"impossible"。
 * <p>
 * 迷宫由一个0和1的二维数组表示。 1表示墙壁，0表示空地。你可以假定迷宫的边缘都是墙壁。起始位置和目的地的坐标通过行号和列号给出。
 * <p>
 * 示例1:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * 输入 2: 球的初始位置 (rowBall, colBall) = (4, 3)
 * <p>
 * 输入 3: 洞的位置 (rowHole, colHole) = (0, 1)
 * <p>
 * 输出: "lul"
 * <p>
 * 解析: 有两条让球进洞的最短路径。
 * 第一条路径是 左 -> 上 -> 左, 记为 "lul".
 * 第二条路径是 上 -> 左, 记为 'ul'.
 * 两条路径都具有最短距离6, 但'l' < 'u'，故第一条路径字典序更小。因此输出"lul"。
 * <p>
 * 示例 2:
 * <p>
 * 输入 1: 迷宫由以下二维数组表示
 * <p>
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 0 0 0 0 0
 * 0 1 0 0 1
 * 0 1 0 0 0
 * <p>
 * 输入 2: 球的初始位置 (rowBall, colBall) = (4, 3)
 * 输入 3: 洞的位置 (rowHole, colHole) = (3, 0)
 * <p>
 * 输出: "impossible"
 * <p>
 * 示例: 球无法到达洞。
 * <p>
 * 注意:
 * 迷宫中只有一个球和一个目的地。
 * 球和洞都在空地上，且初始时它们不在同一位置。
 * 给定的迷宫不包括边界 (如图中的红色矩形), 但你可以假设迷宫的边缘都是墙壁。
 * 迷宫至少包括2块空地，行数和列数均不超过30。
 * <p>
 * https://leetcode.cn/problems/the-maze-iii/
 */
public class Problem499_theMaze_iii {

    // BFS time: O(mn) space: O(mn)
    public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        String[] actions = {"u", "d", "l", "r"};

        int m = maze.length;
        int n = maze[0].length;

        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < m * n; i++) {
            map.put(i, "");
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ball[0], ball[1]});

        distance[ball[0]][ball[1]] = 0;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            int x = curPos[0];
            int y = curPos[1];
            int dist = distance[x][y];

            for (int i = 0; i < 4; i++) {
                int nextX = x;
                int nextY = y;

                String path = map.get(x * n + y);
                int steps = 0;

                while (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && maze[nextX][nextY] == 0
                        && !(nextX == hole[0] && nextY == hole[1])) {
                    nextX += dirs[i][0];
                    nextY += dirs[i][1];
                    steps++;
                }

                if (!(nextX == hole[0] && nextY == hole[1])) {
                    nextX -= dirs[i][0];
                    nextY -= dirs[i][1];
                    steps--;
                }

                path += actions[i];

                if (dist + steps < distance[nextX][nextY]) {
                    distance[nextX][nextY] = dist + steps;
                    map.put(nextX * n + nextY, path);

                    if (!(nextX == hole[0] && nextY == hole[1])) {
                        queue.offer(new int[]{nextX, nextY});
                    }
                } else if (dist + steps == distance[nextX][nextY] && path.compareTo(map.get(nextX * n + nextY)) < 0) {
                    map.put(nextX * n + nextY, path);
                    if (!(nextX == hole[0] && nextY == hole[1])) {
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }

        String res = map.get(hole[0] * n + hole[1]);
        return res.equals("") ? "impossible" : res;
    }

    public static void main(String[] args) {
        System.out.println("u ?= " + findShortestWay(new int[][]{{0}, {0}}, new int[]{1, 0}, new int[]{0, 0}));
        System.out.println("lul ?= " + findShortestWay(new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}}, new int[]{4, 3}, new int[]{0, 1}));
        System.out.println("impossible ?= " + findShortestWay(new int[][]{{0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}}, new int[]{4, 3}, new int[]{3, 0}));
        System.out.println("dldr ?= " + findShortestWay(new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 1, 0}, {0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1}}, new int[]{0, 4}, new int[]{3, 5}));
    }
}
