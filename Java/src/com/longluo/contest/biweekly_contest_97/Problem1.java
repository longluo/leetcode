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

    public static int[] separateDigits_opt(int[] nums) {
        List<Integer> digits = new ArrayList<>();

        for (int x : nums) {
            List<Integer> values = getDigits(x);
            for (int i = values.size() - 1; i >= 0; i--) {
                digits.add(values.get(i));
            }
        }

        int[] ans = new int[digits.size()];
        for (int i = 0; i < digits.size(); i++) {
            ans[i] = digits.get(i);
        }

        return ans;
    }

    private static List<Integer> getDigits(int num) {
        List<Integer> list = new ArrayList<>();

        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println("[1,3,2,5,8,3,7,7] ?= " + Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
        System.out.println("[1,3,2,5,8,3,7,7] ?= " + Arrays.toString(separateDigits_opt(new int[]{13, 25, 83, 77})));
    }
}
