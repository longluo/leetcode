package com.longluo.leetcode.array;

/**
 * 1816. 截断句子
 * <p>
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 * <p>
 * 示例 1：
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 * <p>
 * 示例 2：
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 * <p>
 * 示例 3：
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 * <p>
 * 提示：
 * 1 <= s.length <= 500
 * k 的取值范围是 [1,  s 中单词的数目]
 * s 仅由大小写英文字母和空格组成
 * s 中的单词之间由单个空格隔开
 * 不存在前导或尾随空格
 * <p>
 * https://leetcode-cn.com/problems/truncate-sentence/
 */
public class Problem1816_truncateSentence {

    public static String truncateSentence(String s, int k) {
        String[] array = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(array[i]).append(" ");
        }

        return sb.toString().trim();
    }

    public static String truncateSentence_bf(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            if (s.charAt(i) == ' ') {
                k--;
            }
            if (k == 0) {
                sb.deleteCharAt(sb.length() - 1);
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Hello how are you ?= " + truncateSentence_bf("Hello how are you Contestant", 4));
        System.out.println("What is the solution ?= " + truncateSentence_bf("What is the solution to this problem", 4));
    }
}
