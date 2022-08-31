package com.longluo.leetcode.array;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 * <p>
 * Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result
 * of a sequence of push and pop operations on an initially empty stack, or false otherwise.
 * <p>
 * Example 1:
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * Example 2:
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * <p>
 * Constraints:
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * All the elements of pushed are unique.
 * popped.length == pushed.length
 * popped is a permutation of pushed.
 * <p>
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class Problem946_validateStackSequences {

    // Stack BF time: O(n) space: O(n)
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || pushed.length <= 1) {
            return true;
        }

        int len = pushed.length;
        int pushIdx = 0;
        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();
        while (popIdx < len) {
            while (pushIdx < len && pushed[pushIdx] != popped[popIdx]) {
                stack.push(pushed[pushIdx]);
                pushIdx++;
            }

            while (pushIdx < len && popIdx < len && pushed[pushIdx] == popped[popIdx]) {
                pushIdx++;
                popIdx++;
            }

            while (!stack.empty() && popped[popIdx] == stack.peek()) {
                popIdx++;
                stack.pop();
            }

            if (pushIdx == len && popIdx < len && popped[popIdx] != stack.peek()) {
                break;
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }

    // Stack Opt time: O(n) space: O(n)
    public static boolean validateStackSequences_stack(int[] pushed, int[] popped) {
        if (popped == null || pushed.length <= 1) {
            return true;
        }

        int len = pushed.length;
        int popIdx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && popIdx < len && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }

        return popIdx == len;
    }

    // Fast time: O(n) space: O(1)
    public static boolean validateStackSequences_fast(int[] pushed, int[] popped) {
        int len = pushed.length;
        int size = 0;
        for (int i = 0, j = 0; i < len; i++) {
            pushed[size++] = pushed[i];
            while (size != 0 && pushed[size - 1] == popped[j]) {
                size--;
                j++;
            }
        }

        return size == 0;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println("false ?= " + validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
        System.out.println("true ?= " + validateStackSequences(new int[]{2, 3, 0, 1}, new int[]{0, 3, 2, 1}));
        System.out.println("true ?= " + validateStackSequences(new int[]{0, 2, 1}, new int[]{0, 1, 2}));

        System.out.println("true ?= " + validateStackSequences_stack(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println("false ?= " + validateStackSequences_stack(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
        System.out.println("false ?= " + validateStackSequences_fast(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
    }
}
