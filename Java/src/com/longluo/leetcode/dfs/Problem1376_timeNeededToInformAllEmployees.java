package com.longluo.leetcode.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1376. 通知所有员工所需的时间
 * <p>
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * <p>
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。
 * 对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * <p>
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，
 * 直到所有的员工都得知这条紧急消息。
 * <p>
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，
 * 他的所有直属下属都可以开始传播这一消息）。
 * <p>
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 * 示例 1：
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * <p>
 * 示例 2：
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * 0 <= headID < n
 * manager.length == n
 * 0 <= manager[i] < n
 * manager[headID] == -1
 * informTime.length == n
 * 0 <= informTime[i] <= 1000
 * 如果员工 i 没有下属，informTime[i] == 0 。
 * 题目 保证 所有员工都可以收到通知。
 * <p>
 * https://leetcode.cn/problems/time-needed-to-inform-all-employees/
 */
public class Problem1376_timeNeededToInformAllEmployees {

    // BFS time: O(n^2) space: O(n)
    // TLE
    public static int numOfMinutes_bfs(int n, int headID, int[] manager, int[] informTime) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(headID);

        boolean[] visited = new boolean[n];
        visited[headID] = true;

        int[] time = new int[n];
        time[headID] = informTime[headID];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();

                for (int j = 0; j < n; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (manager[j] == curNode) {
                        visited[j] = true;
                        time[j] = time[curNode] + informTime[j];
                        queue.offer(j);
                    }
                }
            }
        }

        return Arrays.stream(time).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + numOfMinutes_bfs(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println("1 ?= " + numOfMinutes_bfs(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
        System.out.println("2560 ?= " + numOfMinutes_bfs(11, 4, new int[]{5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4}, new int[]{0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337})); // 686 + 337 + 253 +
    }
}
