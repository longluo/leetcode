package com.longluo.contest.weekly_contest_300;

import com.longluo.datastructure.LinkedListNodeUtils;
import com.longluo.datastructure.ListNode;

import java.util.Arrays;

public class Problem2 {

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(mat[i], -1);
        }

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                if (head != null) {
                    mat[0][i] = head.val;
                    head = head.next;
                } else {
                    return mat;
                }
            }
        }

        for (int cycle = 0; cycle <= m / 2; cycle++) {
            for (int i = cycle; i <= n - 1 - cycle; i++) {
                if (head != null) {
                    mat[cycle][i] = head.val;
                    head = head.next;
                } else {
                    return mat;
                }
            }

            for (int i = cycle + 1; i < m - 1 - cycle; i++) {
                if (head != null) {
                    mat[i][n - 1 - cycle] = head.val;
                    head = head.next;
                } else {
                    return mat;
                }
            }

            for (int i = n - 1 - cycle; i > cycle; i--) {
                if (head != null) {
                    mat[m - 1 - cycle][i] = head.val;
                    head = head.next;
                } else {
                    return mat;
                }
            }

            for (int i = m - 1 - cycle; i > cycle; i--) {
                if (head != null) {
                    mat[i][cycle] = head.val;
                    head = head.next;
                } else {
                    return mat;
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        ListNode tst1 = LinkedListNodeUtils.constructListNode(new int[]{0, 1, 2});
        System.out.println("[[0, 1, 2, -1]] ?= " + Arrays.deepToString(spiralMatrix(1, 4, tst1)));

        ListNode tst2 = LinkedListNodeUtils.constructListNode(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        System.out.println("[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]] ?= " + Arrays.deepToString(spiralMatrix(3, 5, tst2)));

        ListNode tst3 = LinkedListNodeUtils.constructListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("[[1,2,3],[8,9,4],[7,6,5]] ?= " + Arrays.deepToString(spiralMatrix(3, 3, tst3)));
    }
}
