package com.longluo.leetcode.UnionFind;

/**
 * 952. 按公因数计算最大组件大小
 * <p>
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 * <p>
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 * <p>
 * 示例 1：
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 * <p>
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^5
 * nums 中所有值都 不同
 * <p>
 * https://leetcode.cn/problems/largest-component-size-by-common-factor/
 */
public class Problem952_largestComponentSizeByCommonFactor {

    // UnionFind time: O(n^2) space: O(n)
    // TLE
    public static int largestComponentSize(int[] nums) {
        int len = nums.length;

        UnionFind uf = new UnionFind(len);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && gcd(nums[i], nums[j]) > 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.getMaxConnectSize();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static class UnionFind {
        private int count;

        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            this.count = n;
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

            count--;
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }

        public int count() {
            return this.count;
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
        System.out.println("4 ?= " + largestComponentSize(new int[]{4, 6, 15, 35}));
        System.out.println("2 ?= " + largestComponentSize(new int[]{20, 50, 9, 63}));
    }
}
