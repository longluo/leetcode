package com.longluo.studyplan.efficientwinning;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Day01_167 {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            res[0] = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] == target - numbers[i]) {
                    res[1] = j + 1;
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
