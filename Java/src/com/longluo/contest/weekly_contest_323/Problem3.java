package com.longluo.contest.weekly_contest_323;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-323
 */

/**
 * https://leetcode.cn/problems/design-memory-allocator/
 */
public class Problem3 {

    static class Allocator {
        int[] memory;
        int total;

        public Allocator(int n) {
            total = n;
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            int ans = -1;

            for (int i = 0; i < total; i++) {
                if (memory[i] > 0) {
                    continue;
                }

                if (i + size > total) {
                    break;
                }

                int idx = i;
                int cnt = 0;
                while (idx < total && memory[idx] == 0) {
                    idx++;
                    cnt++;

                    if (cnt == size) {
                        break;
                    }
                }

                if (cnt == size) {
                    ans = i;
                    Arrays.fill(memory, i, i + size, mID);
                    break;
                }
            }

            return ans;
        }

        public int free(int mID) {
            int ans = 0;

            for (int i = 0; i < total; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    ans++;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Allocator tst1 = new Allocator(7);
        System.out.println(tst1.allocate(3, 1));
        System.out.println(tst1.allocate(5, 2));
        System.out.println(tst1.free(1));
        System.out.println(tst1.free(3));
    }
}
