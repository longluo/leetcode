package com.longluo.lcci;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 16.11. 跳水板
 * <p>
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * <p>
 * 提示：
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * https://leetcode.cn/problems/diving-board-lcci/
 */
public class Lcci_16_11_divingBoard {

    // BF time: O(nlogn) space: O(n)
    public static int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            int length = i * shorter + (k - i) * longer;
            set.add(length);
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (int x : set) {
            ans[idx] = x;
            idx++;
        }

        Arrays.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 4, 5, 6] ?= " + Arrays.toString(divingBoard(1, 2, 3)));
        System.out.println("[] ?= " + Arrays.toString(divingBoard(1, 1, 0)));
    }
}
