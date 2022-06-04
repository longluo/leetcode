package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 384. 打乱数组
 * <p>
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 * <p>
 * 实现 Solution class:
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 * <p>
 * 示例：
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -10^6 <= nums[i] <= 10^6
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 5 * 10^4 次 reset 和 shuffle
 * <p>
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class Problem384_shuffleAnArray {

    // BF time: O(n) space: O(n)
    static class Solution {
        int len;
        int[] original;
        Random random = new Random();

        public Solution(int[] nums) {
            this.len = nums.length;
            original = new int[len];
            System.arraycopy(nums, 0, original, 0, len);
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] shuffled = new int[len];
            List<Integer> numsList = new ArrayList<>();
            for (int x : original) {
                numsList.add(x);
            }

            for (int i = 0; i < len; i++) {
                int idx = random.nextInt(numsList.size());
                shuffled[i] = numsList.get(idx);
                numsList.remove(idx);
            }

            return shuffled;
        }
    }

    // Knuth
    static class Solution_Knuth {
        int len;
        int[] original;
        Random random = new Random();

        public Solution_Knuth(int[] nums) {
            this.len = nums.length;
            original = new int[len];
            System.arraycopy(nums, 0, original, 0, len);
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] shuffled = new int[len];
            System.arraycopy(original, 0, shuffled, 0, len);
            for (int i = len - 1; i >= 0; i--) {
                int idx = random.nextInt(i + 1);
                int temp = shuffled[i];
                shuffled[i] = shuffled[idx];
                shuffled[idx] = temp;
            }

            return shuffled;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(sol.shuffle()));
        System.out.println(Arrays.toString(sol.reset()));
        System.out.println(Arrays.toString(sol.shuffle()));

        Solution_Knuth sol2 = new Solution_Knuth(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(sol2.shuffle()));
        System.out.println(Arrays.toString(sol2.reset()));
        System.out.println(Arrays.toString(sol2.shuffle()));
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */