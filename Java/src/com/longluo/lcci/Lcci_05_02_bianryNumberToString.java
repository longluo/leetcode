package com.longluo.lcci;

/**
 * 面试题 05.02. 二进制数转字符串
 * <p>
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 示例2:
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 提示：
 * 32位包括输出中的 "0." 这两位。
 * 题目保证输入用例的小数位数最多只有 6 位
 * <p>
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 */
public class Lcci_05_02_bianryNumberToString {

    // Simulate time: O(n) space: O(n)
    public static String printBin(double num) {
        StringBuilder ans = new StringBuilder();

        ans.append("0.");

        int cnt = 32;
        num *= 2;

        while (num > 0 && cnt > 0) {
            if (num >= 1) {
                ans.append(1);
                num -= 1;
            } else {
                ans.append(0);
            }

            cnt--;
            num *= 2;
        }

        if (num > 0) {
            return "ERROR";
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println("0.101 ?= " + printBin(0.625));
        System.out.println("ERROR ?= " + printBin(0.1));
    }
}
