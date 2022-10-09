package com.longluo.algo200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 170. 两数之和 III - 数据结构设计
 * <p>
 * 设计一个接收整数流的数据结构，该数据结构支持检查是否存在两数之和等于特定值。
 * <p>
 * 实现 TwoSum 类：
 * TwoSum() 使用空数组初始化 TwoSum 对象
 * void add(int number) 向数据结构添加一个数 number
 * boolean find(int value) 寻找数据结构中是否存在一对整数，使得两数之和与给定的值相等。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入：
 * ["TwoSum", "add", "add", "add", "find", "find"]
 * [[], [1], [3], [5], [4], [7]]
 * 输出：
 * [null, null, null, null, true, false]
 * <p>
 * 解释：
 * TwoSum twoSum = new TwoSum();
 * twoSum.add(1);   // [] --> [1]
 * twoSum.add(3);   // [1] --> [1,3]
 * twoSum.add(5);   // [1,3] --> [1,3,5]
 * twoSum.find(4);  // 1 + 3 = 4，返回 true
 * twoSum.find(7);  // 没有两个整数加起来等于 7 ，返回 false
 * <p>
 * 提示：
 * -10^5 <= number <= 10^5
 * -2^31 <= value <= 2^31 - 1
 * 最多调用 10^4 次 add 和 find
 * <p>
 * https://leetcode.cn/problems/two-sum-iii-data-structure-design/
 */
public class Problem170_twoSum_iii {

    // Sort + Two Pointers time: O(nlogn) space: O(n)
    static class TwoSum {
        List<Integer> nums;

        public TwoSum() {
            nums = new ArrayList<>();
        }

        public void add(int number) {
            nums.add(number);
        }

        public boolean find(int value) {
            Collections.sort(nums);

            int left = 0;
            int right = nums.size() - 1;

            while (left < right) {
                int sum = nums.get(left) + nums.get(right);
                if (sum > value) {
                    right--;
                } else if (sum < value) {
                    left++;
                } else {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Your TwoSum object will be instantiated and called as such:
     * TwoSum obj = new TwoSum();
     * obj.add(number);
     * boolean param_2 = obj.find(value);
     */
    public static void main(String[] args) {
        TwoSum tst1 = new TwoSum();
        tst1.add(1);
        tst1.add(3);
        tst1.add(5);
        tst1.find(4);
        tst1.find(7);
    }
}
