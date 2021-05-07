package com.longluo.leetcode.backtracking;

import com.longluo.datastructure.LinkedListNodeUtils;

import java.util.*;

/**
 * 842. 将数组拆分成斐波那契序列
 * <p>
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * <p>
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 * F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * <p>
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * <p>
 * 返回从S拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 * <p>
 * <p>
 * 示例 1：
 * 输入："123456579"
 * 输出：[123,456,579]
 * <p>
 * 示例 2：
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * <p>
 * 示例 3：
 * 输入: "112358130"
 * 输出: []
 * 解释: 这项任务无法完成。
 * <p>
 * 示例 4：
 * 输入："0123"
 * 输出：[]
 * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
 * <p>
 * 示例 5：
 * 输入: "1101111"
 * 输出: [110, 1, 111]
 * 解释: 输出 [11,0,11,11] 也同样被接受。
 * <p>
 * 提示：
 * 1 <= S.length <= 200
 * 字符串S中只含有数字。
 * <p>
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 */
public class Problem842_splitArrayIntoFibonacciSequence {

    public static List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        backtrack(ans, S, S.length(), 0, 0, 0);
        return ans;
    }

    public static boolean backtrack(List<Integer> ans, String str, int length, int index, int sum, int prev) {
        if (index == length) {
            return ans.size() >= 3;
        }

        long currLong = 0;
        for (int i = index; i < str.length(); i++) {
            if (i > index && str.charAt(index) == '0') {
                break;
            }

            currLong = currLong * 10 + str.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }

            int curr = (int) currLong;
            if (ans.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }

            ans.add(curr);
            if (backtrack(ans, str, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                ans.remove(ans.size() - 1);
            }
        }

        return false;
    }

    public static boolean checkFibonacci(List<Integer> list) {
        if (list.size() < 2) {
            return false;
        }

        for (int i = 2; i < list.size(); i++) {
            if (list.get(i - 2) + list.get(i - 1) != list.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[123,456,579] ?= " + splitIntoFibonacci("123456579").toString());
        System.out.println("[1,1,2,3,5,8,13] ?= " + splitIntoFibonacci("11235813").toString());
        System.out.println("[] ?= " + splitIntoFibonacci("112358130").toString());
        System.out.println("[] ?= " + splitIntoFibonacci("0123").toString());
        System.out.println("[110, 1, 111] ?= " + splitIntoFibonacci("1101111").toString());
    }
}
