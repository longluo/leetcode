package com.longluo.contest.weekly_contest_300;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-300/
 */

/**
 * https://leetcode.cn/problems/decode-the-message/
 */
public class Problem1 {

    public static String decodeMessage(String key, String message) {
        int len = key.length();

        Map<Character, Character> map = new HashMap<>();

        int idx = 0;

        for (int i = 0; i < len; i++) {
            char ch = key.charAt(i);
            if (!Character.isLetter(ch) || map.containsKey(ch)) {
                continue;
            }

            map.put(ch, (char) ('a' + idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(map.get(ch));
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("this is a secret ?= " + decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println("the five boxing wizards jump quickly ?= " + decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
