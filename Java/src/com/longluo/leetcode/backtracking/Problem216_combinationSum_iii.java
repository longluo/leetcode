package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * 示例 1:
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * <p>
 * 示例 2:
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * <p>
 * 示例 3:
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * 提示:
 * 2 <= k <= 9
 * 1 <= n <= 60
 * <p>
 * https://leetcode.cn/problems/combination-sum-iii/
 */
public class Problem216_combinationSum_iii {

    // Backtrack time: O(9!/k!) space: O(9)
    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (n < 3 || n > 45 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> path, int start, int k, int target) {
        if (k < 0 || target < 0) {
            return;
        }

        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) {
                break;
            }

            if (target - i == 0 && k > 1) {
                break;
            }

            path.add(i);
            backtrack(res, path, i + 1, k - 1, target - i);
            path.remove(path.size() - 1);
        }
    }

    // Bit Subset time: O(9×2^9) space: O(9)
    public static List<List<Integer>> combinationSum3_bit(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        if (k <= 0 || n <= 0 || k > n) {
            return ans;
        }

        // 寻找 n 的上限：[9, 8, ... , (9 - k + 1)]，它们的和为 (19 - k) * k / 2 比上限还大，就不用搜索了：
        if (n > (19 - k) * k / 2) {
            return ans;
        }

        for (int mask = 0; mask < (1 << 9); mask++) {
            List<Integer> path = new ArrayList<>();
            if (check(path, mask, k, n)) {
                ans.add(path);
            }
        }

        return ans;
    }

    public static boolean check(List<Integer> path, int mask, int k, int target) {
        path.clear();

        for (int i = 0; i < 9; i++) {
            if (((1 << i) & mask) != 0) {
                path.add(i + 1);
            }
        }

        if (path.size() != k) {
            return false;
        }

        int sum = 0;
        for (int x : path) {
            sum += x;
        }

        return sum == target;
    }

    public static void main(String[] args) {
        System.out.println("[[1, 2, 4]] ?= " + combinationSum3(3, 7));
        System.out.println("[[1, 2, 4]] ?= " + combinationSum3_bit(3, 7));
    }
}
