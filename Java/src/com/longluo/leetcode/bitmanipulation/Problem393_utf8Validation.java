package com.longluo.leetcode.bitmanipulation;

/**
 * 393. UTF-8 编码验证
 * <p>
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 * <p>
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第n+1位设为0，后面字节的前两位一律设为10。
 * 剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 * <p>
 * Char. number range  |        UTF-8 octet sequence
 * (hexadecimal)    |              (binary)
 * --------------------+---------------------------------------------
 * 0000 0000-0000 007F | 0xxxxxxx
 * 0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 * 0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 * 0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 * <p>
 * 示例 1：
 * 输入：data = [197,130,1]
 * 输出：true
 * 解释：数据表示字节序列:11000101 10000010 00000001。
 * 这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
 * <p>
 * 示例 2：
 * 输入：data = [235,140,4]
 * 输出：false
 * 解释：数据表示 8 位的序列: 11101011 10001100 00000100.
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 * <p>
 * 提示:
 * 1 <= data.length <= 2 * 10^4
 * 0 <= data[i] <= 255
 * <p>
 * https://leetcode.cn/problems/utf-8-validation/
 */
public class Problem393_utf8Validation {

    // Simulate time: O(n) space: O(n)
    // AC
    public static boolean validUtf8(int[] data) {
        if (data == null || data.length <= 0) {
            return false;
        }

        int len = data.length;
        int idx = 0;
        while (idx < len) {
            int byteNum = data[idx] < 128 ? 1 : getByte(Integer.toBinaryString(data[idx]));
            if (byteNum > 0) {
                if (!check(data, idx, byteNum)) {
                    return false;
                }
            } else {
                return false;
            }

            idx += byteNum;
        }

        return true;
    }

    private static int getByte(String s) {
        int idx = 0;
        while (idx < 6 && s.charAt(idx) == '1') {
            idx++;
        }

        return idx <= 4 ? idx : -1;
    }

    private static boolean check(int[] data, int start, int len) {
        if (len == 1) {
            return data[start] < 128;
        }

        if (start + len > data.length) {
            return false;
        }

        for (int i = start + 1; i < start + len; i++) {
            if (data[i] < 128 || data[i] > 191) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(128));
        System.out.println(Integer.toBinaryString(191));
        System.out.println(Integer.toBinaryString(255));
        System.out.println(Integer.toBinaryString(197));
        System.out.println(Integer.toBinaryString(130));
        System.out.println(Integer.toBinaryString(235));

        System.out.println("false ?= " + validUtf8(new int[]{237}));
        System.out.println("true ?= " + validUtf8(new int[]{197, 130, 1}));
        System.out.println("false ?= " + validUtf8(new int[]{235, 140, 4}));
        System.out.println("true ?= " + validUtf8(new int[]{230, 136, 145}));
    }
}
