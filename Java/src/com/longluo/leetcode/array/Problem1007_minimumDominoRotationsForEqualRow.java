package com.longluo.leetcode.array;

import java.util.*;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 * Medium
 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
 * Return the minimum number of rotations so that all the values in tops are the same, or all the values
 * in bottoms are the same.
 * If it cannot be done, return -1.
 * <p>
 * Example 1:
 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 * <p>
 * Example 2:
 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 * <p>
 * Constraints:
 * 2 <= tops.length <= 2 * 10^4
 * bottoms.length == tops.length
 * 1 <= tops[i], bottoms[i] <= 6
 * <p>
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class Problem1007_minimumDominoRotationsForEqualRow {

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int ans = check(tops[0], tops, bottoms);
        if (ans > 0 || tops[0] == bottoms[0]) {
            return ans;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }

    public static int check(int anchor, int[] A, int[] B) {
        int len = A.length;
        int rotateA = 0;
        int rotateB = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] != anchor && B[i] != anchor) {
                return -1;
            }

            if (A[i] != anchor) {
                rotateA++;
            }

            if (B[i] != anchor) {
                rotateB++;
            }
        }

        return Math.min(rotateA, rotateB);
    }

    public static int minDominoRotations_better(int[] tops, int[] bottoms) {
        int len = tops.length;
        Map<Integer, Integer> topMap = new HashMap<>();
        Map<Integer, Integer> bottomMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            topMap.put(tops[i], topMap.getOrDefault(tops[i], 0) + 1);
            bottomMap.put(bottoms[i], bottomMap.getOrDefault(bottoms[i], 0) + 1);
        }

        int ans = -1;
        for (int i = 1; i <= 6; i++) {
            int total = topMap.getOrDefault(i, 0) + bottomMap.getOrDefault(i, 0);
            if (total >= len) {
                ans = check(i, tops, bottoms);
            }
        }

        return ans;
    }

    public static int minDominoRotations_greedy(int[] tops, int[] bottoms) {
        int len = tops.length;
        Map<Integer, Integer> topMap = new HashMap<>();
        Map<Integer, Integer> bottomMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            topMap.put(tops[i], topMap.getOrDefault(tops[i], 0) + 1);
            bottomMap.put(bottoms[i], bottomMap.getOrDefault(bottoms[i], 0) + 1);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int total = topMap.getOrDefault(i, 0) + bottomMap.getOrDefault(i, 0);
            if (total >= len) {
                if (topMap.getOrDefault(i, 0) >= bottomMap.getOrDefault(i, 0)) {
                    boolean isCanRotate = true;
                    int cnt = 0;
                    for (int j = 0; j < len; j++) {
                        if (tops[j] == i) {
                            continue;
                        } else if (tops[j] != i && bottoms[j] != i) {
                            isCanRotate = false;
                            break;
                        } else if (bottoms[j] == i) {
                            cnt++;
                        }
                    }

                    if (isCanRotate) {
                        ans = Math.min(ans, cnt);
                    }
                } else {
                    boolean isCanRotate = true;
                    int cnt = 0;
                    for (int j = 0; j < len; j++) {
                        if (bottoms[j] == i) {
                            continue;
                        } else if (tops[j] != i && bottoms[j] != i) {
                            isCanRotate = false;
                            break;
                        } else if (tops[j] == i) {
                            cnt++;
                        }
                    }

                    if (isCanRotate) {
                        ans = Math.min(ans, cnt);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println("-1 ?= " + minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));

        System.out.println("0 ?= " + minDominoRotations_better(new int[]{3, 3}, new int[]{2, 5}));
        System.out.println("1 ?= " + minDominoRotations_better(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println("2 ?= " + minDominoRotations_better(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println("-1 ?= " + minDominoRotations_better(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));

        System.out.println("0 ?= " + minDominoRotations_greedy(new int[]{3, 3}, new int[]{2, 5}));
        System.out.println("1 ?= " + minDominoRotations_greedy(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println("2 ?= " + minDominoRotations_greedy(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println("-1 ?= " + minDominoRotations_greedy(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
    }
}
