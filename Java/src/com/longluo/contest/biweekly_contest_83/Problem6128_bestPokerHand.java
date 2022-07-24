package com.longluo.contest.biweekly_contest_83;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 6128. 最好的扑克手牌
 * <p>
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 * <p>
 * 下述是从好到坏你可能持有的 手牌类型 ：
 * <p>
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 * <p>
 * 注意：返回的字符串 大小写 需与题目描述相同。
 * <p>
 * 示例 1：
 * 输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * 输出："Flush"
 * 解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
 * <p>
 * 示例 2：
 * 输入：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * 输出："Three of a Kind"
 * 解释：第一、二和四张牌组成三张相同大小的扑克牌，所以得到 "Three of a Kind" 。
 * 注意我们也可以得到 "Pair" ，但是 "Three of a Kind" 是更好的手牌类型。
 * 有其他的 3 张牌也可以组成 "Three of a Kind" 手牌类型。
 * 示例 3：
 * <p>
 * 输入：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * 输出："Pair"
 * 解释：第一和第二张牌大小相同，所以得到 "Pair" 。
 * 我们无法得到 "Flush" 或者 "Three of a Kind" 。
 * <p>
 * 提示：
 * ranks.length == suits.length == 5
 * 1 <= ranks[i] <= 13
 * 'a' <= suits[i] <= 'd'
 * 任意两张扑克牌不会同时有相同的大小和花色。
 * <p>
 * https://leetcode.cn/problems/best-poker-hand/
 */
public class Problem6128_bestPokerHand {

    // BF time: O(n) space: O(n)
    public static String bestHand(int[] ranks, char[] suits) {
        boolean isThree = false;
        boolean isPair = false;

        Map<Integer, Integer> cntMap = new HashMap<>();
        Set<Character> suitSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            suitSet.add(suits[i]);
            cntMap.put(ranks[i], cntMap.getOrDefault(ranks[i], 0) + 1);
            if (cntMap.get(ranks[i]) == 2) {
                isPair = true;
            } else if (cntMap.get(ranks[i]) > 2) {
                isThree = true;
            }
        }

        if (suitSet.size() == 1) {
            return "Flush";
        }

        if (isThree) {
            return "Three of a Kind";
        }

        if (isPair) {
            return "Pair";
        }

        return "High Card";
    }

    public static void main(String[] args) {
        System.out.println("Flush ?= " + bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));

    }
}
