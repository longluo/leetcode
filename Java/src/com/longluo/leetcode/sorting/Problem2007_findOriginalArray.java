package com.longluo.leetcode.sorting;

import java.util.*;

/**
 * 2007. 从双倍数组中还原原数组
 * <p>
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 * <p>
 * 示例 1：
 * 输入：changed = [1,3,4,2,6,8]
 * 输出：[1,3,4]
 * 解释：一个可能的 original 数组为 [1,3,4] :
 * - 将 1 乘以 2 ，得到 1 * 2 = 2 。
 * - 将 3 乘以 2 ，得到 3 * 2 = 6 。
 * - 将 4 乘以 2 ，得到 4 * 2 = 8 。
 * 其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
 * <p>
 * 示例 2：
 * 输入：changed = [6,3,0,1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * 示例 3：
 * 输入：changed = [1]
 * 输出：[]
 * 解释：changed 不是一个双倍数组。
 * <p>
 * 提示：
 * 1 <= changed.length <= 10^5
 * 0 <= changed[i] <= 10^5
 * <p>
 * https://leetcode.cn/problems/find-original-array-from-doubled-array/
 */
public class Problem2007_findOriginalArray {

    // Sort + HashMap time: O(nlogn) space: O(n)
    public static int[] findOriginalArray(int[] changed) {
        int len = changed.length;
        if (len % 2 == 1) {
            return new int[]{};
        }

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int[] ans = new int[len / 2];
        for (int i = 0, j = 0; j < len; j++) {
            int freq = map.getOrDefault(changed[j], 0);
            if (freq > 0) {
                ans[i++] = changed[j];
                map.put(changed[j], freq - 1);
                int doubled = 2 * changed[j];
                if (map.getOrDefault(doubled, 0) >= 1) {
                    map.put(doubled, map.get(doubled) - 1);
                } else {
                    return new int[]{};
                }
            }
        }

        return ans;
    }

    // Sort + Queue time: O(nlogn) space: O(n)
    public static int[] findOriginalArray_queue(int[] changed) {
        int len = changed.length;
        if (len % 2 == 1) {
            return new int[]{};
        }

        Arrays.sort(changed);

        Queue<Integer> queue = new ArrayDeque<>();

        int[] ans = new int[len / 2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (queue.isEmpty()) {
                queue.offer(changed[i]);
            } else if (queue.peek() * 2 == changed[i]) {
                ans[idx++] = queue.poll();
            } else {
                queue.offer(changed[i]);
            }
        }

        return queue.isEmpty() ? ans : new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("[1, 3, 4] ?= " + Arrays.toString(findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println("[] ?= " + Arrays.toString(findOriginalArray(new int[]{5, 0})));

        System.out.println("[1, 3, 4] ?= " + Arrays.toString(findOriginalArray_queue(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println("[] ?= " + Arrays.toString(findOriginalArray_queue(new int[]{5, 0})));
    }
}
