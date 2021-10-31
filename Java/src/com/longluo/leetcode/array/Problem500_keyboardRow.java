package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 500. 键盘行
 * <p>
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * American keyboard
 * <p>
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * <p>
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 * <p>
 * https://leetcode-cn.com/problems/keyboard-row/
 */
public class Problem500_keyboardRow {

    public static String[] findWords(String[] words) {
        Map<Character, Integer> keyboardMap = new HashMap<>();
        for (char ch : "qwertyuiop".toCharArray()) {
            keyboardMap.put(ch, 1);
        }
        for (char ch : "asdfghjkl".toCharArray()) {
            keyboardMap.put(ch, 2);
        }
        for (char ch : "zxcvbnm".toCharArray()) {
            keyboardMap.put(ch, 3);
        }
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() <= 1) {
                ans.add(word);
                continue;
            }

            boolean isSameRow = true;
            int rowIdx = keyboardMap.get(Character.toLowerCase(word.charAt(0)));
            for (int i = 1; i < word.length(); i++) {
                if (keyboardMap.get(Character.toLowerCase(word.charAt(i))) != rowIdx) {
                    isSameRow = false;
                    break;
                }
            }
            if (isSameRow) {
                ans.add(word);
            }
        }

        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[Alaska, Dad] ?= " + findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"}));
    }
}
