package com.longluo.studyplan.programming_skills;

/**
 * 1678. 设计 Goal 解析器
 * <p>
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 示例 1：
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * <p>
 * 示例 2：
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * <p>
 * 示例 3：
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * 提示：
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 * <p>
 * https://leetcode-cn.com/problems/goal-parser-interpretation/
 */
public class Problem1678_goalParserInterpretation {

    // Simulate time: O(n) space: O(n)
    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (i + 1 < command.length() && command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                i++;
                sb.append("o");
            } else if (i + 3 < command.length() && command.charAt(i) == '(' && command.substring(i, i + 4).equals("(al)")) {
                i += 3;
                sb.append("al");
            }
        }

        return sb.toString();
    }

    // BF time: O(n) space: O(n)
    public static String interpret_bf(String command) {
        int len = command.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append(ch);
                i++;
            } else if (ch == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i += 2;
            } else if (ch == '(' && command.charAt(i + 1) == 'a') {
                sb.append("al");
                i += 4;
            }
        }

        return sb.toString();
    }

    // Regex time: O(n) space: O(n)
    public static String interpret_regex(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

    public static void main(String[] args) {
        System.out.println("Goal ?= " + interpret("G()(al)"));
        System.out.println("Gooooal ?= " + interpret("G()()()()(al)"));
        System.out.println("alGalooG ?= " + interpret("(al)G(al)()()G"));

        System.out.println("Goal ?= " + interpret_bf("G()(al)"));
        System.out.println("Gooooal ?= " + interpret_bf("G()()()()(al)"));
        System.out.println("alGalooG ?= " + interpret_bf("(al)G(al)()()G"));
        System.out.println("alGalooG ?= " + interpret_regex("(al)G(al)()()G"));
    }
}
