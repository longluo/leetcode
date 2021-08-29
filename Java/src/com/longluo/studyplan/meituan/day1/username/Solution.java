package com.longluo.studyplan.meituan.day1.username;

import java.util.Scanner;

/**
 * meituan-001. 小美的用户名
 * <p>
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，
 * 一个合法的用户名必须满足以下几个要求：
 * <p>
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
 * - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * 输出：
 * - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
 * <p>
 * 示例：
 * 输入：
 * 5
 * Ooook
 * Hhhh666
 * ABCD
 * Meituan
 * 6666
 * 输出：
 * Wrong
 * Accept
 * Wrong
 * Wrong
 * Wrong
 * <p>
 * 提示：
 * 1 <= T <= 100
 * <p>
 * https://leetcode-cn.com/problems/BaR9fy/
 */
public class Solution {

    private static final String regex = "^([a-zA-Z])([a-zA-Z0-9]*)([0-9]+)([a-zA-Z0-9]*)$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] namesArray = new String[n];
        for (int i = 0; i < n; i++) {
            namesArray[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(checkNameValid(namesArray[i]));
        }
    }

    public static String checkNameValid(String name) {
        if (name == null || name.length() <= 1) {
            return "Wrong";
        }

        int n = name.length();
        for (int i = 0; i < n; i++) {
            if (!Character.isLetter(name.charAt(0)) || name.length() <= 1) {
                return "Wrong";
            }

            int letterNum = 0;
            int digitNum = 0;
            for (Character ch : name.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digitNum++;
                } else if (Character.isLetter(ch)) {
                    letterNum++;
                } else {
                    return "Wrong";
                }
            }
            if (letterNum > 0 && digitNum > 0) {
                return "Accept";
            } else {
                return "Wrong";
            }
        }

        return "Wrong";
    }
}
