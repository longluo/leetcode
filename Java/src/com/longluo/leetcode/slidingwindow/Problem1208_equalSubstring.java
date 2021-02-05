package com.longluo.leetcode.slidingwindow;

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s和t。
 * 将s中的第i个字符变到t中的第i个字符需要|s[i] - t[i]|的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "bcdf", cost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * <p>
 * 示例 2：
 * 输入：s = "abcd", t = "cdef", cost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * <p>
 * 示例 3：
 * 输入：s = "abcd", t = "acde", cost = 0
 * 输出：1
 * 解释：你无法作出任何改动，所以最大长度为 1。
 * <p>
 * 提示：
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s和t都只含小写英文字母。
 */
public class Problem1208_equalSubstring {

    // Trivial Solution
    public static int equalSubstring(String s, String t, int maxCost) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int cost = maxCost;
            for (int j = i; j < s.length(); j++) {
                int delta = Math.abs(s.charAt(j) - t.charAt(j));
                cost -= delta;
                if (cost >= 0) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return ans;
    }

    public static int equalSubstring2(String s, String t, int maxCost) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[] diff = new int[length];
        for (int i = 0; i < length; i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int left = 0;
        int right = 0;
        int windowSum = 0;
        int ans = 0;
        while (right < length) {
            windowSum += diff[right];
            while (windowSum > maxCost) {
                windowSum -= diff[left];
                left++;
            }

            ans = Math.max(ans, right - left + 1);
            right++;
        }

        System.out.println("[" + left + "," + right + "]");

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + equalSubstring("abcd", "bcdf", 3));
        System.out.println("1 ?= " + equalSubstring("abcd", "cdef", 3));
        System.out.println("1 ?= " + equalSubstring("abcd", "acde", 0));
        System.out.println("2 ?= " + equalSubstring("krrgw", "zjxss", 19));

        System.out.println("3 ?= " + equalSubstring2("abcd", "bcdf", 3));
        System.out.println("1 ?= " + equalSubstring2("abcd", "cdef", 3));
        System.out.println("1 ?= " + equalSubstring2("abcd", "acde", 0));
        System.out.println("2 ?= " + equalSubstring2("krrgw", "zjxss", 19));
        System.out.println("4 ?= " + equalSubstring2("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));
    }
}
