package com.longluo.leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1405. 最长快乐字符串
 * <p>
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * <p>
 * 示例 2：
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * <p>
 * 示例 3：
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 * <p>
 * 提示：
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 * <p>
 * https://leetcode.cn/problems/longest-happy-string/
 */
public class Problem1405_longestHappyString {

    // TODO: 2022/7/3  
    static class CharIdx {
        int num;
        char ch;

        CharIdx(int num, char ch) {
            this.num = num;
            this.ch = ch;
        }
    }

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        CharIdx aIdx = new CharIdx(a, 'a');
        CharIdx bIdx = new CharIdx(b, 'b');
        CharIdx cIdx = new CharIdx(c, 'c');
        List<CharIdx> res = new ArrayList<>();
        res.add(aIdx);
        res.add(bIdx);
        res.add(cIdx);

        while (true) {
            Collections.sort(res, new Comparator<CharIdx>() {
                @Override
                public int compare(CharIdx o1, CharIdx o2) {
                    if (o1.num == o2.num) {
                        return o1.ch - o2.ch;
                    }

                    return o2.num - o1.num;
                }
            });

            if (res.get(0).num == 0) {
                break;
            }

            if (res.get(0).num >= 2) {
                sb.append(res.get(0).ch).append(res.get(0).ch);
                res.get(0).num -= 2;
            } else {
                sb.append(res.get(0).ch);
                res.get(0).num -= 1;
            }

            if (res.get(1).num == 0 && res.get(2).num == 0) {
                break;
            }

            if (res.get(0).num > res.get(1).num && res.get(1).num >= 2) {
                sb.append(res.get(1).ch);
                res.get(1).num -= 1;
            } else if (res.get(1).num >= 2) {
                sb.append(res.get(1).ch).append(res.get(1).ch);
                res.get(1).num -= 2;
            } else {
                sb.append(res.get(1).ch);
                res.get(1).num -= 1;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("aabaa ?= " + longestDiverseString(7, 1, 0));
        System.out.println("aabbc ?= " + longestDiverseString(2, 2, 1));
        System.out.println("ccaccbcc ?= " + longestDiverseString(1, 1, 7));
        System.out.println("ccbbccabc ?= " + longestDiverseString(1, 3, 5));
        System.out.println("ccbbccbbccbbccbccbc ?= " + longestDiverseString(0, 8, 11));
        System.out.println("bbcbbcbbcbbabbcbbabbcbbabbcbbabbcbb ?= " + longestDiverseString(4, 42, 7));
    }
}

