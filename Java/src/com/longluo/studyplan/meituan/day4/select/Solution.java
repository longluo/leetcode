package com.longluo.studyplan.meituan.day4.select;

import java.util.Scanner;

/**
 * meituan-007. 小团的选调计划
 * <p>
 * 美团打算选调 n 名业务骨干到 n 个不同的业务区域，本着能者优先的原则，公司将这 n 个人按照业务能力从高到底编号为 1~n 。
 * 编号靠前的人具有优先选择的权力，每一个人都会填写一个意向，这个意向是一个 1~n 的排列，表示一个人希望的去的业务区域顺序，
 * 如果有两个人同时希望去某一个业务区域则优先满足编号小的人，每个人最终只能去一个业务区域。
 * 例如 3 个人的意向顺序都是 1 2 3 ，则第一个人去 1 号区域，第二个人由于 1 号区域被选择了，所以只能选择 2 号区域，
 * 同理第三个人只能选择 3 号区域。
 * <p>
 * 最终请你输出每个人最终去的区域。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行是一个正整数 n ，表示业务骨干和业务区域数量。
 * - 接下来有 n 行，每行 n 个整数，即一个 1~n 的排列，第 i 行表示 i-1 号业务骨干的意向顺序。
 * 输出：
 * - 输出包含 n 个正整数，第 i 个正整数表示第 i 号业务骨干最终去的业务区域编号。
 * <p>
 * 示例：
 * 输入：
 * 5
 * 1 5 3 4 2
 * 2 3 5 4 1
 * 5 4 1 2 3
 * 1 2 5 4 3
 * 1 4 5 2 3
 * 输出：1 2 5 4 3
 * <p>
 * 提示：
 * n ≤ 300
 * <p>
 * https://leetcode-cn.com/problems/SDRaNt/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        boolean[] isSelected = new boolean[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isSelected[matrix[i][j] - 1]) {
                    isSelected[matrix[i][j] - 1] = true;
                    result[i] = matrix[i][j];
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

