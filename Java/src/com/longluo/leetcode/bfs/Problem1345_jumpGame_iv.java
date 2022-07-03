package com.longluo.leetcode.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. 跳跃游戏 IV
 * <p>
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标：
 * <p>
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 * <p>
 * 示例 1：
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 * <p>
 * 示例 2：
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 * <p>
 * 示例 3：
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 * <p>
 * 示例 4：
 * 输入：arr = [6,1,9]
 * 输出：2
 * <p>
 * 示例 5：
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * 通过次数9,078提交次数22,33
 * <p>
 * https://leetcode.com/problems/jump-game-iv/
 */
public class Problem1345_jumpGame_iv {

    // TODO: 2022/6/14
    public static int minJumps(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            map.put(i, arr[i]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, arr[0]});

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + minJumps(new int[]{7}));
        System.out.println("2 ?= " + minJumps(new int[]{6, 1, 9}));
        System.out.println("1 ?= " + minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        System.out.println("3 ?= " + minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
        System.out.println("3 ?= " + minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }
}
