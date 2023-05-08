package com.longluo.LCCUP.LCCUP_2023_Spring_Team;

import java.util.Arrays;

/**
 * LCP 78. 城墙防线
 * <p>
 * 在探险营地间，小扣意外发现了一片城墙遗迹，在探索期间，却不巧遇到迁徙中的兽群向他迎面冲来。
 * 情急之下小扣吹响了他的苍蓝笛，随着笛声响起，遗迹中的城墙逐渐发生了横向膨胀。
 * <p>
 * 已知 rampart[i] = [x,y] 表示第 i 段城墙的初始所在区间。当城墙发生膨胀时，将遵循以下规则：
 * 所有的城墙会同时膨胀相等的长度；
 * 每个城墙可以向左、向右或向两个方向膨胀。
 * <p>
 * 小扣为了确保自身的安全，需要在所有城墙均无重叠的情况下，让城墙尽可能的膨胀。请返回城墙可以膨胀的 最大值 。
 * <p>
 * 注意：
 * 初始情况下，所有城墙均不重叠，且 rampart 中的元素升序排列；
 * 两侧的城墙可以向外无限膨胀。
 * <p>
 * 示例 1：
 * 输入：rampart = [[0,3],[4,5],[7,9]]
 * 输出：3
 * 解释：如下图所示：
 * rampart[0] 向左侧膨胀 3 个单位；
 * rampart[2] 向右侧膨胀 3 个单位；
 * rampart[1] 向左侧膨胀 1 个单位，向右膨胀 2 个单位。
 * 不存在膨胀更多的方案，返回 3。
 * <p>
 * 示例 2：
 * 输入：rampart = [[1,2],[5,8],[11,15],[18,25]]
 * 输出：4
 * <p>
 * 提示：
 * 3 <= rampart.length <= 10^4
 * rampart[i].length == 2
 * 0 <= rampart[i][0] < rampart[i][1] <= rampart[i+1][0] <= 10^8
 * <p>
 * https://leetcode.cn/problems/Nsibyl/
 */
public class T2_LCP78_rampartDefensiveLine {

    public static int rampartDefensiveLine(int[][] rampart) {
        int n = rampart.length;

        int[] gaps = new int[n - 1];

        for (int i = 1; i < n; i++) {
            int prev = rampart[i - 1][1];
            int curr = rampart[i][0];

            gaps[i - 1] = curr - prev;
        }

        int total = Arrays.stream(gaps).sum();

        int ans = total / (n - 2);

        for (int i = 0; i < n - 1; i++) {
            int sum = gaps[i];
            for (int j = i + 1; j < n - 1; j++) {
                sum += gaps[j];
                ans = Math.min(ans, sum / (j - i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + rampartDefensiveLine(new int[][]{{0, 3}, {4, 5}, {7, 9}}));
        System.out.println("4 ?= " + rampartDefensiveLine(new int[][]{{1, 2}, {5, 8}, {11, 15}, {18, 25}}));
        System.out.println("2 ?= " + rampartDefensiveLine(new int[][]{{3, 5}, {12, 29}, {31, 38}, {39, 42}, {43, 44}, {46, 47}}));
        System.out.println("2 ?= " + rampartDefensiveLine(new int[][]{{0, 1}, {16, 20}, {21, 26}, {28, 33}, {36, 40}, {42, 44}, {45, 46}}));
    }
}
