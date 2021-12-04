package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 383. 赎金信
 * <p>
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 * <p>
 * 如果可以构成，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * <p>
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/ransom-note/
 */
public class Problem383_ransomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            magMap.put(ch, magMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!magMap.containsKey(ch)) {
                return false;
            } else {
                int num = magMap.get(ch);
                if (num == 0) {
                    return false;
                } else {
                    magMap.put(ch, num - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + canConstruct("a", "b"));
        System.out.println("false ?= " + canConstruct("aa", "ab"));
        System.out.println("true ?= " + canConstruct("aa", "aab"));
    }
}
