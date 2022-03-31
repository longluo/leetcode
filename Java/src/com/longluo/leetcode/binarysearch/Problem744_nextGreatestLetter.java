package com.longluo.leetcode.binarysearch;

/**
 * 744. 寻找比目标字母大的最小字母
 * <p>
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，
 * 请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * <p>
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * <p>
 * 示例 3:
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * <p>
 * 提示：
 * 2 <= letters.length <= 10^4
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 * <p>
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class Problem744_nextGreatestLetter {

    // BF O(n) O(1)
    public static char nextGreatestLetter_bf(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            char ch = letters[i];
            if (ch > target) {
                return ch;
            }
        }

        return letters[0];
    }

    public static char nextGreatestLetter_bf_opt(char[] letters, char target) {
        if (letters[0] > target) {
            return letters[0];
        }

        for (int i = 0; i < letters.length; i++) {
            char ch = letters[i];
            if (ch > target) {
                return ch;
            }
        }

        return letters[0];
    }

    // Binary Search O(nlogn) O(1)
    public static char nextGreatestLetter_bs(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            char ch = letters[mid];
            if (ch <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

         return letters[left] <= target ? letters[0] : letters[left];
    }

    // Mark O(n) O(1)
    public static char nextGreatestLetter_mark(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (int i = 0; i < letters.length; i++) {
            seen[letters[i] - 'a'] = true;
        }

        while (true) {
            target++;
            if (target > 'z') {
                target = 'a';
            }
            if (seen[target - 'a']) {
                return target;
            }
        }
    }

    public static void main(String[] args) {
        nextGreatestLetter_bs(new char[]{'a', 'b', 'c', 'd'}, 'z');
    }
}
