package com.longluo.offer;

import com.longluo.datastructure.Utils;

import java.util.*;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数target，输出所有和为target的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * <p>
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * 1 <= target <= 10^5
 */
public class Offer57_findContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();

        int sum = 0;
        int right = (target - 1) / 2;

        for (int i = 1; i <= right; i++) {
            sum = i;
            for (int j = i + 1; j <= target - i; j++) {
                sum += j;
                if (sum > target) {
                    break;
                } else if (sum == target) {
                    int[] temp = new int[j - i + 1];
                    for (int k = 0; k < j - i + 1; k++) {
                        temp[k] = i + k;
                    }

                    res.add(temp);
                    break;
                }
            }
        }

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("[[2,3,4],[4,5]] ?= " + Utils.print2DArray(findContinuousSequence(9)));
        System.out.println("[[1,2,3,4,5],[4,5,6],[7,8]] ?= " + Utils.print2DArray(findContinuousSequence(15)));
        System.out.println("[[1,2,3,4]] ?= " + Utils.print2DArray(findContinuousSequence(10)));
    }
}
