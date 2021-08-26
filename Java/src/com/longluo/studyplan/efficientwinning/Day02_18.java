package com.longluo.studyplan.efficientwinning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/4sum/
 */
public class Day02_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int remain = target - nums[i] - nums[j];
                int m = n - 1;

                for (int k = j + 1; k < n - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    while (m > k && nums[k] + nums[m] > remain) {
                        m--;
                    }

                    if (k >= m) {
                        break;
                    }

                    if (nums[k] + nums[m] == remain) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[m]);
                        ans.add(list);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] ?= " + fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println("[[2,2,2,2]] ?= " + fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println("[[-2,-1,1,2],[-1,-1,1,1]] ?= " + fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
    }
}
