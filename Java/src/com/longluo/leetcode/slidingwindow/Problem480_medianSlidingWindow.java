package com.longluo.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 480. 滑动窗口中位数
 * <p>
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。
 * 你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * 示例：
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * 提示：
 * 你可以假设k始终有效，即：k始终小于输入的非空数组的元素个数。
 * 与真实值误差在10^-5以内的答案将被视作正确答案。
 *
 */
public class Problem480_medianSlidingWindow {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new double[]{};
        }

        double[] res = new double[nums.length - k + 1];
        List<Integer> list = new LinkedList<>();
        int left = 0;
        int right = left + k - 1;
        double sum = 0;
        int idx = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
            list.add(nums[i]);
        }
        Collections.sort(list);
        if (k % 2 == 0) {
            res[idx] = sum / k;
        } else {
            res[idx] = list.get(k / 2);
        }
        while (left < right && left < nums.length - 1 && right < nums.length - 1) {
            sum -= nums[left];
            list.remove(nums[left]);
            left++;
            right++;
            sum += nums[right];
            list.add(nums[right]);
            idx++;
            Collections.sort(list);
            if (k % 2 == 0) {
                res[idx] = sum / k;
            } else {
                res[idx] = list.get(k / 2);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[1,-1,-1,3,5,6] ?= " +
                Arrays.toString(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
