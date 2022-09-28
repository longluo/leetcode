package com.longluo.lcci;

/**
 * 面试题 10.05. 稀疏数组搜索
 * <p>
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * <p>
 * 示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * <p>
 * 示例2:
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * <p>
 * 提示:
 * words的长度在[1, 1000000]之间
 * <p>
 * https://leetcode.cn/problems/sparse-array-search-lcci/?favorite=xb9lfcwi
 */
public class Lcci_10_05_sparseArraySearch {

    // Simulate time: O(n) space: O(1)
    public static int findString(String[] words, String s) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            if (s.equals(words[i])) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("-1 ?= " + findString(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ta"));
    }
}
