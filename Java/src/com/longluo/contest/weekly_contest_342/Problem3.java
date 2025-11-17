package com.longluo.contest.weekly_contest_342;

import java.util.*;

/**
 * https://leetcode.cn/contest/weekly-contest-342
 */
public class Problem3 {

    // TLE
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        List<Integer> sorted = new ArrayList<>();

        int left = 0;
        int right = k;

        for (int i = left; i < right; i++) {
            sorted.add(nums[i]);
        }

        Collections.sort(sorted);

        int idx = 0;

        ans[idx] = sorted.get(x - 1) >= 0 ? 0 : sorted.get(x - 1);
        idx++;

        while (left < right && right < n) {
            sorted.remove(Integer.valueOf(nums[left]));
            left++;
            sorted.add(nums[right]);
            right++;

            Collections.sort(sorted);
            ans[idx] = sorted.get(x - 1) >= 0 ? 0 : sorted.get(x - 1);
            idx++;
        }

        return ans;
    }

    public static int[] getSubarrayBeauty_opt(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        List<Integer> sorted = new ArrayList<>();

        int left = 0;
        int right = k;

        for (int i = left; i < right; i++) {
            if (nums[i] < 0) {
                sorted.add(nums[i]);
            }
        }

        Collections.sort(sorted);

        int idx = 0;
        int prev = sorted.size() >= x ? sorted.get(x - 1) : 0;
        ans[idx] = prev;
        idx++;

        while (left < right && right < n) {
            if (nums[left] < prev) {
                sorted.remove(Integer.valueOf(nums[left]));

                if (nums[right] < 0) {
                    sorted.add(nums[right]);
                }

                Collections.sort(sorted);
            }

            left++;
            right++;

            ans[idx] = sorted.size() >= x ? sorted.get(x - 1) : 0;
            idx++;
        }

        return ans;
    }

    public static int[] getSubarrayBeauty_pq(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < k; i++) {
            if (nums[i] < 0) {
                pq.offer(nums[i]);
            }
        }

        int idx = 0;

        while (pq.size() > x) {
            pq.poll();
        }

        ans[idx] = pq.size() == x ? pq.peek() : 0;
        idx++;

        int left = 0;
        int right = k;

        while (left < right && right < n) {


            left++;
            right++;

            ans[idx] = pq.size() == x ? pq.peek() : 0;
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[-1, -2, -2] ?= " + Arrays.toString(getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2)));
        System.out.println("[-3, 0, -3, -3, -3] ?= " + Arrays.toString(getSubarrayBeauty(new int[]{-3, 1, 2, -3, 0, -3}, 2, 1)));

        System.out.println("[-1, -2, -2] ?= " + Arrays.toString(getSubarrayBeauty_opt(new int[]{1, -1, -3, -2, 3}, 3, 2)));
        System.out.println("[-3, 0, -3, -3, -3] ?= " + Arrays.toString(getSubarrayBeauty_opt(new int[]{-3, 1, 2, -3, 0, -3}, 2, 1)));
    }
}