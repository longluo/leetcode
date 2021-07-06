package com.longluo.leetcode.stack;

import java.util.*;

/**
 * 726. 原子的数量
 * <p>
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，
 * 但 H1O2 这个表达是不可行的。
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），
 * 然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * <p>
 * 示例 1:
 * 输入:
 * formula = "H2O"
 * 输出: "H2O"
 * 解释:
 * 原子的数量是 {'H': 2, 'O': 1}。
 * <p>
 * 示例 2:
 * 输入:
 * formula = "Mg(OH)2"
 * 输出: "H2MgO2"
 * 解释:
 * 原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * <p>
 * 示例 3:
 * 输入:
 * formula = "K4(ON(SO3)2)2"
 * 输出: "K4N2O14S4"
 * 解释:
 * 原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
 * <p>
 * 注意:
 * 所有原子的第一个字母为大写，剩余字母都是小写。
 * formula的长度在[1, 1000]之间。
 * formula只包含字母、数字和圆括号，并且题目中给定的是合法的化学式。
 * <p>
 * https://leetcode-cn.com/problems/number-of-atoms/
 */
public class Problem726_numberOfAtoms {

    private static int index = 0;

    public static String countOfAtoms(String formula) {
        if (formula == null || formula.length() <= 1) {
            return formula;
        }

        index = 0;

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        for (index = 0; index < n; ) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                stack.push(new HashMap<>());
                index++;
            } else if (ch == ')') {
                index++;
                if (index < n && Character.isDigit(formula.charAt(index))) {
                    int multi = parseNumber(formula, index);
                    Map<String, Integer> map = stack.pop();
                    multiplyMap(map, multi);
                    Map<String, Integer> lastLevelMap = stack.peek();
                    addToMap(lastLevelMap, map);
                } else if (index < n && !Character.isDigit(formula.charAt(index))) {
                    Map<String, Integer> map = stack.pop();
                    Map<String, Integer> lastLevelMap = stack.peek();
                    addToMap(lastLevelMap, map);
                }
            } else {
                Map<String, Integer> map = stack.peek();
                String element = parseElement(formula);
                int number = parseNumber(formula);
                map.put(element, map.getOrDefault(element, 0) + number);
            }
        }

        Map<String, Integer> elementMap = new TreeMap<>(stack.pop());
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> iterator = elementMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            sb.append(entry.getKey());
            int value = entry.getValue();
            if (value > 1) {
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }

    public static String parseElement(String formula) {
        int start = index;
        int end = index + 1;
        for (index = index + 1; index < formula.length(); index++) {
            Character ch = formula.charAt(index);
            if (!Character.isLowerCase(ch)) {
                end = index;
                break;
            }
        }
        String str = formula.substring(start, end);
        return str;
    }

    public static int parseNumber(String formula) {
        if (index == formula.length() || !Character.isDigit(formula.charAt(index))) {
            return 1;
        }

        int start = index;
        while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
            index++;
        }
        String str = formula.substring(start, index);
        return Integer.parseInt(str);
    }

    public static int parseNumber(String formula, int idx) {
        int start = idx;
        index = idx;
        while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
            index++;
        }
        String str = formula.substring(start, index);
        return Integer.parseInt(str);
    }

    public static Map multiplyMap(Map<String, Integer> map, int multiplier) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int newVal = (int) entry.getValue() * multiplier;
            entry.setValue(newVal);
        }

        return map;
    }

    public static Map addToMap(Map<String, Integer> hostMap, Map<String, Integer> addMap) {
        Iterator<Map.Entry<String, Integer>> iterator = addMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String element = (String) entry.getKey();
            int number = (int) entry.getValue();
            hostMap.put(element, hostMap.getOrDefault(element, 0) + number);
        }

        return hostMap;
    }

    public static void main(String[] args) {
        System.out.println("H2O ?= " + countOfAtoms("H2O"));
        System.out.println("H2MgO2 ?= " + countOfAtoms("Mg(OH)2"));
        System.out.println("K4N2O14S4 ?= " + countOfAtoms("K4(ON(SO3)2)2"));
        System.out.println("FH18MgNNa4O12S ?= " + countOfAtoms("Mg((H2O)2Na)4(F)(H2SO4)N"));
    }
}
