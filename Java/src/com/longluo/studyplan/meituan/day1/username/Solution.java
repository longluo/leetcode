package com.longluo.studyplan.meituan.day1.username;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/BaR9fy/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] namesArray = new String[n];
        for (int i = 0; i < n; i++) {
            namesArray[i] = scanner.nextLine();
        }
        String[] result = new String[n];
        checkNameValid(namesArray, result);
        for (String output : result) {
            System.out.println(output);
        }
    }

    public static void checkNameValid(String[] namesArray, String[] result) {
        if (namesArray == null || namesArray.length == 0 || result == null || result.length == 0) {
            return;
        }

        int n = namesArray.length;
        for (int i = 0; i < n; i++) {
            String name = namesArray[i];
            if (!Character.isLetter(name.charAt(0)) || name.length() <= 1) {
                result[i] = "Wrong";
                continue;
            }

            int letterNum = 0;
            int digitNum = 0;
            for (Character ch : name.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digitNum++;
                } else if (Character.isLetter(ch)) {
                    letterNum++;
                } else {
                    result[i] = "Wrong";
                    break;
                }
            }
            if (letterNum > 0 && digitNum > 0) {
                result[i] = "Accept";
            } else {
                result[i] = "Wrong";
            }
        }
    }
}
