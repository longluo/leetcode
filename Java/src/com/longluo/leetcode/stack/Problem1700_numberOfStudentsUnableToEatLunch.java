package com.longluo.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 1700. 无法吃午餐的学生数量
 * <p>
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字 0 和 1 表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个 栈 里，每一轮：
 * <p>
 * 如果队列最前面的学生 喜欢 栈顶的三明治，那么会 拿走它 并离开队列。
 * 否则，这名学生会 放弃这个三明治 并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * <p>
 * 给你两个整数数组 students 和 sandwiches ，其中 sandwiches[i] 是栈里面第i个三明治的类型（i = 0 是栈的顶部），
 * students[j] 是初始队列里第 j​​​​​​ 名学生对三明治的喜好（j = 0 是队列的最开始位置）。
 * 请你返回无法吃午餐的学生数量。
 * <p>
 * 示例 1：
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 * 解释：
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 * <p>
 * 示例 2：
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 * <p>
 * 提示：
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] 要么是 0 ，要么是 1 。
 * students[i] 要么是 0 ，要么是 1 。
 * <p>
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

    // Math time: O(n) space: O(1)
    public static int countStudents_opt(int[] students, int[] sandwiches) {
        int[] count = new int[2];

        for (int x : students) {
            count[x]++;
        }

        int len = sandwiches.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (count[sandwiches[i]] > 0) {
                count[sandwiches[i]]--;
            } else {
                ans = len - i;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println("3 ?= " + countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));

        System.out.println("0 ?= " + countStudents_opt(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
        System.out.println("3 ?= " + countStudents_opt(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
    }
}
