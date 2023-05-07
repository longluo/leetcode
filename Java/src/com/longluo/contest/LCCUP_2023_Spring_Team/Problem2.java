package com.longluo.contest.LCCUP_2023_Spring_Team;

import java.util.Arrays;

public class Problem2 {

    public static int rampartDefensiveLine(int[][] rampart) {
        int n = rampart.length;

        int[] gaps = new int[n - 1];

        for (int i = 1; i < n; i++) {
            int prev = rampart[i - 1][1];
            int curr = rampart[i][0];

            gaps[i - 1] = curr - prev;
        }

        int total = Arrays.stream(gaps).sum();

        int ans = total / (n - 2);

        for (int i = 0; i < n - 1; i++) {
            int sum = gaps[i];
            for (int j = i + 1; j < n - 1; j++) {
                sum += gaps[j];
                ans = Math.min(ans, sum / (j - i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + rampartDefensiveLine(new int[][]{{0, 3}, {4, 5}, {7, 9}}));
        System.out.println("4 ?= " + rampartDefensiveLine(new int[][]{{1, 2}, {5, 8}, {11, 15}, {18, 25}}));
        System.out.println("2 ?= " + rampartDefensiveLine(new int[][]{{3, 5}, {12, 29}, {31, 38}, {39, 42}, {43, 44}, {46, 47}}));
        System.out.println("2 ?= " + rampartDefensiveLine(new int[][]{{0, 1}, {16, 20}, {21, 26}, {28, 33}, {36, 40}, {42, 44}, {45, 46}}));
    }
}
