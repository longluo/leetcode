package com.longluo.leetcode.graph;

/**
 * 997. 找到小镇的法官
 * <p>
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * <p>
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * <p>
 * 示例 1：
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * <p>
 * 示例 3：
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * <p>
 * 示例 4：
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * <p>
 * 示例 5：
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] 是完全不同的
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 * <p>
 * https://leetcode-cn.com/problems/find-the-town-judge/
 */
public class Problem997_findTheTownJudge {

    // BF
    public static int findJudge_bf(int N, int[][] trust) {
        if (N <= 0) {
            return -1;
        } else if (N == 1) {
            return 1;
        }

        // [0]: In  [1]: Out
        int[][] count = new int[N][2];
        for (int[] item : trust) {
            count[item[0] - 1][1]++;
            count[item[1] - 1][0]++;
        }

        for (int i = 0; i < N; i++) {
            if (count[i][0] == N - 1 && count[i][1] == 0) {
                return i + 1;
            }
        }

        return -1;
    }

    // Graph
    public static int findJudge(int N, int[][] trust) {
        if (N <= 0) {
            return -1;
        } else if (N == 1) {
            return 1;
        }

        // [0]: In  [1]: Out
        int[][] count = new int[N][2];
        for (int[] item : trust) {
            count[item[0] - 1][1]++;
            count[item[1] - 1][0]++;
        }

        for (int i = 0; i < N; i++) {
            if (count[i][0] == N - 1 && count[i][1] == 0) {
                return i + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findJudge_bf(2, new int[][]{{1, 2}}));
        System.out.println("1 ?= " + findJudge_bf(1, new int[][]{{}}));
        System.out.println("3 ?= " + findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        System.out.println("-1 ?= " + findJudge(3, new int[][]{{1, 2}, {2, 3}}));
        System.out.println("-1 ?= " + findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
        System.out.println("3 ?= " + findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
    }
}
