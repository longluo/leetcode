package com.longluo.top100;

import java.util.*;

/**
 * 128. 最长连续序列
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 提示：
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class Problem128_longestConsecutiveSequence {

    // BF time: O(n^2) space: O(logn)
    // Timeout
    public static int longestConsecutive_bf(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int ans = 1;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int last = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == last + 1) {
                    ans = Math.max(ans, nums[j] - nums[i] + 1);
                    last = nums[j];
                } else if (nums[j] > last + 1) {
                    break;
                }
            }
        }

        return ans;
    }

    // HashMap time: O(nlogn) space: O(n)
    public static int longestConsecutive_hashmap(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int ans = 1;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x + 1) || map.containsKey(x - 1)) {
                int tempLen = Math.max(map.getOrDefault(x + 1, 1) + 1, map.getOrDefault(x - 1, 1) + 1);
                map.put(x, tempLen);
                ans = Math.max(ans, tempLen);
            } else {
                map.put(x, 1);
            }
        }

        return ans;
    }

    // Hash time: O(n) space: O(n)
    public static int longestConsecutive_hash(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int curr = x;
                int currLen = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    currLen++;
                }

                ans = Math.max(ans, currLen);
            }
        }

        return ans;
    }

    // UnionFind time: O(n) space: O(n)
    public static int longestConsecutive_uf(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }

            if (map.containsKey(nums[i] - 1)) {
                uf.union(i, map.get(nums[i] - 1));
            }

            if (map.containsKey(nums[i] + 1)) {
                uf.union(i, map.get(nums[i] + 1));
            }

            map.put(nums[i], i);
        }

        return uf.getMaxConnectSize();
    }

    // Union Find
    static class UnionFind {
        int count;
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

        public int getMaxConnectSize() {
            int maxSize = 0;
            for (int i = 0; i < parent.length; i++) {
                if (i == parent[i]) {
                    maxSize = Math.max(maxSize, size[i]);
                }
            }

            return maxSize;
        }
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + longestConsecutive_bf(new int[]{0}));
        System.out.println("1 ?= " + longestConsecutive_bf(new int[]{0, 0}));
        System.out.println("3 ?= " + longestConsecutive_bf(new int[]{1, 2, 0, 1}));
        System.out.println("4 ?= " + longestConsecutive_bf(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("9 ?= " + longestConsecutive_bf(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

        System.out.println("1 ?= " + longestConsecutive_hashmap(new int[]{0}));
        System.out.println("1 ?= " + longestConsecutive_hashmap(new int[]{0, 0}));
        System.out.println("3 ?= " + longestConsecutive_hashmap(new int[]{1, 2, 0, 1}));

        System.out.println("4 ?= " + longestConsecutive_hash(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println("9 ?= " + longestConsecutive_hash(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println("9 ?= " + longestConsecutive_hash(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

        System.out.println("4 ?= " + longestConsecutive_uf(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
