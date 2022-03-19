package com.longluo.leetcode.hash;

import java.util.*;
import java.util.function.Function;

/**
 * 895. Maximum Frequency Stack
 * Hard
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * Implement the FreqStack class:
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 * <p>
 * Example 1:
 * Input
 * ["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
 * [[], [5], [7], [5], [7], [4], [5], [], [], [], []]
 * Output
 * [null, null, null, null, null, null, null, 5, 7, 5, 4]
 * <p>
 * Explanation
 * FreqStack freqStack = new FreqStack();
 * freqStack.push(5); // The stack is [5]
 * freqStack.push(7); // The stack is [5,7]
 * freqStack.push(5); // The stack is [5,7,5]
 * freqStack.push(7); // The stack is [5,7,5,7]
 * freqStack.push(4); // The stack is [5,7,5,7,4]
 * freqStack.push(5); // The stack is [5,7,5,7,4,5]
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
 * freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
 * freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
 * freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
 * <p>
 * <p>
 * Constraints:
 * 0 <= val <= 10^9
 * At most 2 * 10^4 calls will be made to push and pop.
 * It is guaranteed that there will be at least one element in the stack before calling pop.
 * <p>
 * https://leetcode.com/problems/maximum-frequency-stack/
 */
public class Problem895_maximumFrequencyStack {

    static class FreqStack {
        Map<Integer, Integer> freqMap;
        Map<Integer, Stack<Integer>> groupFreqMap;
        int maxFreq = 0;

        public FreqStack() {
            freqMap = new HashMap<>();
            groupFreqMap = new HashMap<>();
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);
            if (freq > maxFreq) {
                maxFreq = freq;
            }

            groupFreqMap.computeIfAbsent(freq, new Function<Integer, Stack<Integer>>() {
                @Override
                public Stack<Integer> apply(Integer integer) {
                    return new Stack<>();
                }
            }).push(val);
        }

        public int pop() {
            int x = groupFreqMap.get(maxFreq).pop();
            freqMap.put(x, freqMap.get(x) - 1);
            if (groupFreqMap.get(maxFreq).size() == 0) {
                maxFreq--;
            }

            return x;
        }
    }

    class FreqStack_map {
        Map<Integer, Integer> freqMap;
        int maxFreq = 0;

        public FreqStack_map() {
            freqMap = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);
            if (freq > maxFreq) {
                maxFreq = freq;
            }
        }

        public int pop() {
            int ret = freqMap.get(maxFreq);
            freqMap.put(ret, freqMap.get(ret) - 1);
            maxFreq--;
            return ret;
        }
    }

    class FreqStack_better {
        Map<Integer, Integer> freqMap;
        Map<Integer, LinkedList<Integer>> groupFreqMap;
        int maxFreq = 0;

        public FreqStack_better() {
            freqMap = new HashMap<>();
            groupFreqMap = new HashMap<>();
        }

        public void push(int val) {
            int freq = freqMap.getOrDefault(val, 0) + 1;
            freqMap.put(val, freq);
            if (freq > maxFreq) {
                maxFreq = freq;
            }

            groupFreqMap.putIfAbsent(freq, new LinkedList<>());
            groupFreqMap.get(freq).push(val);
        }

        public int pop() {
            int res = groupFreqMap.get(maxFreq).pop();
            freqMap.put(res, freqMap.get(res) - 1);
            if (groupFreqMap.get(maxFreq).isEmpty()) {
                groupFreqMap.remove(maxFreq);
                maxFreq--;
            }

            return res;
        }
    }

    /**
     * Your FreqStack object will be instantiated and called as such:
     * FreqStack obj = new FreqStack();
     * obj.push(val);
     * int param_2 = obj.pop();
     */

    public static void main(String[] args) {
        FreqStack fs = new FreqStack();
        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);
        fs.pop();
        fs.pop();
        fs.pop();
        fs.pop();
    }
}
