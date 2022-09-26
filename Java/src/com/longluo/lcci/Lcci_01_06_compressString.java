package com.longluo.lcci;

/**
 * 面试题 01.06. 字符串压缩
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
 * 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 */
public class Lcci_01_06_compressString {

    public static String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }

        int len = S.length();
        StringBuilder sb = new StringBuilder(len);
        int idx = 0;
        while (idx < len) {
            char ch = S.charAt(idx);
            int count = 0;
            while (idx < len && S.charAt(idx) == ch) {
                count++;
                idx++;
            }
            sb.append(ch).append(count);
        }

        if (sb.length() < len) {
            return sb.toString();
        }

        return S;
    }

    public static void main(String[] args) {
        System.out.println("a2b1c5a3 ?= " + compressString("aabcccccaaa"));
        System.out.println("abbccd ?= " + compressString("abbccd"));
    }
}
