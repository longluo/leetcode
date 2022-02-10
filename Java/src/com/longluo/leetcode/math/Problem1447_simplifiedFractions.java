package com.longluo.leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 1447. 最简分数
 * <p>
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：["1/2","1/3","2/3"]
 * <p>
 * 示例 3：
 * 输入：n = 4
 * 输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * <p>
 * 示例 4：
 * 输入：n = 1
 * 输出：[]
 * <p>
 * 提示：
 * 1 <= n <= 100
 * <p>
 * https://leetcode-cn.com/problems/simplified-fractions/
 */
public class Problem1447_simplifiedFractions {

    public static List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 1) {
            return res;
        }

        for (int i = 2; i <= n; i++) {
            res.add("1/" + i);
            for (int j = 2; j <= i; j++) {
                boolean flag = true;
                for (int k = 2; k <= j; k++) {
                    if (i % k == 0 && j % k == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res.add(j + "/" + i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + simplifiedFractions(1));
        System.out.println("[1/2] ?= " + simplifiedFractions(2));
        System.out.println("[1/2, 1/3, 2/3] ?= " + simplifiedFractions(3));
        System.out.println("[1/2, 1/3, 1/4, 2/3, 3/4] ?= " + simplifiedFractions(4));
        System.out.println("[1/2, 1/3, 2/3, 1/4, 3/4, 1/5, 2/5, 3/5, 4/5, 1/6, 5/6] ?= " + simplifiedFractions(6));
    }
}
