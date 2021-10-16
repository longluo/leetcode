package com.longluo.studyplan.meituan.day4.tree;

import java.util.*;

/**
 * meituan-008. 小团无路可逃
 * <p>
 * 小团惹小美生气了，小美要去找小团“讲道理”。小团望风而逃，他们住的地方可以抽象成一棵有n个结点的树，
 * 小美位于 x 位置，小团位于 y 位置。小团和小美每个单位时间内都可以选择不动或者向相邻的位置转移，很显然最终小团会无路可逃，
 * 只能延缓一下被“讲道理”的时间，请问最多经过多少个单位时间后，小团会被追上。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含三个整数 n，x，y，分别表示树上的结点数量，小美所在的位置和小团所在的位置。
 * - 接下来有 n-1 行，每行两个整数 u，v，表示 u 号位置和 v 号位置之间有一条边，即 u 号位置和 v 号位置彼此相邻。
 * 输出：
 * - 输出仅包含一个整数，表示小美追上小团所需的时间。
 * <p>
 * 示例：
 * 输入：
 * 5 1 2
 * 2 1
 * 3 1
 * 4 2
 * 5 3
 * 输出：2
 * <p>
 * 提示：
 * 1 <= n <= 50000
 * <p>
 * https://leetcode-cn.com/problems/vSYUMc/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        int nodeNum = Integer.parseInt(nums[0]);
        int xLoc = Integer.parseInt(nums[1]);
        int yLoc = Integer.parseInt(nums[2]);
        if (xLoc == yLoc) {
            System.out.println(0);
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nodeNum; i++) {
            String[] nodes = scanner.nextLine().split(" ");
            int uNode = Integer.parseInt(nodes[0]);
            int vNode = Integer.parseInt(nodes[1]);

            List<Integer> list = map.getOrDefault(uNode, new LinkedList<>());
            list.add(vNode);
            map.put(uNode, list);

            list = map.getOrDefault(vNode, new LinkedList<>());
            list.add(uNode);
            map.put(vNode, list);
        }

        boolean[] visitedX = new boolean[nodeNum + 1];
        boolean[] visitedY = new boolean[nodeNum + 1];
        visitedX[xLoc] = visitedY[yLoc] = true;
        Deque<Integer> todoX = new LinkedList<>();
        Deque<Integer> todoY = new LinkedList<>();
        todoX.add(xLoc);
        todoY.add(yLoc);

        // cntY 为小团已到达但小美未到达的位置的数量
        int cntY = 1;
        int time = 0;

        // 同时BFS, 当小团没有位置时结束
        while (cntY > 0) {
            time++;

            // 小美要先BFS, 因为小团不可以去小美的位置
            int size = todoX.size();
            for (int i = 0; i < size; i++) {
                int currX = todoX.poll();
                for (int next : map.get(currX)) {
                    if (visitedX[next]) continue;
                    if (visitedY[next]) cntY--;
                    todoX.add(next);
                    visitedX[next] = true;
                }
            }

            size = todoY.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    int currY = todoY.poll();
                    for (int next : map.get(currY)) {
                        if (visitedY[next] || visitedX[next]) continue;
                        todoY.add(next);
                        visitedY[next] = true;
                        cntY++;
                    }
                }
            }
        }

        System.out.println(time);
    }
}
