package com.longluo.leetcode.math;

/**
 * 390. 消除游戏
 * <p>
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <p>
 * 示例 1：
 * 输入：n = 9
 * 输出：6
 * 解释：
 * arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * arr = [2, 4, 6, 8]
 * arr = [2, 6]
 * arr = [6]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode-cn.com/problems/elimination-game/
 */
public class Problem390_eliminationGame {

    public static int lastRemaining(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] nums = new int[n];
        boolean flag = true;
        int cnt = 0;
        int ans = -1;
        int remain = n;
        while (remain > 1) {
            if (flag) {
                int idx = 0;
                while (nums[idx] != 0) {
                    idx++;
                }
                nums[idx] = -1;
                remain--;
                if (remain == 1) {
                    break;
                }
                for (int i = idx + 1; i < n; i++) {
                    if (nums[i] == 0) {
                        cnt++;
                        if (cnt == 2) {
                            nums[i] = -1;
                            remain--;
                            cnt = 0;
                        }
                    }
                }
                flag = !flag;
            } else {
                int idx = n - 1;
                while (nums[idx] != 0) {
                    idx--;
                }
                nums[idx] = -1;
                remain--;
                if (remain == 1) {
                    break;
                }
                cnt = 0;
                for (int i = idx - 1; i >= 0; i--) {
                    if (nums[i] == 0) {
                        cnt++;
                        if (cnt == 2) {
                            nums[i] = -1;
                            remain--;
                            cnt = 0;
                        }
                    }
                }
                flag = !flag;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                ans = i + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + lastRemaining(1));
        System.out.println("2 ?= " + lastRemaining(2));
        System.out.println("2 ?= " + lastRemaining(3));
        System.out.println("2 ?= " + lastRemaining(4));
        System.out.println("2 ?= " + lastRemaining(5));
        System.out.println("4 ?= " + lastRemaining(6));
        System.out.println("4 ?= " + lastRemaining(7));
        System.out.println("6 ?= " + lastRemaining(8));
        System.out.println("6 ?= " + lastRemaining(9));
        System.out.println("8 ?= " + lastRemaining(10));
        System.out.println("8 ?= " + lastRemaining(11));
        System.out.println("8 ?= " + lastRemaining(12));
        System.out.println("8 ?= " + lastRemaining(13));
        System.out.println("8 ?= " + lastRemaining(14));
        System.out.println("8 ?= " + lastRemaining(15));
        System.out.println("14 ?= " + lastRemaining(16));
    }
}
