package com.longluo.leetcode.greedy;

/**
 * 991. Broken Calculator
 * <p>
 * Medium
 * <p>
 * There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:
 * <p>
 * multiply the number on display by 2, or
 * subtract 1 from the number on display.
 * Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.
 * <p>
 * Example 1:
 * Input: startValue = 2, target = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * <p>
 * Example 2:
 * Input: startValue = 5, target = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * <p>
 * Example 3:
 * Input: startValue = 3, target = 10
 * Output: 3
 * Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * <p>
 * Constraints:
 * 1 <= x, y <= 10^9
 * <p>
 * https://leetcode.com/problems/broken-calculator/
 */
public class Problem991_brokenCalculator {

    public static int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        }

        int ans = 0;
        while (startValue < target) {
            if (target % 2 == 0) {
                target >>= 1;
                ans++;
            } else {
                target = (target + 1) >> 1;
                ans += 2;
            }
        }

        return ans + startValue - target;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + brokenCalc(2, 3));
        System.out.println("1 ?= " + brokenCalc(2, 4));
        System.out.println("2 ?= " + brokenCalc(5, 8));
        System.out.println("2 ?= " + brokenCalc(5, 9));
        System.out.println("3 ?= " + brokenCalc(3, 10));
        System.out.println("39 ?= " + brokenCalc(1, 1000000000));
    }
}
