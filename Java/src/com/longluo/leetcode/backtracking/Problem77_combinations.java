package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Medium
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * <p>
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * https://leetcode.com/problems/combinations
 */
public class Problem77_combinations {

    // Backtrack time: O(k^n) space: O(n)
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        backtrack(ans, new ArrayList<>(), visited, n, k);
        return ans;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, boolean[] visited, int max, int sum) {
        if (path.size() == sum) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= max; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                path.add(i);
                backtrack(res, path, visited, max, sum);
                path.remove(path.size() - 1);
                visited[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]] ?= " + combine(4, 2));
    }
}
