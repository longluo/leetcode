package com.longluo.contest.weekly_contest_292;

public class Problem1 {

    public static String largestGoodInteger(String num) {
        int len = num.length();
        int cnt = 1;
        int max = -1;
        for (int i = 1; i < len; i++) {
            char ch = num.charAt(i);
            if (ch != num.charAt(i - 1)) {
                cnt = 1;
            } else {
                cnt++;
                if (cnt == 3) {
                    max = Math.max(max, ch - '0');
                    cnt = 0;
                }
            }
        }

        return max > -1 ? "" + max + max + max : "";
    }


    public static String largestGoodInteger_fast(String num) {
        for (int i = 9; i >= 0; i--) {
            String str = String.valueOf(i).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("000"));
        System.out.println(largestGoodInteger("42352338"));
        System.out.println(largestGoodInteger("6777133339"));
    }
}
