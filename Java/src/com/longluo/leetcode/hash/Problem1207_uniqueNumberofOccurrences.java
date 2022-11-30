package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 1207. 独一无二的出现次数
 * <p>
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 提示：
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * <p>
 * https://leetcode.cn/problems/unique-number-of-occurrences/
 */
public class Problem1207_uniqueNumberofOccurrences {

    // HashMap time: O(n) space: O(n)
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (int x : map.values()) {
            if (set.contains(x)) {
                return false;
            }

            set.add(x);
        }

        return true;
    }

    // Count time: O(n) space: O(n)
    public static boolean uniqueOccurrences_count(int[] arr) {
        int[] count = new int[2002];

        for (int x : arr) {
            count[x + 1000]++;
        }

        boolean[] flag = new boolean[2002];
        for (int x : count) {
            if (x == 0) {
                continue;
            }

            if (flag[x]) {
                return false;
            }

            flag[x] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + uniqueOccurrences(new int[]{1, 2}));
        System.out.println("true ?= " + uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println("true ?= " + uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println("true ?= " + uniqueOccurrences_count(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }
}
