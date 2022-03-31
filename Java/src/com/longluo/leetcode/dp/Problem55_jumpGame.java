package com.longluo.leetcode.dp;

/**
 * 55. 跳跃游戏
 * <p>
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i] <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/jump-game/
 */
public class Problem55_jumpGame {

    // BF O(n^2) O(n）
    public static boolean canJump_bf(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }

        boolean[] visited = new boolean[len];
        visited[0] = true;
        for (int i = 0; i < len; i++) {
            int steps = nums[i];
            if (visited[i] && steps > 0) {
                for (int j = 1; j <= steps && i + j < len; j++) {
                    visited[i + j] = true;
                }
            }
        }

        return visited[len - 1];
    }

    // Greedy O(n) O(1)
    public static boolean canJump_greedy(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return true;
        }

        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            int steps = nums[i];
            if (maxIdx >= i) {
                maxIdx = Math.max(maxIdx, i + steps);
                if (maxIdx >= len - 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        canJump_greedy(new int[]{2, 3, 1, 1, 4});
        canJump_greedy(new int[]{2, 0});
        canJump_greedy(new int[]{3, 2, 1, 0, 4});
    }
}
