package com.longluo.contest.biweekly_contest_81;

import java.util.Stack;

/**
 * https://leetcode.cn/contest/biweekly-contest-81/
 */

/**
 * https://leetcode.cn/contest/biweekly-contest-81/problems/count-asterisks/
 */
public class Problem1 {

    public static int countAsterisks(String s) {
        int len = s.length();

        int ans = 0;

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '*' && stk.empty()) {
                ans++;
            }

            if (ch == '|') {
                if (stk.empty()) {
                    stk.push(ch);
                } else {
                    stk.pop();
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println("0 ?= " + countAsterisks("iamprogrammer"));
        System.out.println("5 ?= " + countAsterisks("yo|uar|e**|b|e***au|tifu|l"));
    }
}
