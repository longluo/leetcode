package com.longluo.contest.weekly_contest_306;

/**
 * 2375. 根据模式串构造最小数字
 * <p>
 * 给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
 * <p>
 * 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
 * <p>
 * num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
 * 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
 * 如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
 * 请你返回满足上述条件字典序 最小 的字符串 num。
 * <p>
 * 示例 1：
 * 输入：pattern = "IIIDIDDD"
 * 输出："123549876"
 * 解释：
 * 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
 * 下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
 * 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
 * "123549876" 是满足条件最小的数字。
 * 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
 * <p>
 * 示例 2：
 * 输入：pattern = "DDD"
 * 输出："4321"
 * 解释：
 * 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
 * "4321" 是满足条件最小的数字。
 * <p>
 * 提示：
 * 1 <= pattern.length <= 8
 * pattern 只包含字符 'I' 和 'D' 。
 * <p>
 * https://leetcode.cn/problems/construct-smallest-number-from-di-string/
 */
public class Problem2375_smallestNumber {

    static String ans = "";

    public static String smallestNumber(String pattern) {
        ans = "";
        int len = pattern.length();
        char[] pat = pattern.toCharArray();
        boolean[] used = new boolean[10];
        backtrack(new StringBuilder(), pat, used, 0, len + 1);
        return ans;
    }

    private static void backtrack(StringBuilder path, char[] pat, boolean[] used, int index, int len) {
        if (index == len) {
            if (ans.length() == 0) {
                ans = path.toString();
            } else {
                ans = ans.compareTo(path.toString()) <= 0 ? ans : path.toString();
            }

            return;
        }

        for (int j = 1; j <= 9; j++) {
            if (used[j]) {
                continue;
            }

            if (path.length() == index) {
                if (pat[index] == 'I' && path.charAt(index + 1) <= path.charAt(index)) {
                    return;
                }

                if (pat[index] == 'D' && path.charAt(index + 1) >= path.charAt(index)) {
                    return;
                }
            }

            path.append(j);
            used[j] = true;
            backtrack(path, pat, used, index + 1, len);
            path.deleteCharAt(path.length() - 1);
            used[j] = false;
        }
    }

    public static void main(String[] args) {
//        System.out.println("21 ?= " + smallestNumber("D"));
//        System.out.println("12 ?= " + smallestNumber("I"));
        System.out.println("321 ?= " + smallestNumber("DD"));
        System.out.println("4321 ?= " + smallestNumber("DDD"));
        System.out.println("123549876 ?= " + smallestNumber("IIIDIDDD"));
    }
}
