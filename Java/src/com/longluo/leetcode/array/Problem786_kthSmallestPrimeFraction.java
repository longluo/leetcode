package com.longluo.leetcode.array;

import java.util.*;

/**
 * 786. 第 K 个最小的素数分数
 * <p>
 * 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。
 * 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
 * 那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。
 * <p>
 * 示例 1：
 * 输入：arr = [1,2,3,5], k = 3
 * 输出：[2,5]
 * 解释：已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
 * 很明显第三个最小的分数是 2/5
 * <p>
 * 示例 2：
 * 输入：arr = [1,7], k = 1
 * 输出：[1,7]
 * <p>
 * 提示：
 * 2 <= arr.length <= 1000
 * 1 <= arr[i] <= 3 * 10^4
 * arr[0] == 1
 * arr[i] 是一个 素数 ，i > 0
 * arr 中的所有数字 互不相同 ，且按 严格递增 排序
 * 1 <= k <= arr.length * (arr.length - 1) / 2
 * <p>
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 */
public class Problem786_kthSmallestPrimeFraction {

    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        List<int[]> fracList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                fracList.add(new int[]{arr[i], arr[j]});
            }
        }

        Collections.sort(fracList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o2[1] - o1[1] * o2[0];
            }
        });

        return fracList.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println("[2, 5] ?= " + Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 2, 3, 5}, 3)));
        System.out.println("[1, 7] ?= " + Arrays.toString(kthSmallestPrimeFraction(new int[]{1, 7}, 1)));
    }
}
