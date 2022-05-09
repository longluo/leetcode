package com.longluo.top100;

import java.util.*;

/**
 * 155. 最小栈
 * <p>
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * <p>
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * https://leetcode-cn.com/problems/min-stack/
 */
public class Problem155_minStack {

    // time: O(nlogn) space: O(2n)
    static class MinStack {
        Deque<Integer> stack;
        List<Integer> numList;

        public MinStack() {
            stack = new ArrayDeque<>();
            numList = new ArrayList<>();
        }

        // time: O(nlogn)
        public void push(int val) {
            stack.push(val);
            numList.add(val);
            Collections.sort(numList);
        }

        // time: O(n)
        public void pop() {
            int val = stack.pop();
            for (int i = 0; i < numList.size(); i++) {
                if (numList.get(i) == val) {
                    numList.remove(i);
                    break;
                }
            }

            Collections.sort(numList);
        }

        // time: O(1)
        public int top() {
            return stack.peek();
        }

        // time: O(1)
        public int getMin() {
            return numList.get(0);
        }
    }

    // Two Stacks
    static class MinStack_2Stack {
        Stack<Integer> numStack;
        Stack<Integer> minStack;

        // time: O(1)
        public MinStack_2Stack() {
            numStack = new Stack<>();
            minStack = new Stack<>();
        }

        // time: O(1)
        public void push(int val) {
            numStack.push(val);
            if (!minStack.empty()) {
                int top = minStack.peek();
                if (val < top) {
                    minStack.push(val);
                }
            } else {
                minStack.push(val);
            }
        }

        // time: O(1)
        public void pop() {
            int pop = numStack.pop();
            if (pop == minStack.peek()) {
                minStack.pop();
            }
        }

        // time: O(1)
        public int top() {
            return numStack.peek();
        }

        // time: O(1)
        public int getMin() {
            return minStack.peek();
        }
    }

    // One Stack min
    static class MinStack_min {
        Stack<Integer> stack;
        int min = Integer.MAX_VALUE;

        // time: O(1)
        public MinStack_min() {
            stack = new Stack<>();
        }

        // time: O(1)
        public void push(int val) {
            if (val <= min) {
                stack.push(min);
                min = val;
            }

            stack.push(val);
        }

        // time: O(1)
        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        // time: O(1)
        public int top() {
            return stack.peek();
        }

        // time: O(1)
        public int getMin() {
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
