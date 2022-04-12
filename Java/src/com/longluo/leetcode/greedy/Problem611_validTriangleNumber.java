package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * <p>
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * <p>
 * 示例 1:
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * 注意:
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * <p>
 * https://leetcode-cn.com/problems/valid-triangle-number/
 */
public class Problem611_validTriangleNumber {

    // BF Sort time: O(n^3) space: O(1)
    // AC
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }

        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + triangleNumber(new int[]{2, 2, 3, 4}));
    }
}
