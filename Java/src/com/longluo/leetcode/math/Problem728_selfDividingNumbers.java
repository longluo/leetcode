package com.longluo.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 728. 自除数
 * <p>
 * 自除数 是指可以被它包含的每一位数整除的数。
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * 示例 1：
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * 示例 2:
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 * <p>
 * 提示：
 * 1 <= left <= right <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 */
public class Problem728_selfDividingNumbers {

    // BF  String O(n^2) O(n)
    public static List<Integer> selfDividingNumbers_str(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String str = String.valueOf(i);
            boolean isSelfDivide = true;
            for (char ch : str.toCharArray()) {
                int num = ch - '0';
                if (num == 0 || i % num != 0) {
                    isSelfDivide = false;
                    break;
                }
            }

            if (isSelfDivide) {
                ans.add(i);
            }
        }

        return ans;
    }

    // Use Math O(n log right) O(1)
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkSelfDividing(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static boolean checkSelfDividing(int num) {
        int tNum = num;
        while (tNum > 0) {
            int digit = tNum % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }

            tNum /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            String str = String.valueOf(i);
            boolean isSelfDivide = true;
            for (char ch : str.toCharArray()) {
                int num = ch - '0';
                if (num == 0 || i % num != 0) {
                    isSelfDivide = false;
                    break;
                }
            }

            if (isSelfDivide) {
                System.out.print(i + ",");
            }
        }
    }
}
