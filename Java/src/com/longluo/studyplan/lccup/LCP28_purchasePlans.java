package com.longluo.studyplan.lccup;

import java.util.Arrays;

/**
 * LCP 28. 采购方案
 * <p>
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，
 * 请问他有多少种采购方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * 输入：nums = [2,5,3,5], target = 6
 * 输出：1
 * 解释：预算内仅能购买 nums[0] 与 nums[2]。
 * <p>
 * 示例 2：
 * 输入：nums = [2,2,1,9], target = 10
 * 输出：4
 * <p>
 * 解释：符合预算的采购方案如下：
 * nums[0] + nums[1] = 4
 * nums[0] + nums[2] = 3
 * nums[1] + nums[2] = 3
 * nums[2] + nums[3] = 10
 * <p>
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], target <= 10^5
 * <p>
 * https://leetcode-cn.com/problems/4xy4Wx/
 */
public class LCP28_purchasePlans {

    public static int purchasePlans(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int MOD = 1000000007;
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] <= target) {
                    ans = ans % MOD + 1;
                }
            }
        }

        return ans;
    }

    public static int purchasePlans_1(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int MOD = 1000000007;
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            while (right > left && nums[left] + nums[right] > target) {
                right--;
            }

            for (int i = left; i < right; i++) {
                if (nums[i] + nums[right] <= target) {
                    ans = ans % MOD + 1;
                }
            }

            right--;
        }

        return ans;
    }

    public static int purchasePlans_2(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int MOD = 1000000007;
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right = binarySearch(nums, left, right, target - nums[left]);
            }

            for (int i = left; i < right; i++) {
                if (nums[i] + nums[right] <= target) {
                    ans = ans % MOD + 1;
                }
            }

            right--;
        }

        return ans;
    }

    public static int purchasePlans_3(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int MOD = 1000000007;
        int ans = 0;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            int remain = target - nums[i];
            if (remain < nums[0]) {
                continue;
            }

            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > remain) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            ans = ans % MOD + right + 1;
        }

        return ans;
    }

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low >= high) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println("1 ?= " + purchasePlans_1(new int[]{2, 5, 3, 5}, 6));
        System.out.println("4 ?= " + purchasePlans(new int[]{2, 2, 1, 9}, 10));
        System.out.println("4 ?= " + purchasePlans_1(new int[]{2, 2, 1, 9}, 10));
        System.out.println("4 ?= " + purchasePlans_2(new int[]{2, 2, 1, 9}, 10));
        System.out.println("4 ?= " + purchasePlans_3(new int[]{2, 2, 1, 9}, 10));
        System.out.println("1 ?= " + purchasePlans_3(new int[]{2, 5, 3, 5}, 6));
        System.out.println("5 ?= " + purchasePlans_3(new int[]{5, 3, 1, 2}, 7));
        System.out.println("0 ?= " + purchasePlans_1(new int[]{61055, 35718, 71455, 34429, 97039, 63942, 37037, 88911}, 17209));
        System.out.println("0 ?= " + purchasePlans_2(new int[]{61055, 35718, 71455, 34429, 97039, 63942, 37037, 88911}, 17209));
        System.out.println("0 ?= " + purchasePlans_3(new int[]{61055, 35718, 71455, 34429, 97039, 63942, 37037, 88911}, 17209));
    }
}
