package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i]的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * 示例 1：
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * <p>
 * 示例 2：
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * <p>
 * 示例 3：
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * <p>
 * 示例 4：
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 * <p>
 * 提示：
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 */
public class Problem1018_prefixesDivBy5 {

    public static List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return new ArrayList<Boolean>();
        }

        List<Boolean> ans = new ArrayList<>(A.length);
        int[] res = new int[A.length];
        res[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            res[i] = (A[i] + res[i - 1] * 2) % 5;
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[true,false,false] ?= " + prefixesDivBy5(new int[]{0, 1, 1}));
        System.out.println("[ ] ?= " + prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1}))
        ;
    }
}
