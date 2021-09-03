package com.longluo.leetcode.twopointers;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class Problem28_implementStrStr {

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        int ans = -1;
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                    }
                }

                if (flag) {
                    if (ans == -1) {
                        ans = i;
                    }
                }
            }
        }

        return ans;
    }

    public static int strStr_2(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean isEqual = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }
            if (isEqual) {
                return i;
            }
        }

        return -1;
    }



    public static void main(String[] args) {
        System.out.println("2 ?= " + strStr("hello", "ll"));
        System.out.println("-1 ?= " + strStr("aaaaa", "bba"));
        System.out.println("0 ?= " + strStr("", ""));
        System.out.println("0 ?= " + strStr("a", "a"));
        System.out.println("4 ?= " + strStr("mississippi", "issip"));
    }
}
