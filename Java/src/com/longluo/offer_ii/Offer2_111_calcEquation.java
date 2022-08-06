package com.longluo.offer_ii;

import java.util.*;

/**
 * 剑指 Offer II 111. 计算除法
 * <p>
 * 给定一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * <p>
 * 示例 1：
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 * <p>
 * 示例 2：
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 * <p>
 * 示例 3：
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 * <p>
 * 提示：
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * <p>
 * 注意：本题与主站 399 题相同： https://leetcode.com/problems/evaluate-division/
 * <p>
 * https://leetcode.cn/problems/vlzXQL/
 */
public class Offer2_111_calcEquation {

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        int varsCnt = 0;
        Map<String, Integer> varsMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!varsMap.containsKey(equations.get(i).get(0))) {
                varsMap.put(equations.get(i).get(0), varsCnt++);
            }
            if (!varsMap.containsKey(equations.get(i).get(1))) {
                varsMap.put(equations.get(i).get(1), varsCnt++);
            }
        }

        List<Pair>[] edges = new List[varsCnt];
        for (int i = 0; i < varsCnt; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            int va = varsMap.get(equations.get(i).get(0));
            int vb = varsMap.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCnt = queries.size();
        double[] ans = new double[queriesCnt];
        for (int i = 0; i < queriesCnt; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (varsMap.containsKey(query.get(0)) && varsMap.containsKey(query.get(1))) {
                int idxA = varsMap.get(query.get(0));
                int idxB = varsMap.get(query.get(1));
                if (idxA == idxB) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<>();
                    points.offer(idxA);
                    double[] ratios = new double[varsCnt];
                    Arrays.fill(ratios, -1.0);
                    ratios[idxA] = 1.0;
                    while (!points.isEmpty() && ratios[idxB] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double value = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * value;
                                points.offer(y);
                            }
                        }
                    }

                    result = ratios[idxB];
                }
            }

            ans[i] = result;
        }

        return ans;
    }

    static class Pair {
        int index;
        double value;

        public Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> tst1 = new ArrayList<>();
        tst1.add("a");
        tst1.add("b");
        equations.add(tst1);

        List<String> tst2 = new ArrayList<>();
        tst2.add("b");
        tst2.add("c");
        equations.add(tst2);

        List<List<String>> queries = new ArrayList<>();
        List<String> qtst1 = new ArrayList<>();
        qtst1.add("a");
        qtst1.add("c");
        queries.add(qtst1);

        List<String> qtst2 = new ArrayList<>();
        qtst2.add("b");
        qtst2.add("a");
        queries.add(qtst2);

        List<String> qtst3 = new ArrayList<>();
        qtst3.add("a");
        qtst3.add("e");
        queries.add(qtst3);

        System.out.println(Arrays.toString(calcEquation(equations, new double[]{2.0, 3.0}, queries)));
    }
}
