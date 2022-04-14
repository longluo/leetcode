package com.longluo.studyplan.programming_skills;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 注意 两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * <p>
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * <p>
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * 提示：
 * 1 <= tokens.length <= 10^4
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * <p>
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * <p>
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class Problem150_evaluateReversePolishNotation {

    // Stack time: O(n) space: O(n)
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (String token : tokens) {
            char ch = token.charAt(0);
            if (token.length() == 1 && (ch == '+' || ch == '-' || ch == '*' || ch == '/')) {
                int numB = stk.pop();
                int numA = stk.pop();
                int result = 0;
                switch (ch) {
                    case '+':
                        result = numA + numB;
                        break;

                    case '-':
                        result = numA - numB;
                        break;

                    case '*':
                        result = numA * numB;
                        break;

                    case '/':
                        result = numA / numB;
                        break;

                    default:
                        break;
                }

                stk.push(result);
            } else {
                int num = 0;
                boolean isNegative = false;
                if (ch == '-') {
                    isNegative = true;
                }

                int idx = isNegative ? 1 : 0;
                for (int i = idx; i < token.length(); i++) {
                    num = 10 * num + token.charAt(i) - '0';
                }

                num = isNegative ? -num : num;
                stk.push(num);
            }
        }

        return stk.pop();
    }

    public static void main(String[] args) {
        System.out.println("9 ?= " + evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println("6 ?= " + evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
