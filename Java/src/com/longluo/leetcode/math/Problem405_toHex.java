package com.longluo.leetcode.math;

/**
 * 405. 数字转换为十六进制数
 * <p>
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，
 * 十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 示例 1：
 * 输入:
 * 26
 * 输出:
 * "1a"
 * <p>
 * 示例 2：
 * 输入:
 * -1
 * 输出:
 * "ffffffff"
 * <p>
 * https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 */
public class Problem405_toHex {

    public static String toHex(int _num) {
        if (_num == 0) {
            return "0";
        }

        long num = _num;
        if (num < 0) {
            num = (long) (Math.pow(2, 32) + num);
        }

        StringBuilder sb = new StringBuilder();
        char[] array = {'a', 'b', 'c', 'd', 'e', 'f'};

        while (num > 0) {
            long mod = num % 16;
            if (mod < 10) {
                sb.append(mod);
            } else {
                sb.append(array[(int) (mod - 10)]);
            }
            num = num / 16;
        }

        String res = sb.reverse().toString();
        return res;
    }

    public static void main(String[] args) {
        System.out.println("0 ?=" + toHex(0));
        System.out.println("1 ?=" + toHex(1));
        System.out.println("2 ?=" + toHex(2));
        System.out.println("9 ?=" + toHex(9));
        System.out.println("a ?=" + toHex(10));
        System.out.println("f ?=" + toHex(15));
        System.out.println("10 ?=" + toHex(16));
        System.out.println("ffffffff ?=" + toHex(-1));
        System.out.println("1a ?=" + toHex(26));
    }
}
