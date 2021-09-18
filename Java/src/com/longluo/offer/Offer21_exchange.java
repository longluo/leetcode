package com.longluo.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 */
public class Offer21_exchange {

    public static int[] exchange(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                res[left++] = nums[i];
            } else {
                res[right--] = nums[i];
            }
        }

        return res;
    }

    public static int[] exchange2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int tmp;
        while (left < right) {
            if (left < right && nums[left] % 2 != 0) {
                left++;
                continue;
            }

            if (left < right && nums[right] % 2 == 0) {
                right--;
                continue;
            }

            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        return nums;
    }

    public static int[] exchange3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int tmp;
        while (left < right) {
            if (left < right && (nums[left] & 1) == 1) {
                left++;
                continue;
            }

            if (left < right && (nums[right] & 1) == 0) {
                right--;
                continue;
            }

            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("[1,3,2,4] ?= " + Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
        System.out.println("[1,3,2,4] ?= " + Arrays.toString(exchange2(new int[]{1, 2, 3, 4})));
        System.out.println("[1,3,2,4] ?= " + Arrays.toString(exchange3(new int[]{1, 2, 3, 4})));
    }
}
