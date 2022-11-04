package com.longluo.leetcode.BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 754. Reach a Number
 * <p>
 * Medium
 * <p>
 * You are standing at position 0 on an infinite number line. There is a destination at position target.
 * <p>
 * You can make some number of moves numMoves so that:
 * <p>
 * On each move, you can either go left or right.
 * During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
 * Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.
 * <p>
 * Example 1:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to -1 (2 steps).
 * On the 3rd move, we step from -1 to 2 (3 steps).
 * <p>
 * Example 2:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to 3 (2 steps).
 * <p>
 * Constraints:
 * -10^9 <= target <= 10^9
 * target != 0
 * <p>
 * https://leetcode.com/problems/reach-a-number/
 */
public class Problem754_reachANumber {

    // BFS time: O(logn) space: O(n)
    // TLE
    public static int reachNumber_bfs(int target) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(0L);

        int steps = 0;
        int numMoves = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long curPos = queue.poll();
                if (curPos == target) {
                    return steps;
                }

                queue.offer(curPos + numMoves);
                queue.offer(curPos - numMoves);
            }

            numMoves++;
            steps++;
        }

        return steps;
    }

    // Math time: O(sqrt(n)) space: O(1)
    public static int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        int sum = 0;
        while (sum < target || (sum - target) % 2 != 0) {
            k++;
            sum += k;
        }

        return k;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + reachNumber_bfs(2));
        System.out.println("2 ?= " + reachNumber_bfs(3));
        System.out.println("5 ?= " + reachNumber_bfs(5));
        System.out.println("3 ?= " + reachNumber_bfs(6));
        System.out.println("5 ?= " + reachNumber_bfs(7));

        System.out.println("3 ?= " + reachNumber(2));
        System.out.println("2 ?= " + reachNumber(3));
        System.out.println("5 ?= " + reachNumber(5));
        System.out.println("5 ?= " + reachNumber(7));
        System.out.println("4 ?= " + reachNumber(8));
    }
}
