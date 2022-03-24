package com.longluo.leetcode.array;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 * <p>
 * Easy
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 * <p>
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Problem350_intersectionOfTwoArrays_ii {

    public static int[] intersect_sort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[Math.min(len1, len2)];
        int idx = 0;
        int p = 0;
        int q = 0;
        while (p < len1 && q < len2) {
            if (nums1[p] == nums2[q]) {
                ans[idx++] = nums1[p];
                p++;
                q++;
            } else if (nums1[p] < nums2[q]) {
                p++;
            } else {
                q++;
            }
        }

        return Arrays.copyOfRange(ans, 0, idx);
    }

    public static int[] intersect_sort_hash(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect_sort_hash(nums2, nums1);
        }
        List<Integer> ans = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            numFreq.put(nums1[i], numFreq.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < len2; i++) {
            if (numFreq.containsKey(nums2[i])) {
                ans.add(nums2[i]);
                int freq = numFreq.get(nums2[i]);
                if (freq > 1) {
                    numFreq.put(nums2[i], freq - 1);
                } else {
                    numFreq.remove(nums2[i]);
                }
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
