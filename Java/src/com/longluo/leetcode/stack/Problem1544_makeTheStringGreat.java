package com.longluo.leetcode.stack;

/**
 * 1544. Make The String Great
 * <p>
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * <p>
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 * <p>
 * Example 1:
 * Input: s = "leEeetcode"
 * Output: "leetcode"
 * Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
 * <p>
 * Example 2:
 * Input: s = "abBAcC"
 * Output: ""
 * Explanation: We have many possible scenarios, and all lead to the same answer. For example:
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * <p>
 * Example 3:
 * Input: s = "s"
 * Output: "s"
 * <p>
 * Constraints:
 * 1 <= s.length <= 100
 * s contains only lower and upper case English letters.
 * <p>
 * https://leetcode.cn/problems/make-the-string-great/
 */
public class Problem1544_makeTheStringGreat {

    // Stack time: O(n) space: O(n)
    public static String makeGood(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && ((Character.isUpperCase(ch) && sb.charAt(sb.length() - 1) == Character.toLowerCase(ch))
                    || (Character.isLowerCase(ch) && sb.charAt(sb.length() - 1) == Character.toUpperCase(ch)))) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Stack time: O(n) space: O(n)
    public static String makeGood_opt(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && Math.abs(ch - sb.charAt(sb.length() - 1)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // Stack XOR time: O(n) space: O(n)
    public static String makeGood_xor(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (sb.length() > 0 && (ch ^ sb.charAt(sb.length() - 1)) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("leetcode ?= " + makeGood("leEeetcode"));
        System.out.println(" ?= " + makeGood("abBAcC"));
        System.out.println("s ?= " + makeGood("s"));

        System.out.println("leetcode ?= " + makeGood_opt("leEeetcode"));
        System.out.println("leetcode ?= " + makeGood_xor("leEeetcode"));
    }
}
