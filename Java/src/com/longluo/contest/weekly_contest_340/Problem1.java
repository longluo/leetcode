package com.longluo.contest.weekly_contest_340;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/contest/weekly-contest-340
 */
public class Problem1 {

    // Sort time: O(nlogn + sqrt(n)) space: O(n)
    public static int diagonalPrime(int[][] nums) {
        int n = nums.length;

        int ans = 0;

        List<Integer> diagNums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            diagNums.add(nums[i][i]);
            diagNums.add(nums[i][n - i - 1]);
        }

        Collections.sort(diagNums);

        for (int i = diagNums.size() - 1; i >= 0; i--) {
            int x = diagNums.get(i);

            boolean flag = true;

            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag && x >= 2) {
                ans = x;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("11 ?= " + diagonalPrime(new int[][]{{1, 2, 3}, {5, 6, 7}, {9, 10, 11}}));
        System.out.println("17 ?= " + diagonalPrime(new int[][]{{1, 2, 3}, {5, 17, 7}, {9, 11, 10}}));
        System.out.println("0 ?= " + diagonalPrime(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }
}
