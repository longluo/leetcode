package com.longluo.leetcode.BitManipulation;

import java.util.*;

/**
 * 1239. 串联字符串的最大长度
 * <p>
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，
 * 那么它就是一个可行解。
 * <p>
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
 * https://leetcode.cn/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class Problem1239_maximumLengthOfAConcatenatedStringWithUniqueCharacters {

    // BF time: O(L) space: O(C)
    // TLE
    public static int maxLength_bf(List<String> arr) {
        int len = arr.size();

        boolean[] marked = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (check(arr.get(i))) {
                marked[i] = true;
            }
        }

        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), arr, marked, 0);

        int ans = 0;
        for (String s : res) {
            ans = Math.max(ans, s.length());
        }

        return ans;
    }

    private static void backtrack(List<String> res, StringBuilder path, List<String> arr, boolean[] marked, int start) {
        if (start == arr.size()) {
            if (check(path.toString())) {
                res.add(new String(path));
            }
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            if (marked[i]) {
                path.append(arr.get(i));
                backtrack(res, path, arr, marked, i + 1);
                path.delete(path.length() - arr.get(i).length(), path.length());

                backtrack(res, path, arr, marked, i + 1);
            }
        }
    }

    private static boolean check(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
            if (cnt[ch - 'a'] > 1) {
                return false;
            }
        }

        return true;
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

    public static int maxLength_bt(List<String> arr) {
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
        List<String> tst6 = new ArrayList<>();
        tst6.add("jnfbyktlrqumowxd");
        tst6.add("mvhgcpxnjzrdei");
        System.out.println("16 ?= " + maxLength_bf(tst6));

        List<String> tst1 = new ArrayList<>();
        tst1.add("un");
        tst1.add("iq");
        tst1.add("ue");
        System.out.println("4 ?= " + maxLength_bf(tst1));
        System.out.println("4 ?= " + maxLength_2(tst1));
        System.out.println("4 ?= " + maxLength_bt(tst1));

        List<String> tst2 = new ArrayList<>();
        tst2.add("cha");
        tst2.add("r");
        tst2.add("act");
        tst2.add("ers");
        System.out.println("6 ?= " + maxLength_bf(tst2));
        System.out.println("6 ?= " + maxLength_2(tst2));
        System.out.println("6 ?= " + maxLength_bt(tst2));

        List<String> tst3 = new ArrayList<>();
        tst3.add("abcdefghijklmnopqrstuvwxyz");
        System.out.println("26 ?= " + maxLength_bf(tst3));
        System.out.println("26 ?= " + maxLength_2(tst3));
        System.out.println("26 ?= " + maxLength_bt(tst3));

        List<String> tst4 = new ArrayList<>();
        tst4.add("yy");
        tst4.add("bkhwmpbiisbldzknpm");
        System.out.println("0 ?= " + maxLength_bf(tst4));
        System.out.println("0 ?= " + maxLength_2(tst4));
        System.out.println("0 ?= " + maxLength_bt(tst4));

        List<String> tst5 = new ArrayList<>();
        tst4.add("aa");
        tst4.add("bb");
        System.out.println("0 ?= " + maxLength_bf(tst5));
        System.out.println("0 ?= " + maxLength_2(tst5));
        System.out.println("0 ?= " + maxLength_bt(tst5));
    }
}
