package com.longluo.studyplan.meituan.day1.username;

import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/BaR9fy/
 */
public class Solution {

    private static final String regex = "^([a-zA-Z])([a-zA-Z0-9]*)([0-9]+)([a-zA-Z0-9]*)$";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] namesArray = new String[n];
        for (int i = 0; i < n; i++) {
            namesArray[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(checkNameValid(namesArray[i]));
        }
    }

    public static String checkNameValid(String name) {
        if (name == null || name.length() <= 1) {
            return "Wrong";
        }

        int n = name.length();
        for (int i = 0; i < n; i++) {
            if (!Character.isLetter(name.charAt(0)) || name.length() <= 1) {
                return "Wrong";
            }

            int letterNum = 0;
            int digitNum = 0;
            for (Character ch : name.toCharArray()) {
                if (Character.isDigit(ch)) {
                    digitNum++;
                } else if (Character.isLetter(ch)) {
                    letterNum++;
                } else {
                    return "Wrong";
                }
            }
            if (letterNum > 0 && digitNum > 0) {
                return "Accept";
            } else {
                return "Wrong";
            }
        }

        return "Wrong";
    }
}
