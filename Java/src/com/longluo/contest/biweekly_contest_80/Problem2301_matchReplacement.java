package com.longluo.contest.biweekly_contest_80;

/**
 * 2301. 替换字符后匹配
 *
 * 给你两个字符串 s 和 sub 。同时给你一个二维字符数组 mappings ，其中 mappings[i] = [oldi, newi] 表示你可以替换 sub 中任意数目的 oldi 个字符，替换成 newi 。sub 中每个字符 不能 被替换超过一次。
 *
 * 如果使用 mappings 替换 0 个或者若干个字符，可以将 sub 变成 s 的一个子字符串，请你返回 true，否则返回 false 。
 *
 * 一个 子字符串 是字符串中连续非空的字符序列。
 *
 * 示例 1：
 * 输入：s = "fool3e7bar", sub = "leet", mappings = [["e","3"],["t","7"],["t","8"]]
 * 输出：true
 * 解释：将 sub 中第一个 'e' 用 '3' 替换，将 't' 用 '7' 替换。
 * 现在 sub = "l3e7" ，它是 s 的子字符串，所以我们返回 true 。
 *
 * 示例 2：
 * 输入：s = "fooleetbar", sub = "f00l", mappings = [["o","0"]]
 * 输出：false
 * 解释：字符串 "f00l" 不是 s 的子串且没有可以进行的修改。
 * 注意我们不能用 'o' 替换 '0' 。
 *
 * 示例 3：
 * 输入：s = "Fool33tbaR", sub = "leetd", mappings = [["e","3"],["t","7"],["t","8"],["d","b"],["p","b"]]
 * 输出：true
 * 解释：将 sub 里第一个和第二个 'e' 用 '3' 替换，用 'b' 替换 sub 里的 'd' 。
 * 得到 sub = "l33tb" ，它是 s 的子字符串，所以我们返回 true 。
 *
 * 提示：
 * 1 <= sub.length <= s.length <= 5000
 * 0 <= mappings.length <= 1000
 * mappings[i].length == 2
 * oldi != newi
 * s 和 sub 只包含大写和小写英文字母和数字。
 * oldi 和 newi 是大写、小写字母或者是个数字。
 * 
 * https://leetcode.cn/problems/match-substring-after-replacement/
 */
public class Problem2301_matchReplacement {

    // TODO: 2022/6/13
    public static boolean matchReplacement(String s, String sub, char[][] mappings) {

        return false;
    }

    public static void main(String[] args) {

    }
}
