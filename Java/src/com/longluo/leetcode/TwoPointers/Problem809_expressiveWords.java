package com.longluo.leetcode.TwoPointers;

/**
 * 809. 情感丰富的文字
 * <p>
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。
 * 我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
 * 扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。
 * 此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，
 * 因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 * 示例：
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * <p>
 * 提示：
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成。
 * <p>
 * https://leetcode.cn/problems/expressive-words/
 */
public class Problem809_expressiveWords {

    // Two Pointers time: O(Sum) space: O(1)
    public static int expressiveWords(String s, String[] words) {
        int ans = 0;

        for (String word : words) {
            if (word.length() > s.length()) {
                continue;
            }

            int i = 0;
            int j = 0;

            int sCnt = 1;
            int wCnt = 1;

            boolean flag = true;

            while (i < s.length() && j < word.length()) {
                int p = i;
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    sCnt++;
                }

                int q = j;
                while (j + 1 < word.length() && word.charAt(j) == word.charAt(j + 1)) {
                    j++;
                    wCnt++;
                }

                if (s.charAt(p) == word.charAt(q)) {
                    if (sCnt >= 3 && sCnt >= wCnt) {
                        i++;
                        j++;
                    } else {
                        i = p + 1;
                        j = q + 1;
                    }

                    sCnt = 1;
                    wCnt = 1;
                } else {
                    flag = false;
                    break;
                }
            }

            if (i == s.length() && j == word.length() && flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println("0 ?= " + expressiveWords("heeelllooo", new String[]{"hellllo"}));
        System.out.println("1 ?= " + expressiveWords("ggkyyyyffffbbhddddrxxsiixccqqqqkmmmiiiiiivvvyyuuujccuuuhhhhwssssnnttoyuuuussggttttfeeeebbbbeedddddqq", new String[]{"ggkyyfbbhdrxxsiixccqkmmiiivvvyyujccuuuhhwsnnttoyuuussggtttfeeebbbeedddqq"}));
        System.out.println("0 ?= " + expressiveWords("abcd", new String[]{"abc"}));
    }
}
