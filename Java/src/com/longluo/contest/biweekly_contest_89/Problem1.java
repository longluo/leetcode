package com.longluo.contest.biweekly_contest_89;

public class Problem1 {

    public static int countTime(String time) {
        String hour = time.substring(0, 2);
        String minute = time.substring(3);

        int cnt = 1;

        if (hour.charAt(0) == '?' && (hour.charAt(1) >= '0' && hour.charAt(1) <= '3')) {
            cnt *= 3;
        } else if (hour.charAt(0) == '?' && hour.charAt(1) != '?') {
            cnt *= 2;
        } else if (hour.charAt(0) == '?' && hour.charAt(1) == '?') {
            cnt *= 24;
        } else if ((hour.charAt(0) == '0' || hour.charAt(0) == '1') && hour.charAt(1) == '?') {
            cnt *= 10;
        } else if (hour.charAt(0) == '2' && hour.charAt(1) == '?') {
            cnt *= 4;
        }

        if (minute.charAt(0) == '?' && minute.charAt(1) == '?') {
            cnt *= 60;
        } else if (minute.charAt(0) == '?' && minute.charAt(1) == '0') {
            cnt *= 6;
        } else if (minute.charAt(0) == '?' && minute.charAt(1) != '?') {
            cnt *= 6;
        } else if ((minute.charAt(0) >= '0' && minute.charAt(0) <= '5') && minute.charAt(1) == '?') {
            cnt *= 10;
        }

        return cnt;
    }

    public static int countTime_opt(String time) {
        char[] array = time.toCharArray();

        int ans = 1;

        if (array[0] == '?') {
            if (array[1] >= '0' && array[1] <= '3') {
                ans *= 3;
            } else if (array[1] == '?') {
                ans *= 24;
            } else {
                ans *= 2;
            }
        } else if (array[0] == '0' || array[0] == '1') {
            if (array[1] == '?') {
                ans *= 10;
            }
        } else if (array[0] == '2') {
            if (array[1] == '?') {
                ans *= 4;
            }
        }

        if (array[3] == '?') {
            if (array[4] == '?') {
                ans *= 60;
            } else {
                ans *= 6;
            }
        } else if (array[3] >= '0' && array[3] <= '5') {
            if (array[4] == '?') {
                ans *= 10;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countTime("?5:00"));
        System.out.println("1 ?= " + countTime("21:09"));
        System.out.println("12 ?= " + countTime("?9:?0"));

        System.out.println("2 ?= " + countTime_opt("?5:00"));
        System.out.println("1 ?= " + countTime_opt("21:09"));
        System.out.println("12 ?= " + countTime_opt("?9:?0"));
    }
}
