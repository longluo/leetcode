package com.longluo.offer_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 084. 含有重复元素集合的全排列
 * <p>
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * https://leetcode-cn.com/problems/7p8L0Z/
 */
public class Offer2_84_permuteUnique {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }


        return ans;
    }

    public static void main(String[] args) {

    }
}
