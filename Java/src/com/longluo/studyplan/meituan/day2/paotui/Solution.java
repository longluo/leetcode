package com.longluo.studyplan.meituan.day2.paotui;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://leetcode-cn.com/problems/GXV5dX/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int orderTotal = scanner.nextInt();
        int orderAllow = scanner.nextInt();
        scanner.nextLine();
        List<int[]> orders = new ArrayList<>();
        for (int i = 0; i < orderTotal; i++) {
            int[] order = new int[3];
            order[0] = scanner.nextInt();
            order[1] = scanner.nextInt();
            order[2] = i + 1;
            orders.add(order);
        }

        Collections.sort(orders, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[0] + o1[1] * 2;
                int b = o2[0] + o2[1] * 2;
                if (a == b) {
                    return o1[2] - o2[2];
                }
                return b - a;
            }
        });

        int[] res = new int[orderAllow];
        for (int i = 0; i < orderAllow; i++) {
            res[i] = orders.get(i)[2];
        }
        Arrays.sort(res);
        for (int i = 0; i < orderAllow; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
