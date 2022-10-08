package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. 缺失的区间
 * <p>
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 * <p>
 * https://leetcode.cn/problems/missing-ranges/
 */
public class Problem163_missingRanges {

    // Simulate time: O(n) space: O(n)
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (lower > upper) {
            return ans;
        }

        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                ans.add(String.valueOf(lower));
            } else {
                ans.add(lower + "->" + upper);
            }

            return ans;
        } else if (nums.length == 1) {
            if (lower == nums[0]) {
                if (upper == lower + 1) {
                    ans.add(String.valueOf(upper));
                } else if (upper > lower + 1) {
                    String s = (lower + 1) + "->" + upper;
                    ans.add(s);
                }
            } else if (lower < nums[0]) {
                if (nums[0] == upper) {
                    if (lower + 1 == nums[0]) {
                        ans.add(String.valueOf(lower));
                    } else if (lower + 2 <= nums[0]) {
                        String s = lower + "->" + (upper - 1);
                        ans.add(s);
                    }
                } else if (nums[0] < upper) {
                    if (lower + 1 == nums[0] && upper == nums[0] + 1) {
                        ans.add(String.valueOf(lower));
                        ans.add(String.valueOf(upper));
                    } else if (lower + 1 < nums[0] && upper == nums[0] + 1) {
                        String s = lower + "->" + (nums[0] - 1);
                        ans.add(s);
                        ans.add(String.valueOf(upper));
                    } else if (lower + 2 <= nums[0] && upper >= nums[0] + 1) {
                        String left = lower + "->" + (nums[0] - 1);
                        String right = (nums[0] + 1) + "->" + upper;
                        ans.add(left);
                        ans.add(right);
                    } else if (lower + 1 == nums[0] && upper > nums[0] + 1) {
                        ans.add(String.valueOf(lower));
                        String right = (nums[0] + 1) + "->" + upper;
                        ans.add(right);
                    }
                }
            }

            return ans;
        }

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[0] > lower + 1) {
                    String s = lower + "->" + (nums[0] - 1);
                    ans.add(s);
                } else if (nums[0] == lower + 1) {
                    ans.add(String.valueOf(lower));
                }
            } else {
                if (nums[i] == nums[i - 1] + 2) {
                    ans.add(String.valueOf(nums[i - 1] + 1));
                } else if (nums[i] > nums[i - 1] + 2) {
                    String s = (nums[i - 1] + 1) + "->" + (nums[i] - 1);
                    ans.add(s);
                }
            }
        }

        if (nums[len - 1] + 1 == upper) {
            ans.add(String.valueOf(upper));
        } else if (nums[len - 1] + 2 <= upper) {
            String s = (nums[len - 1] + 1) + "->" + upper;
            ans.add(s);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 4->49, 51->74, 76->99] ?= " + findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println("[0] ?= " + findMissingRanges(new int[]{-1}, -1, 0));
        System.out.println("[0->1, 3->9] ?= " + findMissingRanges(new int[]{2}, 0, 9));
        System.out.println("[0->7, 9] ?= " + findMissingRanges(new int[]{8}, 0, 9));
        System.out.println("[0->4, 6-7, 9] ?= " + findMissingRanges(new int[]{5, 8}, 0, 9));
    }
}
