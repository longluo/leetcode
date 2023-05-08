package com.longluo.leetcode.Counting;

import java.util.HashMap;
import java.util.Map;

/**
 * 1419. 数青蛙
 * <p>
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
 * 所以 croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，
 * 那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 * 示例 1：
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * <p>
 * 示例 2：
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * <p>
 * 示例 3：
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 * <p>
 * 提示：
 * 1 <= croakOfFrogs.length <= 10^5
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 * <p>
 * https://leetcode.cn/problems/minimum-number-of-frogs-croaking/
 */
public class Problem1419_minimumNumberofFrogsCroaking {

    // BF time: O(n) space: O(C)
    public static int minNumberOfFrogs(String croakOfFrogs) {
        int n = croakOfFrogs.length();
        if (n % 5 != 0) {
            return -1;
        }

        int ans = 0;

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = croakOfFrogs.charAt(i);
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);

            int[] cnt = new int[5];
            int idx = 0;
            for (char x : "croak".toCharArray()) {
                cnt[idx] = countMap.getOrDefault(x, 0);
                idx++;
            }

            for (int j = 0; j < 4; j++) {
                if (cnt[j] < cnt[j + 1]) {
                    return -1;
                }
            }

            ans = Math.max(ans, cnt[0] - cnt[4]);
        }

        int cnt = countMap.get('c');
        for (char x : "roak".toCharArray()) {
            if (cnt != countMap.getOrDefault(x, 0)) {
                return -1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minNumberOfFrogs("croakcroak"));
        System.out.println("2 ?= " + minNumberOfFrogs("crcoakroak"));
        System.out.println("2 ?= " + minNumberOfFrogs("crocakcroraoakk"));
        System.out.println("-1 ?= " + minNumberOfFrogs("cccccccrrooaakk"));
        System.out.println("-1 ?= " + minNumberOfFrogs("croakcrook"));
        System.out.println("-1 ?= " + minNumberOfFrogs("croakcroa"));
    }
}
