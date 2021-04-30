package com.longluo.leetcode.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * <p>
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 * <p>
 * 提示：
 * 2 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 除两个只出现一次的整数外，nums 中的其他数字都出现两次
 * <p>
 * https://leetcode-cn.com/problems/single-number-iii/
 */
public class Problem260_singleNumber {

    public static int[] singleNumber(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }

        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int j = 0;
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            if (entry.getValue() == 1) {
                ans[j] = entry.getKey();
                j++;
            }
        }

        return ans;
    }

    public static int[] singleNumber_bit(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        System.out.println("[3, 5] ?= " + Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println("[3, 5] ?= " + Arrays.toString(singleNumber_bit(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println("[-1, 0] ?= " + Arrays.toString(singleNumber(new int[]{-1, 0})));
        System.out.println("[-1, 0] ?= " + Arrays.toString(singleNumber_bit(new int[]{-1, 0})));
        System.out.println("[0, 1] ?= " + Arrays.toString(singleNumber(new int[]{0, 1})));
        System.out.println("[0, 1] ?= " + Arrays.toString(singleNumber_bit(new int[]{0, 1})));
    }
}
