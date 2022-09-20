package com.longluo.contest.biweekly_contest_87;

public class Problem1 {

    //
    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArriveMonth = Integer.parseInt(arriveAlice.substring(0, 2));
        int aliceArriveDay = Integer.parseInt(arriveAlice.substring(3, 5));

        int aliceLeaveMonth = Integer.parseInt(leaveAlice.substring(0, 2));
        int aliceLeaveDay = Integer.parseInt(leaveAlice.substring(3, 5));

        int bobArriveMonth = Integer.parseInt(arriveBob.substring(0, 2));
        int bobArriveDay = Integer.parseInt(arriveBob.substring(3, 5));

        int bobLeaveMonth = Integer.parseInt(leaveBob.substring(0, 2));
        int bobLeaveDay = Integer.parseInt(leaveBob.substring(3, 5));

        int aliceArriveDate = 0;
        int aliceLeaveDate = 0;

        int bobArriveDate = 0;
        int bobLeaveDate = 0;

        for (int i = 1; i < aliceArriveMonth; i++) {
            aliceArriveDate += days[i - 1];
        }

        aliceArriveDate += aliceArriveDay;

        for (int i = 1; i < aliceLeaveMonth; i++) {
            aliceLeaveDate += days[i - 1];
        }

        aliceLeaveDate += aliceLeaveDay;

        for (int i = 1; i < bobArriveMonth; i++) {
            bobArriveDate += days[i - 1];
        }

        bobArriveDate += bobArriveDay;

        for (int i = 1; i < bobLeaveMonth; i++) {
            bobLeaveDate += days[i - 1];
        }
        bobLeaveDate += bobLeaveDay;

        if (aliceLeaveDate < bobArriveDate || bobLeaveDate < aliceArriveDate) {
            return 0;
        }

        if (aliceArriveDate <= bobArriveDate && aliceLeaveDate >= bobLeaveDate) {
            return bobLeaveDate - bobArriveDate + 1;
        }

        if (bobArriveDate <= aliceArriveDate && bobLeaveDate >= aliceLeaveDate) {
            return aliceLeaveDate - aliceArriveDate + 1;
        }

        if (aliceArriveDate < bobArriveDate) {
            return Math.min(aliceLeaveDate, bobLeaveDate) - bobArriveDate + 1;
        } else {
            return Math.min(bobLeaveDate, aliceLeaveDate) - aliceArriveDate + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countDaysTogether("08-15", "08-18", "08-16", "08-19"));
    }
}
