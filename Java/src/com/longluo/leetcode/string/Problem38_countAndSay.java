package com.longluo.leetcode.string;

/**
 * 38. 外观数列
 * <p>
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
 * 然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，
 * 先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 * <p>
 * 例如，数字字符串 "3322251" 的描述如下图：
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * <p>
 * 示例 2：
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 * <p>
 * 提示：
 * 1 <= n <= 30
 * <p>
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class Problem38_countAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String str = countAndSay(n - 1);
        char[] arr = str.toCharArray();
        int count = 0;
        int idx = 0;
        char ch = arr[0];
        while (idx < arr.length) {
            while (idx < arr.length && arr[idx] == ch) {
                idx++;
                count++;
            }
            sb.append(count).append(ch);
            if (idx >= arr.length) {
                break;
            }
            ch = arr[idx];
            count = 0;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + countAndSay(1));
        System.out.println("11 ?= " + countAndSay(2));
        System.out.println("21 ?= " + countAndSay(3));
        System.out.println("1211 ?= " + countAndSay(4));
        System.out.println("111221 ?= " + countAndSay(5));
        System.out.println("312211 ?= " + countAndSay(6));
        for (int i = 1; i <= 30; i++) {
            System.out.print(countAndSay(i) + ",");
        }
    }
}
