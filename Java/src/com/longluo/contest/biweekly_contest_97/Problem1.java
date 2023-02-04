package com.longluo.contest.biweekly_contest_97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/contest/biweekly-contest-97
 */
public class Problem1 {

    public static int[] separateDigits(int[] nums) {
        List<Integer> digitList = new ArrayList<>();

        for (int x : nums) {
            String str = String.valueOf(x);
            for (char ch : str.toCharArray()) {
                digitList.add(ch - '0');
            }
        }

        int n = digitList.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = digitList.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1,3,2,5,8,3,7,7] ?= " + Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
    }
}
