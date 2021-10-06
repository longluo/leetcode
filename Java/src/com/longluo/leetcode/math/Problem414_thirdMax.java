package com.longluo.leetcode.math;

import java.util.*;

/**
 * 414. 第三大的数
 * <p>
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * <p>
 * https://leetcode-cn.com/problems/third-maximum-number/
 */
public class Problem414_thirdMax {

    public static int thirdMax(int[] nums) {
        Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() < 3) {
            return set.iterator().next().intValue();
        } else {
            Object[] array = set.toArray();
            return (int) array[2];
        }
    }

    public static int thirdMax_pq(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int n = nums.length;
        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                pq.offer(nums[i]);
            }

            return pq.peek();
        } else {
            for (int i = 0; i < 3; i++) {
                pq.offer(nums[i]);
            }

            for (int i = 3; i < n; i++) {
                int peek = pq.peek();
                if (peek < nums[i]) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + thirdMax(new int[]{3, 2, 1}));
        System.out.println("2 ?= " + thirdMax(new int[]{1, 2}));
        System.out.println("1 ?= " + thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println("1 ?= " + thirdMax(new int[]{-2147483648, 1, 1}));
    }
}
