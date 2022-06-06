package com.longluo.top_interviews;

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
 * https://leetcode.com/problems/implement-strstr/
 */
public class Problem28_implementStrStr {

    // BF time: O(n*m) space: O(1)
    public static int strStr_bf(String haystack, String needle) {
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

    // KMP Standard
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }

        return -1;
    }

    // KMP Mine time: O(n+m) space: O(m)
    public static int strStr_kmp(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int sLen = haystack.length();
        int pLen = needle.length();

        int[] next = new int[pLen];

        // build next array
        for (int right = 1, left = 0; right < pLen; right++) {

            while (left > 0 && needle.charAt(left) != needle.charAt(right)) {
                left = next[left - 1];
            }

            if (needle.charAt(left) == needle.charAt(right)) {
                left++;
            }

            next[right] = left;
        }

        for (int i = 0, j = 0; i < sLen; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }

            if (j == pLen) {
                return i - pLen + 1;
            }
        }

        return -1;
    }

    // 前缀表不需要减一的实现方式
    public int strStr_ref(String haystack, String needle) {
        // 当needle是空字符串时，返回0
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int patLen = needle.length();

        int[] next = new int[patLen];

        // 定义好next数组
        for (int right = 1, left = 0; right < patLen; right++) {
            // 定义好两个指针right与left
            // 在for循环中初始化指针right为1，left=0，开始计算next数组，right始终在left指针的后面
            // 用while 而不是if，因为需要逐步回退到0
            while (left > 0 && needle.charAt(left) != needle.charAt(right)) {
                // 如果不相等就让left指针回退，到0时就停止回退
                left = next[left - 1]; //进行回退操作；
            }

            if (needle.charAt(left) == needle.charAt(right)) {
                left++;
            }

            // 这是从 1 开始的
            next[right] = left;
        }

        // 循环结束的时候，next数组就已经计算完毕了

        for (int i = 0, j = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == patLen) {
                return i - patLen + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + strStr_bf("hello", "ll"));
        System.out.println("-1 ?= " + strStr("aaaaa", "bba"));
        System.out.println("0 ?= " + strStr("", ""));
        System.out.println("0 ?= " + strStr("a", "a"));

        System.out.println("4 ?= " + strStr("mississippi", "issip"));
        System.out.println("4 ?= " + strStr_kmp("mississippi", "issip"));
    }
}
