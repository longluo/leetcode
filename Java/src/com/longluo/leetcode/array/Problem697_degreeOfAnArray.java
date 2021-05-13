package com.longluo.leetcode.array;

import java.util.*;

/**
 * 697. 数组的度
 * <p>
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在nums中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * <p>
 * 提示：
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * https://leetcode-cn.com/problems/degree-of-an-array/
 */
public class Problem697_degreeOfAnArray {

    public static int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Map<Integer, int[]> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (freqMap.containsKey(nums[i])) {
                int[] temp = freqMap.get(nums[i]);
                temp[0]++;
                temp[2] = i;
                freqMap.put(nums[i], temp);
            } else {
                int[] temp = new int[3];
                temp[0] = 1;
                temp[1] = temp[2] = i;
                freqMap.put(nums[i], temp);
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int[] value : freqMap.values()) {
            list.add(value);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return (o1[2] - o1[1]) - (o2[2] - o2[1]);
                }

                return o2[0] - o1[0];
            }
        });

        int[] max = list.get(0);
        int ans = max[2] - max[1] + 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println("6 ?= " + findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println("3 ?= " + findShortestSubArray(new int[]{1, 1, 2, 2, 2, 1}));
    }
}
