package com.longluo.lcci;

import java.util.Arrays;

/**
 * 面试题 17.05.  字母与数字
 * <p>
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * <p>
 * 示例 2:
 * 输入: ["A","A"]
 * 输出: []
 * <p>
 * 提示：
 * array.length <= 100000
 * <p>
 * https://leetcode.cn/problems/find-longest-subarray-lcci/
 */
public class Lcci_17_05_findLongestSubarray {

    // PrefixSums time: O(n^2) space: O(n)
    public static String[] findLongestSubarray(String[] array) {
        int n = array.length;

        int[] prefixSums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = array[i].charAt(0);
            if (Character.isLetter(ch)) {
                prefixSums[i + 1] = 1 + prefixSums[i];
            } else {
                prefixSums[i + 1] = -1 + prefixSums[i];
            }
        }

        if (prefixSums[n] == 0) {
            return array;
        }

        int idx = n;
        int maxLen = 0;

        for (int i = n; i >= 2; i--) {
            boolean flag = false;
            for (int j = 0; j <= n - i; j++) {
                if (prefixSums[j] == prefixSums[j + i]) {
                    flag = true;
                    idx = j;
                    break;
                }
            }

            if (flag) {
                maxLen = i;
                break;
            }
        }

        if (maxLen == 0) {
            return new String[]{};
        }

        String[] ans = new String[maxLen];
        for (int i = 0; i < maxLen; i++) {
            ans[i] = array[idx + i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + Arrays.toString(findLongestSubarray(new String[]{"A", "A"})));
        System.out.println("['A','1','B','C','D','2','3','4','E','5','F','G','6','7'] ?= " + Arrays.toString(findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
    }
}
