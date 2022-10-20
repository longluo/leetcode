package com.longluo.leetcode.monostack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 769. 最多能完成排序的块
 * <p>
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 * <p>
 * 示例 1:
 * 输入: arr = [4,3,2,1,0]
 * 输出: 1
 * 解释:
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
 * <p>
 * 示例 2:
 * 输入: arr = [1,0,2,3,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
 * 然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
 * <p>
 * 提示:
 * n == arr.length
 * 1 <= n <= 10
 * 0 <= arr[i] < n
 * arr 中每个元素都 不同
 * <p>
 * https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */
public class Problem769_maxChunksToMakeSorted {

    // Stack time: O(n) space: O(n)
    public static int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int x : arr) {
            if (deque.isEmpty()) {
                deque.offerLast(x);
            } else if (x > deque.peekLast()) {
                deque.offerLast(x);
            } else {
                int top = deque.pollLast();
                while (!deque.isEmpty()) {
                    if (x > deque.peekLast()) {
                        break;
                    }
                    deque.removeLast();
                }

                deque.addLast(top);
            }
        }

        return deque.size();
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + maxChunksToSorted(new int[]{0}));
        System.out.println("2 ?= " + maxChunksToSorted(new int[]{0, 1}));
        System.out.println("1 ?= " + maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println("4 ?= " + maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println("2 ?= " + maxChunksToSorted(new int[]{0, 4, 5, 2, 1, 3}));
    }
}
