package com.longluo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class Problem1700_numberOfStudentsUnableToEatLunch {

    // Stack + Queue time: O(n) space: O(n)
    public static int countStudents(int[] students, int[] sandwiches) {
        int len = sandwiches.length;

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int x : students) {
            queue.offer(x);
        }

        Stack<Integer> stk = new Stack<Integer>();
        for (int i = len - 1; i >= 0; i--) {
            stk.push(sandwiches[i]);
        }

        while (stk.size() > 0) {
            int cnt = 0;
            while (stk.peek() != queue.peek()) {
                int head = queue.pollFirst();
                queue.offer(head);
                cnt++;
                if (cnt == queue.size()) {
                    return queue.size();
                }
            }

            if (stk.peek() == queue.peek()) {
                stk.pop();
                queue.poll();
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println("3 ?= " + countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
