package com.longluo.leetcode.string;

/**
 * 2315. 统计星号
 * <p>
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 * <p>
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 * <p>
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 * <p>
 * 示例 1：
 * 输入：s = "l|*e*et|c**o|*de|"
 * 输出：2
 * 解释：不在竖线对之间的字符加粗加斜体后，得到字符串："l|*e*et|c**o|*de|" 。
 * 第一和第二条竖线 '|' 之间的字符不计入答案。
 * 同时，第三条和第四条竖线 '|' 之间的字符也不计入答案。
 * 不在竖线对之间总共有 2 个星号，所以我们返回 2 。
 * <p>
 * 示例 2：
 * 输入：s = "iamprogrammer"
 * 输出：0
 * 解释：在这个例子中，s 中没有星号。所以返回 0 。
 * <p>
 * 示例 3：
 * 输入：s = "yo|uar|e**|b|e***au|tifu|l"
 * 输出：5
 * 解释：需要考虑的字符加粗加斜体后："yo|uar|e**|b|e***au|tifu|l" 。不在竖线对之间总共有 5 个星号。所以我们返回 5 。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母，竖线 '|' 和星号 '*' 。
 * s 包含 偶数 个竖线 '|' 。
 * <p>
 * https://leetcode.cn/problems/count-asterisks/
 */
public class Problem2315_countAsterisks {

    // Simulate time: O(n) space: O(1)
    public static int countAsterisks(String s) {
        int len = s.length();

        int ans = 0;

        boolean isInPair = false;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '|') {
                isInPair = !isInPair;
            } else if (ch == '*') {
                ans += isInPair ? 0 : 1;
            }
        }

        return ans;
    }

    // Simulate Opt time: O(n) space: O(1)
    public static int countAsterisks_opt(String s) {
        int ans = 0;

        boolean isInPair = false;

        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                isInPair = !isInPair;
            } else if (ch == '*') {
                ans += isInPair ? 0 : 1;
            }
        }

        return ans;
    }

    // Simulate time: O(n) space: O(1)
    public static int countAsterisks_simu(String s) {
        int ans = 0;

        boolean countFlag = true;

        for (char ch : s.toCharArray()) {
            if (ch == '|') {
                countFlag = !countFlag;
            } else if (ch == '*') {
                if (countFlag) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println("5 ?= " + countAsterisks("yo|uar|e**|b|e***au|tifu|l"));

        System.out.println("5 ?= " + countAsterisks_opt("yo|uar|e**|b|e***au|tifu|l"));

        System.out.println("5 ?= " + countAsterisks_simu("yo|uar|e**|b|e***au|tifu|l"));
    }
}
