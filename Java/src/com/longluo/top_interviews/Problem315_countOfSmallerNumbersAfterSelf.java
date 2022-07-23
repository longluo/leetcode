package com.longluo.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * <p>
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例 1：
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * <p>
 * 示例 2：
 * 输入：nums = [-1]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 */
public class Problem315_countOfSmallerNumbersAfterSelf {

    // BF time: O(n^2) space: O(1)
    public static List<Integer> countSmaller_bf(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }

            ans.add(cnt);
        }

        return ans;
    }

    // BinarySearch time: O(n^2logn) space: O(n)
    public static List<Integer> countSmaller_bs(int[] nums) {
        List<Integer> ans = new ArrayList<>();


        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 1, 1, 0] ?= " + countSmaller_bf(new int[]{5, 2, 6, 1}));
        System.out.println("[2, 1, 1, 0] ?= " + countSmaller_bf(new int[]{5, 2, 6, 1}));
        System.out.println("[2, 1, 1, 0] ?= " + countSmaller_bs(new int[]{5, 2, 6, 1}));
    }
}
