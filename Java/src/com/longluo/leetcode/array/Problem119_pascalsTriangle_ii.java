package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * <p>
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * <p>
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class Problem119_pascalsTriangle_ii {

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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

        return ans.get(rowIndex);
    }

    public static void main(String[] args) {

    }
}
