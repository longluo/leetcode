package com.longluo.leetcode.array;

import java.util.Arrays;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * <p>
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 * <p>
 * 示例 1：
 * 输入：salary = [4000,3000,1000,2000]
 * 输出：2500.00000
 * 解释：最低工资和最高工资分别是 1000 和 4000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 * <p>
 * 示例 2：
 * 输入：salary = [1000,2000,3000]
 * 输出：2000.00000
 * 解释：最低工资和最高工资分别是 1000 和 3000 。
 * 去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 * <p>
 * 示例 3：
 * 输入：salary = [6000,5000,4000,3000,2000,1000]
 * 输出：3500.00000
 * <p>
 * 示例 4：
 * 输入：salary = [8000,9000,2000,3000,6000,1000]
 * 输出：4750.00000
 * <p>
 * 提示：
 * 3 <= salary.length <= 100
 * 10^3 <= salary[i] <= 10^6
 * salary[i] 是唯一的。
 * 与真实值误差在 10^-5 以内的结果都将视为正确答案。
 * <p>
 * https://leetcode.cn/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class Problem1491_averageSalary {

    // Simulate time: O(n) space: O(1)
    public static double average(int[] salary) {
        int sum = 0;

        int len = salary.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : salary) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        sum -= max;
        sum -= min;

        return (double) sum / (len - 2);
    }

    // API time: O(n) space: O(1)
    public static double average_api(int[] salary) {
        int sum = Arrays.stream(salary).sum();

        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();

        return (double) (sum - max - min)/ (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println("2500.0 ?= " + average(new int[]{4000, 3000, 1000, 2000}));
        System.out.println("2500.0 ?= " + average_api(new int[]{4000, 3000, 1000, 2000}));
    }
}
