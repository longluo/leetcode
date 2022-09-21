package com.longluo.leetcode.simulate;

import java.util.Arrays;

/**
 * 985. 查询后的偶数和
 * <p>
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 * <p>
 * https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */
public class Problem985_sumOfEvenNumbersAfterQueries {

    // Simulate time: O(n^2) space: O(n)
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] ans = new int[len];

        for (int i = 0; i < queries.length; i++) {
            int value = queries[i][0];
            int index = queries[i][1];

            nums[index] += value;
            int sum = 0;
            for (int x : nums) {
                sum += x % 2 == 0 ? x : 0;
            }

            ans[i] = sum;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[8,6,2,4] ?= " + Arrays.toString(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }
}
