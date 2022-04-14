package com.longluo.studyplan.ponyai.teammanage;

import java.util.Scanner;

/**
 * Pony.ai-001. 车队管理
 * <p>
 * 小马智行(Pony.ai) 在广州南沙区有一支稳定运营的自动驾驶车队，可以将南沙区的地图看做一个二维的网格图，小马智行的广州 office 在 (0, 0) 位置。
 * 公司现在有 n 台车，每天会按如下规则从围绕南沙区进行路测：
 * <p>
 * 初始 n 辆车都在公司。
 * 放眼整个南沙地图，每过一分钟，若有一个网格的车数大于等于8，则这个网格同时会有8辆车分别前往上，下，左，右，左上，左下，右上，右下的网格，
 * 不停执行该步骤直到所有的车辆的位置都固定不变。
 * <p>
 * 作为小马智行车辆控制中心的一员，你需要监管车辆运营的情况，你需要等到所有车辆的位置固定之后，进行q次抽样统计，每次需要统计出以(x1,y1)为左下角，
 * 以(x2, y2)为右上角的矩形范围内车辆的车辆的数目。
 * <p>
 * 输入描述：
 * 第一行为 n 和 q，分别代表初始office内的车辆数和抽样的次数。之后q行，每行包含4个变量，x1、y1、x2、y2
 * <p>
 * 含义见题目描述。
 * 1 1<= n <=10^5, 1<= q <=10^5，x,y∈[-10^9,10^9]后，进行q次抽样，每次查询以(x1,y1)为左下角，以(x2,y2)为右上角的矩形范围内车辆的数目。
 * <p>
 * 输出描述：
 * 输出q次抽样的结果，每次结果独占一行。
 * <p>
 * 示例 1：
 * 输入
 * 8 2
 * 0 0 0 0
 * -1 -1 1 1
 * <p>
 * 输出
 * 0
 * 8
 * <p>
 * 说明
 * 第 0 分钟所有车辆都在 office 处。
 * 第 1 分钟及以后, 8 辆车分别在 (-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1) 这 8 个位置。
 * <p>
 * https://leetcode-cn.com/problems/nDTGrx/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int carsNum = Integer.parseInt(line[0]);
        int sampleNum = Integer.parseInt(line[1]);
        int r = (int) Math.log(carsNum) / 2;
        int d = 2 * r + 1;
        int[][] mat = new int[d][d];
        mat[r][r] = carsNum;
        //
        distribution(mat, d);

        for (int i = 0; i < sampleNum; i++) {
            String[] coords = scanner.nextLine().split("\\s+");
            int[] left = new int[2];
            int[] right = new int[2];
            left[0] = Integer.parseInt(coords[0]);
            left[1] = Integer.parseInt(coords[1]);
            right[0] = Integer.parseInt(coords[2]);
            right[1] = Integer.parseInt(coords[3]);
            System.out.println(calcCarsNumber(mat, r, left, right));
        }
    }

    public static void distribution(int[][] matrix, int d) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        boolean isUnstable = true;
        while (isUnstable) {
            isUnstable = false;
            for (int i = 0; i < d; i++) {
                for (int j = 0; j < d; j++) {
                    if (matrix[i][j] >= 8) {
                        isUnstable = true;
                        for (int[] dir : dirs) {
                            int nextX = i + dir[0];
                            int nextY = j + dir[1];
                            matrix[nextX][nextY] = matrix[i][j] / 8;
                        }

                        matrix[i][j] = matrix[i][j] % 8;
                    }
                }
            }
        }
    }

    public static int calcCarsNumber(int[][] matrix, int r, int[] leftBottom, int[] rightTop) {
        if (leftBottom[0] >= rightTop[0] || leftBottom[1] >= rightTop[1]) {
            return 0;
        }

        leftBottom[0] = Math.max(leftBottom[0] + r, 0);
        leftBottom[1] = Math.max(leftBottom[1] + r, 0);

        rightTop[0] = Math.min(rightTop[0] + r, 2 * r);
        rightTop[1] = Math.min(rightTop[1] + r, 2 * r);

        int ans = 0;
        for (int i = leftBottom[0]; i <= rightTop[0]; i++) {
            for (int j = leftBottom[1]; j <= rightTop[1]; j++) {
                ans += matrix[i][j];
            }
        }

        return ans;
    }
}
