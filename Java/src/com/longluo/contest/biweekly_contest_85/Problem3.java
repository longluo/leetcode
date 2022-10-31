package com.longluo.contest.biweekly_contest_85;

/**
 * https://leetcode.cn/problems/shifting-letters-ii/
 */
public class Problem3 {

    // TLE
    public static String shiftingLetters(String s, int[][] shifts) {
        char[] array = s.toCharArray();

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            for (int i = start; i <= end; i++) {
                if (direction == 1) {
                    array[i] = array[i] == 'z' ? 'a' : (char) (array[i] + 1);
                } else {
                    array[i] = array[i] == 'a' ? 'z' : (char) (array[i] - 1);
                }
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println("ace ?= " + shiftingLetters("abc", new int[][]{{0, 1, 0}, {1, 2, 1}, {0, 2, 1}}));
    }
}
