package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle/
 * <p>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Problem118_pascalsTriangle {

    // BF DP time: O(n^2) space: O(n^2)
    public static List<List<Integer>> generate_bf(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows <= 0) {
            return ans;
        }

        List<Integer> one = new ArrayList<>();
        one.add(1);
        ans.add(one);

        if (numRows <= 1) {
            return ans;
        }

        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        ans.add(two);

        if (numRows <= 2) {
            return ans;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> oneRow = new ArrayList<>();
            List<Integer> last = ans.get(i - 1);
            oneRow.add(1);
            for (int j = 1; j < i; j++) {
                oneRow.add(last.get(j - 1) + last.get(j));
            }
            oneRow.add(1);
            ans.add(oneRow);
        }

        return ans;
    }

    // DP time: O(n^2) space: O(n^2)
    public static List<List<Integer>> generate_dp(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> oneRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    oneRow.add(1);
                } else {
                    oneRow.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }

            ans.add(oneRow);
        }

        return ans;
    }

    public static void main(String[] args) {
        generate_bf(1);
        generate_bf(2);
        generate_bf(5);
        generate_dp(1);
        generate_dp(2);
        generate_dp(5);
    }
}
