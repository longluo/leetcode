package com.longluo.contest.weekly_contest_300;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-300/
 */

/**
 * 2325. 解密消息
 * <p>
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * <p>
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，
 * 可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 * <p>
 * 示例 1：
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 * <p>
 * 示例 2：
 * 输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * 输出："the five boxing wizards jump quickly"
 * 解释：对照表如上图所示。
 * 提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
 * <p>
 * 提示：
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 * <p>
 * https://leetcode.cn/problems/decode-the-message/
 */
public class Problem2325_decodeTheMessage {

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

    // HashMap time: O(n) space: O(C)
    public static String decodeMessage_hash(String key, String message) {
        Map<Character, Character> map = new HashMap<>();

        int idx = 0;

        for (char ch : key.toCharArray()) {
            if (ch == ' ' || map.containsKey(ch)) {
                continue;
            }

            char encodedChar = (char) ('a' + idx);
            map.put(ch, encodedChar);
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (ch != ' ') {
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

        System.out.println("this is a secret ?= " + decodeMessage_hash("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println("the five boxing wizards jump quickly ?= " + decodeMessage_hash("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
