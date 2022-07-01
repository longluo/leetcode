package com.longluo.leetcode.sorting;

import java.util.Arrays;

/**
 * 1710. 卡车上的最大单元数
 * <p>
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * 示例 1：
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * <p>
 * 示例 2：
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 * <p>
 * 提示：
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 10^6
 * <p>
 * https://leetcode.cn/problems/maximum-units-on-a-truck/
 */
public class Problem1710_maximumUnitsOnATruck {

    // Greedy time: O(nlogn) space: O(1)
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int boxes = boxTypes[i][0];
            if (truckSize >= boxes) {
                ans += boxes * boxTypes[i][1];
                truckSize -= boxes;
            } else {
                ans += truckSize * boxTypes[i][1];
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
    }
}
