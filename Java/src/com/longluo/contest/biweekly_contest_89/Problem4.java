package com.longluo.contest.biweekly_contest_89;

public class Problem4 {

    public int componentValue(int[] nums, int[][] edges) {
        if (edges == null || edges.length == 0 || nums.length <= 1) {
            return 0;
        }

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        return 0;
    }

    static class UnionFind {
        int[] parents;
        int[] weights;
        int count;

        UnionFind(int[] nums) {
            int n = nums.length;

            parents = new int[n];
            weights = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                count++;
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }

            return x;
        }

        boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

//            if (size[rootX] > size[rootY]) {
//                parents[rootY] = rootX;
//                size[rootX] += size[rootY];
//            } else {
//                parents[rootX] = rootY;
//                size[rootY] += size[rootX];
//            }

            count--;
        }

        int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {

    }
}
