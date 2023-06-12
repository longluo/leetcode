package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * <p>
 * 提示：
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * https://leetcode.cn/problems/summary-ranges/
 */
public class Problem228_summaryRanges {

    // Simulate time: O(n) space: O(n)
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }

            StringBuilder sb = new StringBuilder();
            if (j > i) {
                sb.append(nums[i] + "->" + nums[j]);
            } else {
                sb.append(nums[i]);
            }

            ans.add(sb.toString());

            i = j;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[0->2, 4->5, 7] ?= " + summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println("[0, 2->4, 6, 8->9] ?= " + summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
