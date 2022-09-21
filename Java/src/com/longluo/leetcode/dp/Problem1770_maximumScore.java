package com.longluo.leetcode.dp;

import java.util.*;

/**
 * 1770. 执行乘法运算的最大分数
 * <p>
 * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 * <p>
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 * <p>
 * 选择数组 nums 开头处或者末尾处 的整数 x 。
 * 你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3], multipliers = [3,2,1]
 * 输出：14
 * 解释：一种最优解决方案如下：
 * - 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
 * - 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
 * 总分数为 9 + 4 + 1 = 14 。
 * <p>
 * 示例 2：
 * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * 输出：102
 * 解释：一种最优解决方案如下：
 * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
 * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
 * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
 * <p>
 * 提示：
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 10^3
 * m <= n <= 10^5
 * -1000 <= nums[i], multipliers[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/maximum-score-from-performing-multiplication-operations/
 */
public class Problem1770_maximumScore {

    // BF Backtrack time: O(2^m) space: O(n)
    // TLE
    public static int maximumScore_bf(int[] nums, int[] multipliers) {
        int m = multipliers.length;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int x : nums) {
            deque.offer(x);
        }

        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), deque, m);

        int ans = 0;
        for (List<Integer> path : res) {
            ans = Math.max(ans, calcScore(path, multipliers));
        }

        return ans;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, Deque<Integer> deque, int m) {
        if (path.size() == m) {
            res.add(new ArrayList<>(path));
            return;
        }

        int front = deque.peekFirst();
        int end = deque.peekLast();

        path.add(deque.pollFirst());
        backtrack(res, path, deque, m);
        path.remove(path.size() - 1);
        deque.offerFirst(front);

        path.add(deque.pollLast());
        backtrack(res, path, deque, m);
        path.remove(path.size() - 1);
        deque.offerLast(end);
    }

    private static int calcScore(List<Integer> nums, int[] multipliers) {
        int ans = 0;
        int m = multipliers.length;

        for (int i = 0; i < m; i++) {
            ans += nums.get(i) * multipliers[i];
        }

        return ans;
    }

    // DFS time: O(2^m) space: O(m)
    // TLE
    public static int maximumScore_dfs(int[] nums, int[] multipliers) {
        return dfs(nums, multipliers, 0, 0, nums.length - 1);
    }

    private static int dfs(int[] nums, int[] multipliers, int op, int leftIdx, int rightIdx) {
        if (op == multipliers.length) {
            return 0;
        }

        int left = nums[leftIdx] * multipliers[op] + dfs(nums, multipliers, op + 1, leftIdx + 1, rightIdx);
        int right = nums[rightIdx] * multipliers[op] + dfs(nums, multipliers, op + 1, leftIdx, rightIdx - 1);
        return Math.max(left, right);
    }

    // DFS Opt Only Use left
    // TLE
    public static int maximumScore_dfs_opt(int[] nums, int[] multipliers) {
        return dfs(nums, multipliers, 0, 0);
    }

    private static int dfs(int[] nums, int[] multipliers, int op, int leftIdx) {
        int n = nums.length;
        int m = multipliers.length;

        if (op == m) {
            return 0;
        }

        int left = nums[leftIdx] * multipliers[op] + dfs(nums, multipliers, op + 1, leftIdx + 1);
        int right = nums[n - 1 + leftIdx - op] * multipliers[op] + dfs(nums, multipliers, op + 1, leftIdx);
        return Math.max(left, right);
    }

    // DFS Memory time: O(2^m) space: O(m^2)
    // AC
    public static int maximumScore_dfs_memory(int[] nums, int[] multipliers) {
        int m = multipliers.length;

        int[][] cache = new int[m][m];

        for (int i = 0; i < m; i++) {
            Arrays.fill(cache[i], Integer.MIN_VALUE);
        }

        return dfs(cache, nums, multipliers, 0, 0);
    }

    private static int dfs(int[][] cache, int[] nums, int[] multipliers, int op, int leftIdx) {
        if (op == multipliers.length) {
            return 0;
        }

        if (cache[op][leftIdx] > Integer.MIN_VALUE) {
            return cache[op][leftIdx];
        }

        int n = nums.length;

        int leftSum = nums[leftIdx] * multipliers[op] + dfs(cache, nums, multipliers, op + 1, leftIdx + 1);
        int rightSum = nums[n - 1 + leftIdx - op] * multipliers[op] + dfs(cache, nums, multipliers, op + 1, leftIdx);

        int sum = Math.max(leftSum, rightSum);
        cache[op][leftIdx] = sum;
        return sum;
    }

    // DP time: O(m^2) space: O(m^2)
    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;

        // dp[i][j]: left i and right j
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] + nums[n - i] * multipliers[i - 1];
            dp[i][0] = dp[i - 1][0] + nums[i - 1] * multipliers[i - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m - i; j++) {
                int idx = i + j - 1;
                dp[i][j] = Math.max(dp[i - 1][j] + nums[i - 1] * multipliers[idx], dp[i][j - 1] + nums[n - j] * multipliers[idx]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i][m - i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("14 ?= " + maximumScore_bf(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
//        System.out.println("6861161 ?= " + maximumScore_bf(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10},
//                new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}));

        System.out.println("14 ?= " + maximumScore_dfs(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println("6861161 ?= " + maximumScore_dfs(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10},
                new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}));

        System.out.println("14 ?= " + maximumScore_dfs_opt(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println("6861161 ?= " + maximumScore_dfs_opt(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10},
                new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}));

        System.out.println("14 ?= " + maximumScore_dfs_memory(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println("6861161 ?= " + maximumScore_dfs_memory(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10},
                new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}));

        System.out.println("14 ?= " + maximumScore(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
        System.out.println("6861161 ?= " + maximumScore(new int[]{555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120, 607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939, -465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10},
                new int[]{783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381, 871, 762, -355, 721, 753, -521}));
    }
}
