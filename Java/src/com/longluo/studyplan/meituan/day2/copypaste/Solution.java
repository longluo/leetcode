package com.longluo.studyplan.meituan.day2.copypaste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * meituan-004. 小团的复制粘贴
 * <p>
 * 小团是一个莫得感情的 CtrlCV 大师，他有一个下标从 1 开始的序列 A 和一个初始全部为 -1 序列 B ，两个序列的长度都是 n 。
 * 他会进行若干次操作，每一次操作，他都会选择 A 序列中一段连续区间，将其粘贴到 B 序列中的某一个连续的位置，
 * 在这个过程中他也会查询 B 序列中某一个位置上的值。
 * <p>
 * 我们用如下的方式表示他的粘贴操作和查询操作：
 * 粘贴操作：1 k x y，表示把 A 序列中从下标 x 位置开始的连续 k 个元素粘贴到 B 序列中从下标 y 开始的连续 k 个位置上。
 * 原始序列中的元素被覆盖。（数据保证不会出现粘贴后 k 个元素超出 B 序列原有长度的情况）
 * 查询操作：2 x，表示询问B序列下标 x 处的值是多少。
 * <p>
 * 格式：
 * <p>
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示序列 A 和序列 B 的长度。
 * - 输入第二行包含 n 个正整数，表示序列 A 中的 n 个元素，第 i 个数字表示下标为 i 的位置上的元素，每一个元素保证在 10^9 以内。
 * - 输入第三行是一个操作数 m ，表示进行的操作数量。
 * - 接下来 m 行，每行第一个数字为 1 或 2 ，具体操作细节详见题面。
 * 输出：
 * - 对于每一个操作 2 输出一行，每行仅包含一个正整数，表示针对某一个询问的答案。
 * <p>
 * 示例 1：
 * 输入：
 * 5
 * 1 2 3 4 5
 * 5
 * 2 1
 * 2 5
 * 1 2 3 4
 * 2 3
 * 2 5
 * 输出：
 * -1
 * -1
 * -1
 * 4
 * <p>
 * 示例 2：
 * 输入：
 * 5
 * 1 2 3 4 5
 * 9
 * 1 2 3 4
 * 2 3
 * 2 5
 * 1 2 2 3
 * 2 1
 * 2 2
 * 2 3
 * 2 4
 * 2 5
 * 输出：
 * -1
 * 4
 * -1
 * -1
 * 2
 * 3
 * 4
 * <p>
 * 提示：
 * 1 <= n <= 2000
 * 1 <= m <= 2000
 * <p>
 * https://leetcode-cn.com/problems/TOVGD1/
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        Arrays.fill(arrayA, -1);
        Arrays.fill(arrayB, -1);
        String[] nums = sc.readLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(nums[i]);
        }
        int count = Integer.parseInt(sc.readLine());
        List<int[]> operList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] opts = sc.readLine().split("\\s+");
            if (opts[0].equals("1")) {
                int k = Integer.parseInt(opts[1]);
                int x = Integer.parseInt(opts[2]);
                int y = Integer.parseInt(opts[3]);
                operList.add(new int[]{k, x - 1, y - 1});
            } else if (opts[0].equals("2")) {
                int queryIdx = Integer.parseInt(opts[1]);
                queryIdx--;
                for (int j = operList.size() - 1; j >= 0; j--) {
                    int[] op = operList.get(j);
                    if (queryIdx >= op[2] && queryIdx <= op[0] + op[2] - 1) {
                        int offset = queryIdx - op[2];
                        arrayB[queryIdx] = arrayA[op[1] + offset];
                        break;
                    }
                }
                System.out.println(arrayB[queryIdx]);
            }
        }

        sc.close();
    }

    /*
    public static void main(String[] args) {
        sc sc = new sc(System.in);
        int n = Integer.parseInt(sc.readLine());
        int[] arrayA = new int[2 * n];
        int[] arrayB = new int[2 * n];
        Arrays.fill(arrayB, -1);
        String numStr = sc.readLine();
        String[] numArr = numStr.split("\\s+");
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(numArr[i]);
        }
        int operationNum = Integer.parseInt(sc.readLine());
        for (int i = 0; i < operationNum; i++) {
            String operStr = sc.readLine();
            String[] operStrArr = operStr.split("\\s+");
            int operation = Integer.parseInt(operStrArr[0]);
            if (operation == 1) {
                int k = Integer.parseInt(operStrArr[1]);
                int x = Integer.parseInt(operStrArr[2]);
                int y = Integer.parseInt(operStrArr[3]);
                System.arraycopy(arrayA, x - 1, arrayB, y - 1, k);
            } else if (operation == 2) {
                int queryIdx = Integer.parseInt(operStrArr[1]);
                System.out.println(arrayB[queryIdx - 1]);
            }
        }
    }
     */

    /*
    public static void main(String[] args) {
        sc sc = new sc(System.in);
        int n = Integer.parseInt(sc.readLine());
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        Arrays.fill(arrayB, -1);
        String numStr = sc.readLine();
        String[] numArr = numStr.split("\\s+");
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(numArr[i]);
        }
        int operationNum = Integer.parseInt(sc.readLine());
        for (int i = 0; i < operationNum; i++) {
            String operStr = sc.readLine();
            String[] operStrArr = operStr.split("\\s+");
            int operation = Integer.parseInt(operStrArr[0]);
            if (operation == 1) {
                int k = Integer.parseInt(operStrArr[1]);
                int x = Integer.parseInt(operStrArr[2]);
                int y = Integer.parseInt(operStrArr[3]);

                for (int j = 0; j < k; j++) {
                    if (y - 1 + j < n) {
                        arrayB[y - 1 + j] = arrayA[x - 1 + j];
                    }
                }
            } else if (operation == 2) {
                int queryIdx = Integer.parseInt(operStrArr[1]);
                System.out.println(arrayB[queryIdx - 1]);
            }
        }
    }
    */
}
