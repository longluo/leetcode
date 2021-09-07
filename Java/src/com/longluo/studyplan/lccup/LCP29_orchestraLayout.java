package com.longluo.studyplan.lccup;

/**
 * LCP 29. 乐团站位
 * <p>
 * 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，
 * 乐器编号为 1~9，每位成员持有 1 个乐器。
 * 为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。
 * 例如当 num = 5 时，站位如图所示
 * <p>
 * image.png
 * <p>
 * 请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 * <p>
 * 示例 1：
 * 输入：num = 3, Xpos = 0, Ypos = 2
 * 输出：3
 * 解释：
 * image.png
 * <p>
 * 示例 2：
 * 输入：num = 4, Xpos = 1, Ypos = 2
 * 输出：5
 * 解释：
 * image.png
 * <p>
 * 提示：
 * 1 <= num <= 10^9
 * 0 <= Xpos, Ypos < num
 * <p>
 * https://leetcode-cn.com/problems/SNJvJP/
 */
public class LCP29_orchestraLayout {

    public static int orchestraLayout(int num, int xPos, int yPos) {
        if (num <= 1) {
            return 1;
        }

        int idx = 1;
        int[][] matrix = new int[num][num];
        for (int cycle = 0; cycle <= num / 2; cycle++) {
            // left->right
            for (int i = cycle; i <= num - 1 - cycle; i++) {
                matrix[cycle][i] = idx++;
                if (idx >= 10) {
                    idx = 1;
                }
            }

            // up->down
            for (int i = cycle + 1; i <= num - 1 - cycle; i++) {
                matrix[i][num - 1 - cycle] = idx++;
                if (idx >= 10) {
                    idx = 1;
                }
            }

            // right->left
            for (int i = num - 2 - cycle; i >= cycle; i--) {
                matrix[num - 1 - cycle][i] = idx++;
                if (idx == 10) {
                    idx = 1;
                }
            }

            // down->up
            for (int i = num - 2 - cycle; i > cycle; i--) {
                matrix[i][cycle] = idx++;
                if (idx == 10) {
                    idx = 1;
                }
            }
        }

        return matrix[xPos][yPos];
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + orchestraLayout(3, 0, 2));
        System.out.println("5 ?= " + orchestraLayout(4, 1, 2));
        System.out.println("1 ?= " + orchestraLayout(19, 9, 9));
    }
}
