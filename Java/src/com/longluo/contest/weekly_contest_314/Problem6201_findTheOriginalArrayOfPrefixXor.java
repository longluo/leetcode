package com.longluo.contest.weekly_contest_314;

import java.util.Arrays;

/**
 * 6201. 找出前缀异或的原始数组
 * <p>
 * 给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
 * <p>
 * pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
 * 注意 ^ 表示 按位异或（bitwise-xor）运算。
 * <p>
 * 可以证明答案是 唯一 的。
 * <p>
 * 示例 1：
 * 输入：pref = [5,2,0,3,1]
 * 输出：[5,7,2,3,2]
 * 解释：从数组 [5,7,2,3,2] 可以得到如下结果：
 * - pref[0] = 5
 * - pref[1] = 5 ^ 7 = 2
 * - pref[2] = 5 ^ 7 ^ 2 = 0
 * - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
 * - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1
 * <p>
 * 示例 2：
 * 输入：pref = [13]
 * 输出：[13]
 * 解释：pref[0] = arr[0] = 13
 * <p>
 * 提示：
 * 1 <= pref.length <= 10^5
 * 0 <= pref[i] <= 10^6
 * <p>
 * https://leetcode.com/problems/find-the-original-array-of-prefix-xor/
 */
public class Problem6201_findTheOriginalArrayOfPrefixXor {

    // BF time: O(n^2) space: O(n)
    public static int[] findArray_bf(int[] pref) {
        int len = pref.length;

        int[] ans = new int[len];
        ans[0] = pref[0];
        for (int i = 1; i < len; i++) {
            int xor = 0;
            for (int j = 0; j < i; j++) {
                xor = xor ^ ans[j];
            }

            ans[i] = xor ^ pref[i];
        }

        return ans;
    }

    // XOR time: O(n) space: O(n)
    public static int[] findArray(int[] pref) {
        int len = pref.length;

        int[] ans = new int[len];
        ans[0] = pref[0];

        for (int i = 1; i < len; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[5, 7, 2, 3, 2] ?= " + Arrays.toString(findArray_bf(new int[]{5, 2, 0, 3, 1})));
        System.out.println("[5, 7, 2, 3, 2] ?= " + Arrays.toString(findArray(new int[]{5, 2, 0, 3, 1})));
    }
}
