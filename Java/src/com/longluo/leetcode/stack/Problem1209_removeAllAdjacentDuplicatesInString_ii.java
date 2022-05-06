package com.longluo.leetcode.stack;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 * <p>
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，
 * 使被删去的字符串的左侧和右侧连在一起。
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * 本题答案保证唯一。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * <p>
 * 示例 2：
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * <p>
 * 示例 3：
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 * <p>
 * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class Problem1209_removeAllAdjacentDuplicatesInString_ii {

    // BF
    public static String removeDuplicates_bf(String s, int k) {
        int len = s.length();
        if (len < k) {
            return s;
        }

        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if ((sb.length() > 0 && ch == sb.charAt(sb.length() - 1)) && cnt[ch - 'a'] >= k) {
                int start = i;
                boolean flag = false;
                StringBuilder temp = new StringBuilder(ch);
                while (start < len && s.charAt(start) == ch) {
                    temp.append(s.charAt(start));
                    start++;
                    if (temp.length() == k - 1) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    cnt[ch - 'a'] -= k;
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(temp);
                }

                i = start - 1;
            } else {
                sb.append(ch);
            }
        }

        return  check(sb.toString(), k) ?  removeDuplicates_bf(sb.toString(), k) : sb.toString();
    }

    public static boolean check(String s, int k) {
        int len = s.length();
        if (len < k) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i - 1)) {
                int j = i;
                k--;
                while (j < len && k > 0 && s.charAt(j) == ch) {
                    k--;
                    j++;
                }

                if (k == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("abcd ?= " + removeDuplicates_bf("abcd", 2));
        System.out.println("aa ?= " + removeDuplicates_bf("deeedbbcccbdaa", 3));
    }
}
