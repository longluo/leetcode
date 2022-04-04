package com.longluo.hot100;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，
 * 才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * <p>
 * https://leetcode-cn.com/problems/daily-temperatures/
 */
public class Problem739_dailyTemperatures {

    // BF time: O(n^2) space: O(n)
    public static int[] dailyTemperatures_bf(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    // 单调栈 MonoStack time: O(n) space: O(n)
    public static int[] dailyTemperatures_stack(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stk.empty() && temperatures[i] > temperatures[stk.peek()]) {
                int idx = stk.pop();
                answer[idx] = i - idx;
            }

            stk.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Arrays.toString(dailyTemperatures_bf(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Arrays.toString(dailyTemperatures_stack(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
