package com.longluo.top_interviews;

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

    static class MinStack {

        Stack<Integer> stack;
        List<Integer> list;

        public MinStack() {
            stack = new Stack<>();
            list = new ArrayList<>();
        }

        public void push(int val) {
            stack.push(val);
            list.add(val);
            Collections.sort(list);
        }

        public void pop() {
            int val = stack.peek();
            stack.pop();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).intValue() == val) {
                    list.remove(i);
                    break;
                }
            }
            Collections.sort(list);
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return list.get(0);
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

    }
}
