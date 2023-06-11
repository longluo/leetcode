package com.longluo.contest.weekly_contest_349;

/**
 * https://leetcode.cn/contest/weekly-contest-349
 */
public class Problem2 {

    public static String smallestString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        boolean flag = true;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!flag) {
                sb.append(ch);
                continue;
            }

            if (ch == 'a') {
                sb.append(ch);
                continue;
            }

            int j = i;
            while (j < n && s.charAt(j) > 'a' && flag) {
                sb.append((char) (s.charAt(j) - 1));
                j++;
            }

            i = j - 1;
            flag = false;
        }

        if (flag) {
            char ch = sb.charAt(n - 1);
            sb.deleteCharAt(n - 1);

            if (ch == 'a') {
                sb.append('z');
            } else {
                sb.append((char) (ch - 1));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("z ?= " + smallestString("a"));
        System.out.println("az ?= " + smallestString("aa"));
        System.out.println("baabc ?= " + smallestString("cbabc"));
        System.out.println("abaab ?= " + smallestString("acbbc"));
        System.out.println("kddsbncd ?= " + smallestString("leetcode"));
    }
}
