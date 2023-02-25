package com.longluo.leetcode.greedy;

/**
 * 1247. 交换字符使得字符串相同
 * <p>
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 * <p>
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 * <p>
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，
 * 但不能交换 s1[i] 和 s1[j]。
 * <p>
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：s1 = "xx", s2 = "yy"
 * 输出：1
 * 解释：
 * 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。
 * <p>
 * 示例 2：
 * 输入：s1 = "xy", s2 = "yx"
 * 输出：2
 * 解释：
 * 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 * 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 * 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。
 * <p>
 * 示例 3：
 * 输入：s1 = "xx", s2 = "xy"
 * 输出：-1
 * <p>
 * 示例 4：
 * 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
 * 输出：4
 * <p>
 * 提示：
 * 1 <= s1.length, s2.length <= 1000
 * s1, s2 只包含 'x' 或 'y'。
 * <p>
 * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 */
public class Problem1247_minimumSwapsToMakeStringsEqual {

    // TODO: 2023/2/25  
    public static int minimumSwap_bf(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return -1;
        }

        int xCnt = 0;
        int yCnt = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 == ch2) {
                continue;
            }

            if (ch1 == 'x') {
                xCnt++;
            } else {
                yCnt++;
            }
        }

        int diff = xCnt + yCnt;
        if (diff % 2 != 0) {
            return -1;
        } else {
            return diff / 2 + xCnt % 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumSwap_bf("xx", "yy"));
        System.out.println("2 ?= " + minimumSwap_bf("xy", "yx"));
        System.out.println("-1 ?= " + minimumSwap_bf("xx", "xy"));

        System.out.println("4 ?= " + minimumSwap_bf("xxyyxyxyxx", "xyyxyxxxyx"));
        //    xxyyxyxyxx
        //    xyyxyxxxyx
        // --> xyxyyx
        // --> yxyxxy
        System.out.println("4 ?= " + minimumSwap_bf("yxyxxxyyxxyxxxx", "yyyxyyyxyxxxyxy"));
        //       x  xx yx y x x
        //      yyyxyyyxyxxxyxy
        // -->   xxxyxyxx
    }
}
