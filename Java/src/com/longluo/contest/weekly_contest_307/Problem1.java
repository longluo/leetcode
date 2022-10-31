package com.longluo.contest.weekly_contest_307;

/**
 * https://leetcode.cn/contest/weekly-contest-307/
 */

/**
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 */
public class Problem1 {

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int expTrainHour = 0;

        for (int x : experience) {
            if (initialExperience > x) {
                initialExperience += x;
            } else {
                int needTrain = (x + 1) - initialExperience;
                expTrainHour += needTrain;
                initialExperience += x + needTrain;
            }
        }

        int energyTrainHour = 0;

        for (int x : energy) {
            if (initialEnergy > x) {
                initialEnergy -= x;
            } else {
                energyTrainHour += (x + 1) - initialEnergy;
                initialEnergy = 1;
            }
        }

        return expTrainHour + energyTrainHour;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
        System.out.println("6 ?= " + minNumberOfHours(5, 1, new int[]{1, 3, 3}, new int[]{1, 3, 7}));
        System.out.println("0 ?= " + minNumberOfHours(2, 4, new int[]{1}, new int[]{3}));
    }
}
