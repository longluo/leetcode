package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 * <p>
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * <p>
 * 示例 3：
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * <p>
 * 提示：
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * <p>
 * <p>
 * https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
public class Problem1640_checkArrayFormationThroughConcatenation {

    // HashMap time: O(n) space: O(n)
    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pieces.length; i++) {
            int[] p = pieces[i];
            map.put(p[0], i);
        }

        int idx = 0;
        int len = arr.length;

        while (idx < len) {
            if (map.containsKey(arr[idx])) {
                int[] p = pieces[map.get(arr[idx])];
                for (int j = 0; j < p.length; j++) {
                    if (idx < len && arr[idx] != p[j]) {
                        return false;
                    }

                    idx++;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        System.out.println("false ?= " + canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
    }
}
