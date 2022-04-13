package com.longluo.studyplan.programming_skills;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * <p>
 * 整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。
 * <p>
 * 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
 * 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。
 * <p>
 * 示例 1：
 * 输入：num = [1,2,0,0], k = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * 示例 2：
 * 输入：num = [2,7,4], k = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * <p>
 * 示例 3：
 * 输入：num = [2,1,5], k = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * <p>
 * 提示：
 * 1 <= num.length <= 10^4
 * 0 <= num[i] <= 9
 * num 不包含任何前导零，除了零本身
 * 1 <= k <= 10^4
 * <p>
 * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 */
public class Problem989_addToArrayFormOfInteger {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int len = num.length;
        int carry = 0;
        int p = len - 1;
        while (p >= 0 || k > 0) {
            carry += p >= 0 ? num[p] : 0;
            carry += k % 10;
            ans.add(carry % 10);
            carry /= 10;
            p--;
            k /= 10;
        }

        if (carry > 0) {
            ans.add(carry);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            res.add(ans.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("[2, 3] ?= " + addToArrayForm(new int[]{0}, 23));
        System.out.println("[1, 2, 3, 4] ?= " + addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println("[4, 5, 5] ?= " + addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println("[1, 0, 2, 1] ?= " + addToArrayForm(new int[]{2, 1, 5}, 806));
    }
}
