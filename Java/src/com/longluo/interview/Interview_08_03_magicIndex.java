package com.longluo.interview;

/**
 * 面试题 08.03. 魔术索引
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 示例1:
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * <p>
 * 示例2:
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * <p>
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 */
public class Interview_08_03_magicIndex {

    public static int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + findMagicIndex(new int[]{0, 2, 3, 4, 5}));
        System.out.println("1 ?= " + findMagicIndex(new int[]{1, 1, 1}));
    }
}
