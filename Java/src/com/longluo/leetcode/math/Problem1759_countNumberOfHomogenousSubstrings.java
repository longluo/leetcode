package com.longluo.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 1759. 统计同构子字符串的数目
 * <p>
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * <p>
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 示例 1：
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * <p>
 * 示例 2：
 * 输入：s = "xy"
 * 输出：2
 * 解释：同构子字符串是 "x" 和 "y" 。
 * <p>
 * 示例 3：
 * 输入：s = "zzzzz"
 * 输出：15
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写字符串组成
 * <p>
 * https://leetcode.cn/problems/count-number-of-homogenous-substrings/
 */
public class Problem1759_countNumberOfHomogenousSubstrings {

    // BF time: O(n^4) space: O(n)
    // TLE
    public static int countHomogenous_bf(String s) {
        int len = s.length();

        int mod = 1_000_000_007;

        int ans = 0;

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < len; i++) {
            StringBuilder subStr = new StringBuilder();
            for (int j = i; j < len; j++) {
                subStr.append(s.charAt(j));

                if (!checkHomogenous(subStr.toString())) {
                    break;
                }

                if (seen.contains(subStr.toString())) {
                    continue;
                }

                seen.add(subStr.toString());

                int cnt = 1;

                for (int k = i + 1; k < len && k + subStr.length() <= len; k++) {
                    if (s.substring(k, k + subStr.length()).equals(subStr.toString())) {
                        cnt++;
                    }
                }

                ans += cnt;
                ans = ans % mod;
            }
        }

        return ans;
    }

    private static boolean checkHomogenous(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
            if (set.size() > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countHomogenous_bf("xy"));
        System.out.println("15 ?= " + countHomogenous_bf("zzzzz"));
        System.out.println("13 ?= " + countHomogenous_bf("abbcccaa"));
    }
}
