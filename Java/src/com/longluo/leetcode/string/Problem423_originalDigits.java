package com.longluo.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 423. 从英文中重建数字
 * <p>
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * <p>
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 * <p>
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i]为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一
 * s 保证是一个符合题目要求的字符串
 * <p>
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 */
public class Problem423_originalDigits {

    // time: O(n) space: O(n)
    public static String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = map.getOrDefault('z', 0);
        cnt[2] = map.getOrDefault('w', 0);
        cnt[4] = map.getOrDefault('u', 0);
        cnt[6] = map.getOrDefault('x', 0);
        cnt[8] = map.getOrDefault('g', 0);

        cnt[3] = map.getOrDefault('h', 0) - cnt[8];
        cnt[5] = map.getOrDefault('f', 0) - cnt[4];
        cnt[7] = map.getOrDefault('s', 0) - cnt[6];

        cnt[1] = map.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = map.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("012 ?= " + originalDigits("owoztneoer"));
        System.out.println("45 ?= " + originalDigits("fviefuro"));
    }
}
