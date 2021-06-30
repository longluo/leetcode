package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 815. 公交路线
 * <p>
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * <p>
 * 示例 2：
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 10^5
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 10^5
 * 0 <= routes[i][j] < 10^6
 * 0 <= source, target < 10^6
 * <p>
 * https://leetcode-cn.com/problems/bus-routes/
 */
public class Problem815_busRoutes {

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) {
            return -1;
        }

        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopMap = new HashMap<>();
        Set<Integer> visitedRouteSet = new HashSet<>();
        Set<Integer> visitedStopSet = new HashSet<>();
        int m = routes.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (stopMap.containsKey(routes[i][j])) {
                    stopMap.get(routes[i][j]).add(i);
                } else {
                    List<Integer> routeList = new LinkedList<>();
                    routeList.add(i);
                    stopMap.put(routes[i][j], routeList);
                }
            }
        }

        if (!stopMap.containsKey(target)) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{source, 0});
        visitedStopSet.add(source);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] stop = queue.poll();
                List<Integer> routeList = stopMap.get(stop[0]);
                for (int route : routeList) {
                    if (visitedRouteSet.contains(route)) {
                        continue;
                    }

                    for (int stopNum : routes[route]) {
                        if (stopNum == target) {
                            return stop[1] + 1;
                        }

                        if (visitedStopSet.contains(stopNum)) {
                            continue;
                        }

                        visitedStopSet.add(stopNum);
                        queue.offer(new int[]{stopNum, stop[1] + 1});
                    }

                    visitedRouteSet.add(route);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        System.out.println("-1 ?= " + numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));
    }
}
