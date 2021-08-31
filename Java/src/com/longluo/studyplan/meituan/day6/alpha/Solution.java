package com.longluo.studyplan.meituan.day6.alpha;

import java.util.Scanner;

/**
 * meituan-013. 偏爱字母
 * <p>
 * 小美喜欢字母 E ，讨厌字母 F 。在小美生日时，小团送了小美一个仅包含字母 E 和 F 的字符串，
 * 小美想从中选出一个包含字母 E 数量与字母 F 数量之差最大的子串。
 * *子串：从字符串前面连续删去若干个字符，从后面连续删去若干个字符剩下的字符串（也可以一个都不删），
 * 例如 abcab 是 fabcab 的子串，而不是 abcad 的子串。我们将空串看作所有字符串的子串。
 * <p>
 * 格式：
 * 输入：
 * - 第一行一个正整数 n 表示字符串的长度。
 * - 第二行长度为 n ，且仅包含大写字母 'E', 'F' 的字符串（不含引号）
 * 输出：
 * - 输出一个整数，表示最大的差值。
 * <p>
 * 示例：
 * 输入：
 * 5
 * EFEEF
 * 输出：2
 * 解释：
 * 选择子串 EE ，此时有 2 个 E ，0 个 F ，有最大差值 2-0=2
 * 另外，选择子串 EFEE 也可以达到最大差值。
 * <p>
 * 提示：
 * 对于 30% 的数据，n <= 300
 * 对于 60% 的数据，n <= 3000
 * 对于 100% 的数据，n <= 300000
 * <p>
 * https://leetcode-cn.com/problems/pedXtA/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        char[] arr = str.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, getDiff(arr, i, j));
            }
        }

        System.out.println(ans);
    }

    public static int getDiff(char[] arr, int start, int end) {
        int cntE = 0;
        int cntF = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == 'E') {
                cntE++;
            } else {
                cntF++;
            }
        }

        return cntE - cntF;
    }
}
