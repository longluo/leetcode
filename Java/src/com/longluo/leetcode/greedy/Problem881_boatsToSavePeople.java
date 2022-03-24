package com.longluo.leetcode.greedy;

import java.util.Arrays;

/**
 * 881. 救生艇
 * <p>
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * <p>
 * 示例 1：
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * <p>
 * 示例 2：
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * <p>
 * 示例 3：
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * 提示：
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 * <p>
 * https://leetcode-cn.com/problems/boats-to-save-people/
 */
public class Problem881_boatsToSavePeople {

    public static int numRescueBoats_bf(int[] people, int limit) {
        int len = people.length;
        if (len < 2) {
            return 1;
        }
        Arrays.sort(people);
        int ans = 0;
        int idx = 0;
        int right = len - 1;
        while (idx < len) {
            while (idx < len && people[idx] == 0) {
                idx++;
            }

            while (right > idx && people[right] > 0 && people[idx] + people[right] > limit) {
                right--;
            }

            if (right > idx && people[idx] + people[right] <= limit) {
                people[idx] = 0;
                people[right] = 0;
                idx++;
                right--;
                ans++;
            } else if (idx < len) {
                people[idx] = 0;
                idx++;
                ans++;
            }
        }

        return ans;
    }

    public static int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = len - 1;
        int ans = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            ans += 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numRescueBoats_bf(new int[]{1, 2}, 3));
        System.out.println("3 ?= " + numRescueBoats_bf(new int[]{3, 2, 2, 1}, 3));
        System.out.println("4 ?= " + numRescueBoats_bf(new int[]{3, 5, 3, 4}, 5));
        System.out.println("2 ?= " + numRescueBoats_bf(new int[]{5, 1, 4, 2}, 6));

        System.out.println("1 ?= " + numRescueBoats(new int[]{1, 2}, 3));
        System.out.println("3 ?= " + numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println("4 ?= " + numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println("2 ?= " + numRescueBoats(new int[]{5, 1, 4, 2}, 6));
    }
}
