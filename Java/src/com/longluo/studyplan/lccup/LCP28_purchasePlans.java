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

    public static void main(String[] args) {
        System.out.println("1 ?= " + purchasePlans(new int[]{2, 5, 3, 5}, 6));
        System.out.println("4 ?= " + purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }
}
