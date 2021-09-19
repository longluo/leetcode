package com.longluo.offer;

import java.util.Arrays;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，
 * 而大、小王为0，可以看成任意数字。A不能视为14。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * 限制：
 * 数组长度为5
 * 数组的数取值为[0, 13].
 * <p>
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 */
public class Offer61_isStraight {

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokerNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                jokerNum++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return nums[nums.length - 1] - nums[jokerNum] < 5;
    }

    public static boolean isStraight_1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }

        Arrays.sort(nums);
        int jokerNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                jokerNum++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            } else if (nums[i] + 1 == nums[i + 1]) {
                continue;
            } else if (nums[i] < nums[i + 1]) {
                if (nums[i + 1] - nums[i] > (jokerNum + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println("false ?= " + isStraight(new int[]{0, 0, 2, 2, 5}));
        System.out.println("true ?= " + isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println("false ?= " + isStraight(new int[]{1, 1, 3, 4, 5}));
        System.out.println("true ?= " + isStraight(new int[]{11, 0, 9, 0, 0}));
        System.out.println("true ?= " + isStraight_1(new int[]{11, 0, 9, 0, 0}));
        System.out.println("false ?= " + isStraight(new int[]{9, 2, 6, 7, 10}));
        System.out.println("false ?= " + isStraight_1(new int[]{9, 2, 6, 7, 10}));
    }
}
