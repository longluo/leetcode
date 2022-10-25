package com.longluo.leetcode.array;

/**
 * 915. 分割数组
 * <p>
 * 给定一个数组 nums ，将其划分为两个连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 的长度要尽可能小。
 * 在完成这样的分组后返回 left 的 长度 。
 * <p>
 * 用例可以保证存在这样的划分方法。
 * <p>
 * 示例 1：
 * 输入：nums = [5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * 示例 2：
 * 输入：nums = [1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 nums 进行划分。
 * <p>
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 */
public class Problem915_partitionArrayIntoDisjointIntervals {

    // Simulate time: O(n^2) space: O(1)
    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;

        int max = nums[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            boolean flag = true;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < max) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return i + 1;
            }
        }

        return 0;
    }

    // Simulate time: O(3*n) space: O(n)
    public static int partitionDisjoint_opt(int[] nums) {
        int len = nums.length;

        int[] leftMax = new int[len];
        leftMax[0] = nums[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        int[] rightMin = new int[len];
        rightMin[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    // Simulate time: O(2*n) space: O(n)
    public static int partitionDisjoint_opt_2(int[] nums) {
        int len = nums.length;
        int leftMax = nums[0];

        int[] rightMin = new int[len];
        rightMin[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        for (int i = 0; i < len - 1; i++) {
            leftMax = Math.max(leftMax, nums[i]);

            if (leftMax <= rightMin[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    // Best time: O(n) space: O(1)
    public static int partitionDisjoint_best(int[] nums) {
        int len = nums.length;

        int leftMax = nums[0];
        int max = leftMax;

        int ans = 0;

        for (int i = 1; i < len; i++) {
            if (leftMax > nums[i]) {
                ans = i;
                leftMax = max;
            } else {
                max = Math.max(max, nums[i]);
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + partitionDisjoint(new int[]{5, 0, 3, 8, 6}));
        System.out.println("4 ?= " + partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}));

        System.out.println("4 ?= " + partitionDisjoint_opt(new int[]{1, 1, 1, 0, 6, 12}));
        System.out.println("4 ?= " + partitionDisjoint_opt_2(new int[]{1, 1, 1, 0, 6, 12}));

        System.out.println("4 ?= " + partitionDisjoint_best(new int[]{1, 1, 1, 0, 6, 12}));
    }
}
