package com.longluo.contest.weekly_contest_296;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6092. 替换数组中的元素
 * <p>
 * 给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字 operations[i][0] 替换成 operations[i][1] 。
 * <p>
 * 题目保证在第 i 个操作中：
 * <p>
 * operations[i][0] 在 nums 中存在。
 * operations[i][1] 在 nums 中不存在。
 * 请你返回执行完所有操作后的数组。
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
 * 输出：[3,2,7,1]
 * 解释：我们对 nums 执行以下操作：
 * - 将数字 1 替换为 3 。nums 变为 [3,2,4,6] 。
 * - 将数字 4 替换为 7 。nums 变为 [3,2,7,6] 。
 * - 将数字 6 替换为 1 。nums 变为 [3,2,7,1] 。
 * 返回最终数组 [3,2,7,1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2], operations = [[1,3],[2,1],[3,2]]
 * 输出：[2,1]
 * 解释：我们对 nums 执行以下操作：
 * - 将数字 1 替换为 3 。nums 变为 [3,2] 。
 * - 将数字 2 替换为 1 。nums 变为 [3,1] 。
 * - 将数字 3 替换为 2 。nums 变为 [2,1] 。
 * 返回最终数组 [2,1] 。
 * <p>
 * <p>
 * 提示：
 * n == nums.length
 * m == operations.length
 * 1 <= n, m <= 10^5
 * nums 中所有数字 互不相同 。
 * operations[i].length == 2
 * 1 <= nums[i], operations[i][0], operations[i][1] <= 10^6
 * 在执行第 i 个操作时，operations[i][0] 在 nums 中存在。
 * 在执行第 i 个操作时，operations[i][1] 在 nums 中不存在。
 * <p>
 * https://leetcode.cn/problems/replace-elements-in-an-array/
 */
public class Problem6092_replaceElementsInAnArray {

    // BF time: O(n^2) space: O(1)
    public static int[] arrayChange(int[] nums, int[][] operations) {
        int len = nums.length;
        int m = operations.length;
        for (int i = 0; i < m; i++) {
            int value = operations[i][0];
            for (int j = 0; j < len; j++) {
                if (value == nums[j]) {
                    nums[j] = operations[i][1];
                }
            }
        }

        return nums;
    }

    // HashMap time: O(n) space: O(n)
    public static int[] arrayChange_map(int[] nums, int[][] operations) {
        int len = nums.length;
        int m = operations.length;

        Map<Integer, Integer> idxMap = new HashMap<>();
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            idxMap.put(i, nums[i]);
            valueMap.put(nums[i], i);
        }

        for (int i = 0; i < m; i++) {
            int value = operations[i][0];
            int index = valueMap.get(value);
            idxMap.put(index, operations[i][1]);
            valueMap.put(operations[i][1], index);
        }

        for (int i = 0; i < len; i++) {
            nums[i] = idxMap.get(i);
        }

        return nums;
    }

    // HashMap Opt time: O(n) space: O(n)
    public static int[] arrayChange_map_opt(int[] nums, int[][] operations) {
        int len = nums.length;
        int m = operations.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < m; i++) {
            if (map.containsKey(operations[i][0])) {
                map.put(operations[i][1], map.remove(operations[i][0]));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getValue()] = entry.getKey();
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(" " + Arrays.toString(arrayChange_map(new int[]{1, 2}, new int[][]{{1, 3}, {2, 1}, {3, 2}})));
        System.out.println(" " + Arrays.toString(arrayChange(new int[]{1, 2, 4, 6}, new int[][]{{1, 3}, {4, 7}, {6, 1}})));
        System.out.println(" " + Arrays.toString(arrayChange_map(new int[]{1, 2, 4, 6}, new int[][]{{1, 3}, {4, 7}, {6, 1}})));
        System.out.println(" " + Arrays.toString(arrayChange_map_opt(new int[]{1, 2, 4, 6}, new int[][]{{1, 3}, {4, 7}, {6, 1}})));
    }
}
