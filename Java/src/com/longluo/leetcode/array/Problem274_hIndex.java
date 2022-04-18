package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 274. H 指数
 * <p>
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h指数的定义：h代表“高引用次数”（high citations），
 * 一名科研人员的h指数是指他（她）的 （N篇论文中）总共有h篇论文分别被引用了至少h次。
 * 且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * <p>
 * 示例：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 * 由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * <p>
 * <p>
 * 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。
 *
 * https://leetcode-cn.com/problems/h-index/
 */
public class Problem274_hIndex {

    // BF time: O(n^2) space: O(1)
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int len = citations.length;
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (citations[j] >= i) {
                    cnt++;
                }
            }
            if (cnt >= i) {
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }

    // Sort time: O(n) space: O(n)
    public static int hIndex_sort(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        int idx = citations.length - 1;
        // > not >= because hIndex will +1
        while (idx >= 0 && citations[idx] > hIndex) {
            idx--;
            hIndex++;
        }

        return hIndex;
    }

    // Count time: O(n) space: O(n)
    public static int hIndex_count(int[] citations) {
        int len = citations.length;
        int[] counter = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (citations[i] > len) {
                counter[len]++;
            } else {
                counter[citations[i]]++;
            }
        }

        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += counter[i];
            if (total >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println("3 ?= " + hIndex_sort(new int[]{3, 0, 6, 1, 5}));
        System.out.println("3 ?= " + hIndex_count(new int[]{3, 0, 6, 1, 5}));
        System.out.println("1 ?= " + hIndex(new int[]{1}));
        System.out.println("1 ?= " + hIndex_count(new int[]{1}));
    }
}
