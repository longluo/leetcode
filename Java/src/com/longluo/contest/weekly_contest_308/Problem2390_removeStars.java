package com.longluo.contest.weekly_contest_308;

/**
 * 2390. 从字符串中移除星号
 * <p>
 * 给你一个包含若干星号 * 的字符串 s 。
 * <p>
 * 在一步操作中，你可以：
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 * <p>
 * 注意：
 * 生成的输入保证总是可以执行题面中描述的操作。
 * 可以证明结果字符串是唯一的。
 * <p>
 * 示例 1：
 * 输入：s = "leet**cod*e"
 * 输出："lecoe"
 * 解释：从左到右执行移除操作：
 * - 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
 * - 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
 * - 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
 * 不存在其他星号，返回 "lecoe" 。
 * <p>
 * 示例 2：
 * 输入：s = "erase*****"
 * 输出：""
 * 解释：整个字符串都会被移除，所以返回空字符串。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母和星号 * 组成
 * s 可以执行上述操作
 * <p>
 * https://leetcode.cn/problems/removing-stars-from-a-string/
 */
public class Problem2390_removeStars {

    // StringBuilder time: O(n) space: O(n)
    public static String removeStars(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(len);
        int idx = 0;
        while (idx < len) {
            char ch = s.charAt(idx);
            if (ch != '*') {
                sb.append(ch);
                idx++;
            } else {
                while (idx < len && sb.length() > 0 && s.charAt(idx) == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    idx++;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("lecoe ?= " + removeStars("leet**cod*e"));
        System.out.println(" ?= " + removeStars("erase*****"));
        System.out.println("a ?= " + removeStars("abb*cdfg*****x*"));
    }
}
