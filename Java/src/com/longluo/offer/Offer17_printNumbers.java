package com.longluo.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999。
 * <p>
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * 用返回一个整数列表来代替打印
 * n为正整数
 */
public class Offer17_printNumbers {

    public static int[] printNumbers(int n) {
        if (n <= 0) {
            return new int[]{};
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            max *= 10;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            ans.add(i);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("[1,2,3,4,5,6,7,8,9] ?= " + Arrays.toString(printNumbers(1)));
    }
}
