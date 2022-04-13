package com.longluo.studyplan.programming_skills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 66. 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * https://leetcode-cn.com/problems/plus-one/
 * <p>
 * https://leetcode.com/problems/plus-one/
 */
public class Problem66_plusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            if (i == n - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }
            res.add(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            res.add(carry);
        }
        int[] ans = new int[res.size()];
        int len = res.size();
        for (int i = 0; i < len; i++) {
            ans[i] = res.get(len - i - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[1, 2, 4] ?= " + Arrays.toString(plusOne(new int[]{1, 2, 3})));
    }
}
