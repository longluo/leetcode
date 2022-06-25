package com.longluo.offer_ii;

/**
 * 剑指 Offer II 032. 有效的变位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "a"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t 仅包含小写字母
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode.cn/problems/valid-anagram/
 * <p>
 * https://leetcode.cn/problems/dKk3P7/
 */
public class Offer2_32_isAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }

        int[] arrayS = new int[26];
        int[] arrayT = new int[26];

        int n = s.length();
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                isSame = false;
            }
            arrayS[s.charAt(i) - 'a']++;
            arrayT[t.charAt(i) - 'a']++;
        }

        if (isSame) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            if (arrayS[i] != arrayT[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isAnagram("anagram", "nagaram"));
        System.out.println("false ?= " + isAnagram("rat", "car"));
        System.out.println("false ?= " + isAnagram("a", "a"));
    }
}
