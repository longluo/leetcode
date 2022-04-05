package com.longluo.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 954. 二倍数对数组
 * <p>
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
 * 都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * <p>
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 */
public class Problem954_arrayOfDoubledPairs {

    // Sort + Hash O(n) O(n)
    public static boolean canReorderDoubled_sort(int[] arr) {
        int len = arr.length;
        int pairs = len / 2;
        Arrays.sort(arr);
        if (len == 2 && (arr[1] == 2 * arr[0] || arr[0] == 2 * arr[1])) {
            return true;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            int num = arr[i];
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (num == 0 && freq.getOrDefault(num, 0) >= 2) {
                freq.put(num, freq.getOrDefault(num, 0) - 2);
                pairs--;
            } else if (num != 0 && freq.getOrDefault(2 * num, 0) > 0) {
                freq.put(num, freq.getOrDefault(num, 0) - 1);
                freq.put(2 * num, freq.getOrDefault(2 * num, 0) - 1);
                pairs--;
            } else if (num != 0 && num % 2 == 0 && freq.getOrDefault(num / 2, 0) > 0) {
                freq.put(num, freq.getOrDefault(num, 0) - 1);
                freq.put(num / 2, freq.getOrDefault(num / 2, 0) - 1);
                pairs--;
            }
        }

        return pairs == 0;
    }

    public static void main(String[] args) {
        canReorderDoubled_sort(new int[]{-33, 0});
        canReorderDoubled_sort(new int[]{2, 4, 0, 0, 8, 1});
        canReorderDoubled_sort(new int[]{3, 1, 3, 6});
        canReorderDoubled_sort(new int[]{2, 1, 2, 6});
        canReorderDoubled_sort(new int[]{3, 1, 3, 6});
    }
}
