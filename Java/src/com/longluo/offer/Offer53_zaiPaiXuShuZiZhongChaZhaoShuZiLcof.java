package com.longluo.offer;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 * <p>
 * 限制：
 * 0 <= 数组长度 <= 50000
 * <p>
 * 注意：本题与主站 34 题相同（仅返回值不同）：
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53_zaiPaiXuShuZiZhongChaZhaoShuZiLcof {

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        for (int i = mid; i < n; i++) {
            if (nums[i] == target) {
                ans++;
            } else {
                break;
            }
        }

        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] == target) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println("0 ?= " + search(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }
}
