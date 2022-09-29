package com.longluo.lcci;

/**
 * 面试题 10.01. 合并排序的数组
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 说明:
 * A.length == n + m
 * <p>
 * https://leetcode.cn/problems/sorted-merge-lcci/
 */
public class Lcci_10_01_sortedMerge {

    // Two Pointers time: O(m + n) space: O(1)
    public static void merge(int[] A, int m, int[] B, int n) {
        int idx = m + n - 1;

        int p = m - 1;
        int q = n - 1;

        while (idx >= 0) {
            if (p >= 0 && q >= 0 && A[p] < B[q]) {
                A[idx] = B[q];
                q--;
            } else if (p >= 0 && q >= 0 && A[p] >= B[q]) {
                A[idx] = A[p];
                p--;
            } else if (p >= 0) {
                A[idx] = A[p];
                p--;
            } else {
                A[idx] = B[q];
                q--;
            }

            idx--;
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        merge(new int[]{0}, 0, new int[]{1}, 1);
    }
}
