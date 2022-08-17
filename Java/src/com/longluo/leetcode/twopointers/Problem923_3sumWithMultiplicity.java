package com.longluo.leetcode.twopointers;

import java.util.*;

/**
 * 923. 三数之和的多种可能
 * <p>
 * 给定一个整数数组 arr ，以及一个整数 target 作为目标值，
 * 返回满足 i < j < k 且 arr[i] + arr[j] + arr[k] == target 的元组 i, j, k 的数量。
 * 由于结果会非常大，请返回 10^9 + 7 的模。
 * <p>
 * 示例 1：
 * 输入：arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * 输出：20
 * 解释：
 * 按值枚举(arr[i], arr[j], arr[k])：
 * (1, 2, 5) 出现 8 次；
 * (1, 3, 4) 出现 8 次；
 * (2, 2, 4) 出现 2 次；
 * (2, 3, 3) 出现 2 次。
 * <p>
 * 示例 2：
 * 输入：arr = [1,1,2,2,2,2], target = 5
 * 输出：12
 * 解释：
 * arr[i] = 1, arr[j] = arr[k] = 2 出现 12 次：
 * 我们从 [1,1] 中选择一个 1，有 2 种情况，
 * 从 [2,2,2,2] 中选出两个 2，有 6 种情况。
 * <p>
 * 提示：
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 * <p>
 * https://leetcode.com/problems/3sum-with-multiplicity/
 */
public class Problem923_3sumWithMultiplicity {

    // BF time: O(n^3) space: O(1)
    // TimeOut
    public static int threeSumMulti_bf(int[] arr, int target) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        //
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        ans++;
                        ans = ans % MOD;
                    }
                }
            }
        }

        return ans;
    }

    // BF Opt time: O(n^3) space: O(1)
    // TimeOut
    public static int threeSumMulti_bf_opt(int[] arr, int target) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;
        // Sort the array first.
        Arrays.sort(arr);
        // make sure there can be tuples
        if ((arr[len - 1] + arr[len - 2] + arr[len - 3] < target)
                || (arr[0] + arr[1] + arr[2] > target)) {
            return 0;
        }

        for (int i = 0; i < len - 2; i++) {
            if (arr[i] + arr[i + 1] + arr[i + 2] > target) {
                break;
            }

            if (arr[i] + arr[len - 1] + arr[len - 2] < target) {
                continue;
            }

            for (int j = i + 1; j < len - 1; j++) {
                if (arr[i] + arr[j] + arr[len - 1] < target) {
                    continue;
                }

                for (int k = j + 1; k < len; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        ans++;
                        ans = ans % MOD;
                    } else if (arr[i] + arr[j] + arr[k] > target) {
                        break;
                    }
                }
            }
        }

        return ans;
    }

    // Two Pointers time: O(n^2) space: O(1)
    public static int threeSumMulti_tp(int[] arr, int target) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int ans = 0;

        Arrays.sort(arr);

        if ((arr[len - 1] + arr[len - 2] + arr[len - 3] < target)
                || (arr[0] + arr[1] + arr[2] > target)) {
            return 0;
        }

        for (int i = 0; i < len; i++) {
            int left = i + 1;
            int right = len - 1;
            int newTarget = target - arr[i];
            while (left < right) {
                if (arr[left] + arr[right] < newTarget) {
                    left++;
                } else if (arr[left] + arr[right] > newTarget) {
                    right--;
                } else {
                    if (arr[left] < arr[right]) {
                        int leftCnt = 1;
                        int rightCnt = 1;
                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            left++;
                            leftCnt++;
                        }
                        while (left < right - 1 && arr[right - 1] == arr[right]) {
                            right--;
                            rightCnt++;
                        }
                        left++;
                        right--;
                        ans += leftCnt * rightCnt;
                        ans %= MOD;
                    } else if (arr[left] == arr[right]) {
                        ans += (right - left + 1) * (right - left) / 2;
                        ans %= MOD;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    // Count time: O(N + 101^2) space: O(101)
    public static int threeSumMulti_count(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        int[] count = new int[101];
        int minValue = Integer.MAX_VALUE;
        int maxValue = -1;
        for (int num : arr) {
            count[num]++;
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        // x == y == z
        if (target % 3 == 0 && count[target / 3] >= 3) {
            ans += (long) count[target / 3] * (count[target / 3] - 1) * (count[target / 3] - 2) / (3 * 2);
            ans %= MOD;
        }

        // x < y < z
        for (int i = minValue; i <= maxValue - 2; i++) {
            if (count[i] <= 0) {
                continue;
            }

            for (int j = i + 1; j <= maxValue - 1; j++) {
                if (count[j] <= 0) {
                    continue;
                }

                for (int k = j + 1; k <= maxValue; k++) {
                    if (i + j + k > target) {
                        break;
                    } else if (i + j + k == target) {
                        ans += (long) count[i] * count[j] * count[k];
                        ans %= MOD;
                    }
                }
            }
        }

        // x == y < z
        for (int i = minValue; i <= maxValue - 1; i++) {
            if (count[i] < 2) {
                continue;
            }

            for (int j = i + 1; j <= maxValue; j++) {
                if (i * 2 + j > target) {
                    break;
                } else if (i * 2 + j == target) {
                    ans += count[i] * (count[i] - 1) / 2 * count[j];
                    ans = ans % MOD;
                }
            }
        }

        // x < y == z
        for (int i = minValue; i <= maxValue - 1; i++) {
            if (count[i] < 1) {
                continue;
            }

            for (int j = i + 1; j <= maxValue; j++) {
                if (i + j * 2 > target) {
                    break;
                } else if (i + j * 2 == target) {
                    ans += (long) count[i] * count[j] * (count[j] - 1) / 2;
                    ans = ans % MOD;
                }
            }
        }

        return (int) ans;
    }

    // Count Opt time: O(N + 101^2) space: O(101)
    public static int threeSumMulti(int[] arr, int target) {
        int MOD = 1_000_000_007;
        long[] count = new long[101];
        for (int x : arr) {
            count[x]++;
        }

        long ans = 0;

        // x < y < z
        for (int x = 0; x <= 100; x++) {
            for (int y = x + 1; y <= 100; y++) {
                int z = target - x - y;
                if (y < z && z <= 100) {
                    ans += count[x] * count[y] * count[z];
                    ans %= MOD;
                }
            }
        }

        // x == y < z
        for (int x = 0; x <= 100; ++x) {
            int z = target - 2 * x;
            if (x < z && z <= 100) {
                ans += count[x] * (count[x] - 1) / 2 * count[z];
                ans %= MOD;
            }
        }

        // x < y == z
        for (int x = 0; x <= 100; x++) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / (3 * 2);
                ans %= MOD;
            }
        }

        return (int) ans;
    }

    // TreeMap time: O(N + 101^2) space: O(101)
    // AC
    public static int threeSumMulti_treeMap(int[] arr, int target) {
        int MOD = 1_000_000_007;

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long ans = 0;

        // x < y < z
        for (int x = 0; x <= 100; x++) {
            if (!map.containsKey(x)) {
                continue;
            }

            for (int y = x + 1; y <= 100; y++) {
                if (!map.containsKey(y)) {
                    continue;
                }

                int z = target - x - y;
                if (map.containsKey(z) && y < z && z <= 100) {
                    ans += (long) map.get(x) * map.get(y) * map.get(z);
                    ans %= MOD;
                }
            }
        }

        // x == y < z
        for (int x = 0; x <= 100; ++x) {
            if (!map.containsKey(x)) {
                continue;
            }

            int z = target - 2 * x;
            if (map.containsKey(z) && x < z && z <= 100) {
                ans += (long) map.get(x) * (map.get(x) - 1) / 2 * map.get(z);
                ans %= MOD;
            }
        }

        // x < y == z
        for (int x = 0; x <= 100; x++) {
            if (!map.containsKey(x)) {
                continue;
            }

            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (map.containsKey(y) && x < y && y <= 100) {
                    ans += (long) map.get(x) * map.get(y) * (map.get(y) - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (map.containsKey(x) && 0 <= x && x <= 100) {
                ans += (long) map.get(x) * (map.get(x) - 1) * (map.get(x) - 2) / (3 * 2);
                ans %= MOD;
            }
        }

        return (int) ans;
    }

    // DP time: O(N + 101^2) space: O(101)
    public static int threeSumMulti_dp(int[] arr, int target) {
        int MOD = 1_000_000_007;
        int len = arr.length;
        int[][][] dp = new int[len + 1][4][target + 1];

        for (int i = 0; i <= len; i++) {
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 0; k <= target; k++) {
                    if (k >= arr[i - 1]) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k - arr[i - 1]]) % MOD;
                    }

                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k]) % MOD;
                }
            }
        }

        return dp[len][3][target];
    }

    public static void main(String[] args) {
        System.out.println("12 ?= " + threeSumMulti_bf(new int[]{1, 1, 2, 2, 2, 2}, 5));
        System.out.println("12 ?= " + threeSumMulti_bf_opt(new int[]{1, 1, 2, 2, 2, 2}, 5));
        System.out.println("20 ?= " + threeSumMulti_tp(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println("10 ?= " + threeSumMulti_count(new int[]{0}, 0));
        System.out.println("20 ?= " + threeSumMulti_count(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
        System.out.println("10 ?= " + threeSumMulti_count(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("10 ?= " + threeSumMulti(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("10 ?= " + threeSumMulti_treeMap(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println("1 ?= " + threeSumMulti_dp(new int[]{0, 0, 0}, 0));

        int mod = 1_000_000_007;
        System.out.println(mod);
    }
}
