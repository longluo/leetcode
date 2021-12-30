package com.longluo.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846. 一手顺子
 * <p>
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，
 * 并且由 groupSize 张连续的牌组成。
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；
 * 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * <p>
 * 示例 2：
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * 提示：
 * 1 <= hand.length <= 10^4
 * 0 <= hand[i] <= 10^9
 * 1 <= groupSize <= hand.length
 * <p>
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * <p>
 * https://leetcode-cn.com/problems/hand-of-straights/
 */
public class Problem846_handOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand == null || hand.length < groupSize || hand.length % groupSize != 0) {
            return false;
        }

        if (groupSize == 1) {
            return true;
        }

        int len = hand.length;
        Arrays.sort(hand);
        int seqCnt = 0;
        for (int i = 0; i < len; i++) {
            if (hand[i] != -1) {
                int seqNum = hand[i];
                int seqLen = 1;
                seqNum++;
                hand[i] = -1;
                for (int j = i + 1; j < len; j++) {
                    if (hand[j] == seqNum) {
                        seqLen++;
                        seqNum++;
                        hand[j] = -1;
                        if (seqLen == groupSize) {
                            seqCnt++;
                            break;
                        }
                    }
                }
            }
        }

        if (seqCnt == len / groupSize) {
            return true;
        }

        return false;
    }

    public static boolean isNStraightHand_greedy(int[] hand, int groupSize) {
        if (hand == null || hand.length < groupSize || hand.length % groupSize != 0) {
            return false;
        }

        if (groupSize == 1) {
            return true;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : hand) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (int num : hand) {
            if (!cntMap.containsKey(num)) {
                return false;
            }
            if (cntMap.get(num) > 0) {
                for (int j = num; j < num + groupSize; j++) {
                    if (cntMap.containsKey(j) && cntMap.get(j) > 0) {
                        cntMap.put(j, cntMap.getOrDefault(j, 0) - 1);
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isNStraightHand(new int[]{1, 2, 3}, 1));
        System.out.println("true ?= " + isNStraightHand(new int[]{2, 1}, 2));
        System.out.println("false ?= " + isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 2));
        System.out.println("false ?= " + isNStraightHand_greedy(new int[]{1, 1, 2, 2, 3, 3}, 2));
        System.out.println("true ?= " + isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println("true ?= " + isNStraightHand_greedy(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        System.out.println("false ?= " + isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));
    }
}
