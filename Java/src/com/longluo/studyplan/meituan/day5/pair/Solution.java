package com.longluo.studyplan.meituan.day5.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * meituan-010. 小团的默契游戏
 * <p>
 * 小团从某不知名论坛上突然得到了一个测试默契度的游戏，想和小美玩一次来检验两人的默契程度。游戏规则十分简单，
 * 首先给出一个长度为 n 的序列，最大值不超过 m 。
 * 小团和小美各自选择一个 [1,m] 之间的整数，设小美选择的是 l ，小团选择的是 r ，我们认为两个人是默契的需要满足以下条件:
 * l 小于等于 r 。
 * 对于序列中的元素 x ，如果 0<x<l ，或 r<x<m+1 ,则 x 按其顺序保留下来，要求保留下来的子序列单调不下降。
 * 小团为了表现出与小美最大的默契，因此事先做了功课，他想知道能够使得两人默契的二元组 <l,r> 一共有多少种。
 * 我们称一个序列 A 为单调不下降的，当且仅当对于任意的 i>j ，满足 A[i]>=A[j] 。
 * <p>
 * 格式：
 * 输入：
 * - 输入第一行包含两个正整数 m 和 n ，表示序列元素的最大值和序列的长度。
 * - 输入第二行包含 n 个正整数，表示该序列。
 * 输出：
 * - 输出仅包含一个整数，表示能使得两人默契的二元组数量。
 * <p>
 * 示例：
 * 输入：
 * 5 5
 * 4 1 4 1 2
 * 输出：10
 * <p>
 * 提示：
 * 1 <= n, m <= 100000
 * <p>
 * https://leetcode-cn.com/problems/yqj8Su/
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxValue = sc.nextInt();
        int len = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i <= maxValue; i++) {
            int[] onePair = new int[2];
            onePair[0] = i;
            for (int j = i; j <= maxValue; j++) {
                onePair[1] = j;
                if (check(nums, i, j)) {
                    res.add(onePair);
                }
            }
        }

        System.out.println(res.size());
    }

    private static boolean check(int[] arr, int left, int right) {
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < left || arr[i] > right) {
                if (arr[i] < pre) {
                    return false;
                }

                pre = arr[i];
            }
        }

        return true;
    }
}
