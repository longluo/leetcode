package com.longluo.studyplan.meituan.day3.meeting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * meituan-005. 小美的区域会议
 * <p>
 * 小美是美团总部的高管，她想要召集一些美团的区域负责人来开会，已知美团的业务区域划分可以用一棵树来表示，树上有 n 个节点，
 * 每个节点分别代表美团的一个业务区域，每一个区域有一个负责人，这个负责人的级别为 A[i]
 * 已知小美召集人员开会必须满足以下几个条件：
 * 1.小美召集的负责人所在的区域必须构成一个非空的连通的图，即选取树上的一个连通子图。
 * 2.这些负责人中，级别最高的和级别最低的相差不超过 k 。
 * 请问小美有多少种召集负责人的方式，当且仅当选取的集合不同时我们就认为两种方式不同。由于方案数可能非常大，所以请对 10^9+7 取模。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含两个整数 n 和 k ，表示区域的数量，和不能超过的级别。
 * - 接下来有 n-1 行，每行有两个正整数 a 和 b ，表示 a 号区域和 b 号区域有一条边。
 * - 最后一行有 n 个整数，第 i 个整数表示 i 号区域负责人的级别。
 * 输出：
 * - 输出仅包含一个整数，表示可以选择的方案数对 10^9+7 取模之后的结果。
 * <p>
 * 示例：
 * 输入：
 * 5 1
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 2 2 2 2 2
 * 输出：15
 * 解释：显然一个区域的方案有 {1}，{2}，{3}，{4}，{5}，两个区域的方案有 4 个，三个区域的方案有 3 个，
 * 四个区域的方案有 2 个，五个区域的方案有 1 个，共 15 个。
 * <p>
 * 提示：
 * 1 <= n, k <= 2000
 * 1 <= a, b <= n
 * <p>
 * https://leetcode-cn.com/problems/Uo7Dr5/
 */
public class Solution {

    static int N = 2010;
    static int MOD = (int) (1e9 + 7);

    static int n;                   //结点个数
    static int k;                   //等级差距
    static Map<Integer, List<Integer>> adjvex = new HashMap<>();
    static int[] rank;             //结点的等级
    static int min_rank;            //回溯时的最小等级
    static int max_rank;
    static int root;                //回溯时，最小点，root点。标识，防止重复
    static boolean[] visited;

    public static int backtrace(int x) {
        if (!(min_rank <= rank[x] && rank[x] <= max_rank))
            return 0;
        if (rank[x] == min_rank && x < root)
            return 0;
        visited[x] = true;
        long res = 1;
        for (int y : adjvex.getOrDefault(x, new ArrayList<>())) {
            if (visited[y] == false)
                res = res * (backtrace(y) + 1) % MOD;
        }
        visited[x] = false;
        return (int) res;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

        //-------------------输入------------------//
        String[] line1 = BR.readLine().split(" ");
        n = Integer.parseInt(line1[0]);
        k = Integer.parseInt(line1[1]);

        for (int ee = 0; ee < n - 1; ee++) {
            line1 = BR.readLine().split(" ");
            int x = Integer.parseInt(line1[0]);
            int y = Integer.parseInt(line1[1]);
            x--;
            y--;
            adjvex.putIfAbsent(x, new ArrayList<>());
            adjvex.putIfAbsent(y, new ArrayList<>());
            adjvex.get(x).add(y);
            adjvex.get(y).add(x);
        }

        rank = new int[n];
        String[] line2 = BR.readLine().split(" ");
        for (int i = 0; i < n; i++)
            rank[i] = Integer.parseInt(line2[i]);

        //-------------------枚举每个点---------------------//
        visited = new boolean[n];
        int res = 0;
        for (int x = 0; x < n; x++) {
            visited[x] = true;
            min_rank = rank[x];
            max_rank = rank[x] + k;
            root = x;
            res += backtrace(x);
            res %= MOD;
            visited[x] = false;
        }

        System.out.println(res);
    }
}
