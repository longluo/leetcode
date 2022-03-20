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
        if (tops == null || tops.length <= 1) {
            return 0;
        }

        int len = tops.length;
        boolean flag = true;
        int topVal = tops[0];
        int bottomVal = bottoms[0];
        int topCnt = 0;
        for (int j = 1; j < len; j++) {
            if (tops[j] == topVal) {
                continue;
            } else if (bottoms[j] == topVal) {
                topCnt++;
            } else if (tops[j] != topVal && bottoms[j] != topVal) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            topCnt = -1;
        }

        flag = true;
        int bottomCnt = 0;
        for (int j = 1; j < len; j++) {
            if (bottoms[j] == bottomVal) {
                continue;
            } else if (tops[j] == bottomVal) {
                bottomCnt++;
            } else if (tops[j] != bottomVal && bottoms[j] != bottomVal) {
                flag = false;
                break;
            }
        }

        if (!flag) {
            bottomCnt = -1;
        }

        if (topCnt >= 0 && bottomCnt >= 0) {
            return Math.min(topCnt, bottomCnt);
        } else if (topCnt >= 0 && bottomCnt < 0) {
            return topCnt;
        } else if (topCnt < 0 && bottomCnt >= 0) {
            return bottomCnt;
        }

        return -1;
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

        System.out.println("0 ?= " + minDominoRotations_greedy(new int[]{3, 3}, new int[]{2, 5}));
        System.out.println("1 ?= " + minDominoRotations_greedy(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2}));
        System.out.println("2 ?= " + minDominoRotations_greedy(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}));
        System.out.println("-1 ?= " + minDominoRotations_greedy(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}));
    }
}
