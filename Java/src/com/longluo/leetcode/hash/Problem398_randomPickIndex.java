package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 398. 随机数索引
 * <p>
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * <p>
 * <p>
 * https://leetcode-cn.com/problems/random-pick-index/
 */
public class Problem398_randomPickIndex {

    // BF HashMap time: O(n) space: O(n)
    static class Solution {
        Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
            int len = nums.length;
            map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int x = nums[i];
                if (map.containsKey(x)) {
                    List<Integer> list = map.get(x);
                    list.add(i);
                    map.put(x, list);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(x, list);
                }
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            if (list.size() <= 1) {
                return list.get(0);
            } else {
                int idx = new Random().nextInt(list.size());
                return list.get(idx);
            }
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */

    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1, 2, 3, 3, 3});
        System.out.println("1 ?= " + s.pick(2));
        System.out.println("0 ?= " + s.pick(1));
        System.out.println("3 ?= " + s.pick(3));
    }
}
