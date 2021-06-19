package com.longluo.leetcode.bitmanipulation;

import java.util.*;

/**
 * 1239. 串联字符串的最大长度
 * <p>
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，
 * 那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * 示例 1：
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * <p>
 * 示例 2：
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * <p>
 * 示例 3：
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * <p>
 * 提示：
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 * <p>
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class Problem1239_maximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        int n = arr.size();
        int[] freq = new int[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(freq, 0);
            String str = arr.get(i);
            for (Character ch : str.toCharArray()) {
                if (freq[ch - 'a'] > 0) {
                    Arrays.fill(freq, 0);
                    break;
                } else {
                    freq[ch - 'a']++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                for (Character ch : arr.get(j).toCharArray()) {
                    if (freq[ch - 'a'] > 0) {
                        break;
                    } else {
                        freq[ch - 'a']++;
                    }
                }


            }

            ans = Math.max(ans, Arrays.stream(freq).sum());
        }

        return ans;
    }

    public static int maxLength_2(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            for (int i = 0; i < n; ++i) {
                int m = masks.get(i);
                if ((m & mask) == 0) { // m 和 mask 无公共元素
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }

        return ans;
    }

    public static int ans = 0;

    public static int maxLength_3(List<String> arr) {
        ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public static void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args) {
        List<String> tst1 = new ArrayList<>();
        tst1.add("un");
        tst1.add("iq");
        tst1.add("ue");
        System.out.println("4 ?= " + maxLength(tst1));
        System.out.println("4 ?= " + maxLength_2(tst1));
        System.out.println("4 ?= " + maxLength_3(tst1));

        List<String> tst2 = new ArrayList<>();
        tst2.add("cha");
        tst2.add("r");
        tst2.add("act");
        tst2.add("ers");
        System.out.println("6 ?= " + maxLength(tst2));
        System.out.println("6 ?= " + maxLength_2(tst2));
        System.out.println("6 ?= " + maxLength_3(tst2));

        List<String> tst3 = new ArrayList<>();
        tst3.add("abcdefghijklmnopqrstuvwxyz");
        System.out.println("26 ?= " + maxLength(tst3));
        System.out.println("26 ?= " + maxLength_2(tst3));
        System.out.println("26 ?= " + maxLength_3(tst3));

        List<String> tst4 = new ArrayList<>();
        tst4.add("yy");
        tst4.add("bkhwmpbiisbldzknpm");
        System.out.println("0 ?= " + maxLength(tst4));
        System.out.println("0 ?= " + maxLength_2(tst4));
        System.out.println("0 ?= " + maxLength_3(tst4));
    }
}
