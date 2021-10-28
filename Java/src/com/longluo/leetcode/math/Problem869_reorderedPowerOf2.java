package com.longluo.leetcode.math;

import java.util.Arrays;
import java.util.Set;

/**
 * 869. 重新排序得到 2 的幂
 * <p>
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：1
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：10
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：16
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：24
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：46
 * 输出：true
 * <p>
 * 提示：
 * 1 <= N <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/reordered-power-of-2/
 */
public class Problem869_reorderedPowerOf2 {

    public static boolean reorderedPowerOf2(int n) {
        String str = Integer.toString(n);
        char[] array = str.toCharArray();
        Arrays.sort(array);
        boolean[] visited = new boolean[array.length];
        return backtrack(array, visited, 0, 0);
    }

    public static boolean backtrack(char[] nums, boolean[] visited, int idx, int num) {
        if (idx == nums.length) {
            return isPowerOf2(num);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '0' && num == 0) {
                continue;
            }

            if (visited[i] || (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }

            visited[i] = true;
            if (backtrack(nums, visited, idx + 1, num * 10 + nums[i] - '0')) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public static boolean isPowerOf2(int num) {
        if ((num & (num - 1)) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + reorderedPowerOf2(1));
        System.out.println("false ?= " + reorderedPowerOf2(10));
        System.out.println("false ?= " + reorderedPowerOf2(24));
        System.out.println("true ?= " + reorderedPowerOf2(16));
        System.out.println("true ?= " + reorderedPowerOf2(46));
        System.out.println("true ?= " + reorderedPowerOf2(218));
    }
}
