package com.longluo.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 如果n是快乐数就返回True；不是，则返回False。
 * <p>
 * 示例：
 * 输入：19
 * 输出：true
 * <p>
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Problem202_happyNumber {

    public static boolean isHappy(int n) {
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        }

        List<Integer> repeat = new ArrayList<>();

        while (n != 1) {
            repeat.add(n);
            n = getResult(n);
            if (n == 1) {
                return true;
            }

            if (isExist(repeat, n)) {
                return false;
            }
        }

        return false;
    }

    public static boolean isExist(List<Integer> list, int number) {
        for (Integer num : list) {
            if (num == number) {
                return true;
            }
        }

        return false;
    }

    public static int getResult(int n) {
        List<Integer> res = new ArrayList<>();
        while (n > 0) {
            res.add(n % 10);
            n /= 10;
        }

        int ans = 0;
        for (Integer num : res) {
            ans += num * num;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isHappy(19));
        System.out.println("true ?= " + isHappy(1));
        System.out.println("false ?= " + isHappy(0));
        System.out.println("false ?= " + isHappy(2));

    }
}
