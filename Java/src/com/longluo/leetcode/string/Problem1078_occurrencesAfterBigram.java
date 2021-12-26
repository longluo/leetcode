package com.longluo.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 *1078. Bigram 分词
 *
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
 * 其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 示例 1：
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 *
 * 示例 2：
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 *
 * 提示：
 * 1 <= text.length <= 1000
 * text 由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 *
 * https://leetcode-cn.com/problems/occurrences-after-bigram/
 */
public class Problem1078_occurrencesAfterBigram {

    public static String[] findOcurrences(String text, String first, String second) {
        String[] arrays = text.split("\\s+");
        List<String> ans = new ArrayList<>();
        int len = arrays.length;
        int i = 0;
        while (i < len) {
            if (i + 1 < len && arrays[i].equals(first) && arrays[i + 1].equals(second)) {
                if (i + 2 < len) {
                    ans.add(arrays[i + 2]);
                }
            }

            i++;
        }

        String[] res = new String[ans.size()];
        for (int j = 0; j < ans.size(); j++) {
            res[j] = ans.get(j);
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
