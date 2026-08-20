package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3069. 将元素分配到两个数组中 I
 * <p>
 * 简单
 * <p>
 * 给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。
 * <p>
 * 你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 * <p>
 * 如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
 * 通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。
 * <p>
 * 返回数组 result 。
 * <p>
 * https://leetcode.cn/problems/distribute-elements-into-two-arrays-i/description/
 */
public class Problem3069_resultArray {

    public static int[] resultArray(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return nums;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < list1.size(); i++) {
            ans[i] = list1.get(i);
        }

        for (int j = 0; j < list2.size(); j++) {
            ans[list1.size() + j] = list2.get(j);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3, 1] ?= " + Arrays.toString(resultArray(new int[]{2, 1, 3})));
    }
}
