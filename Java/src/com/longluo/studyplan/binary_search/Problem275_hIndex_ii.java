package com.longluo.studyplan.binary_search;

/**
 * 275. H 指数 II
 * <p>
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），
 * 一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * （其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 * <p>
 * 示例:
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 * 由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * 说明:
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 * <p>
 * 进阶：
 * 这是 H 指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 * <p>
 * https://leetcode-cn.com/problems/h-index-ii/
 */
public class Problem275_hIndex_ii {

    // BF time: O(n^2) space: O(1)
    // TimeOut
    public static int hIndex_bf(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        if (citations.length == 1) {
            return citations[0] < 1 ? 0 : 1;
        }

        int len = citations.length;
        int hIndex = 0;
        for (int i = 1; i <= len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (citations[j] >= i) {
                    cnt++;
                }
            }

            if (cnt >= i) {
                hIndex = Math.max(hIndex, i);
            }
        }

        return hIndex;
    }

    // BinarySearch time: O(logn) space: O(1)
    public static int hIndex_bs(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        if (citations.length == 1) {
            return citations[0] < 1 ? 0 : 1;
        }

        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int hIndex = n - mid;
            if (citations[mid] >= hIndex) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n - left;
    }

    // BinarySearch Opt time: O(logn) space: O(1)
    public static int hIndex_bs_opt(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        if (citations.length == 1) {
            return citations[0] < 1 ? 0 : 1;
        }

        int len = citations.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hIndex = len - mid;
            if (citations[mid] >= hIndex) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return citations[left] >= len - left ? len - left : 0;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + hIndex_bf(new int[]{0, 1, 3, 5, 6}));
        System.out.println("3 ?= " + hIndex_bs(new int[]{0, 1, 3, 5, 6}));
        System.out.println("2 ?= " + hIndex_bs_opt(new int[]{1, 2, 100}));
        System.out.println("1 ?= " + hIndex_bs_opt(new int[]{1, 2}));
        System.out.println("0 ?= " + hIndex_bs_opt(new int[]{0, 0}));
    }
}
