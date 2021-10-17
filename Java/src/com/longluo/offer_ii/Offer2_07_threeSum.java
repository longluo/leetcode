package com.longluo.offer_ii;

import java.util.*;

/**
 * 剑指 Offer II 007. 数组中和为 0 的三个数
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且 不重复 的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 * <p>
 * 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/
 * <p>
 * https://leetcode-cn.com/problems/1fGaJU/
 */
public class Offer2_07_threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        res.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum_tp(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + threeSum(new int[]{}));
        System.out.println("[] ?= " + threeSum(new int[]{0}));
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[[-1,-1,2],[-1,0,1]] ?= " + threeSum_tp(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("[0, 0, 0] ?= " + threeSum(new int[]{0, 0, 0, 0}));
        System.out.println("[0, 0, 0] ?= " + threeSum_tp(new int[]{0, 0, 0, 0}));
        System.out.println("[0, 0, 0] ?= " + threeSum_tp(new int[]{0, 0, 0}));
    }
}
