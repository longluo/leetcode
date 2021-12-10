package com.longluo.leetcode.array;

import java.util.*;

/**
 * 748. 最短补全词
 * <p>
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。
 * <p>
 * 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。
 * <p>
 * 在匹配 licensePlate 中的字母时：
 * <p>
 * 忽略 licensePlate 中的 数字和空格 。
 * 不区分大小写。
 * 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * <p>
 * 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 那个。
 * <p>
 * 示例 1：
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 * <p>
 * 示例 2：
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
 * <p>
 * 示例 3：
 * 输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband","easy","education","drug","prevent","writer","old"]
 * 输出："husband"
 * <p>
 * 示例 4：
 * 输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder","box","arrive","money","tax","thus"]
 * 输出："enough"
 * <p>
 * 示例 5：
 * 输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera","public","never","wonder","simple","thought","use"]
 * 输出："simple"
 * <p>
 * <p>
 * 提示：
 * 1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/shortest-completing-word/
 */
public class Problem748_shortestCompletingWord {

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : licensePlate.toCharArray()) {
            if (Character.isLetter(ch)) {
                char temp = Character.toLowerCase(ch);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for (char ch : word.toCharArray()) {
                wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
            }

            boolean flag = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                char ch = entry.getKey();
                int num = entry.getValue();
                if (!wordMap.containsKey(ch) || wordMap.get(ch) < num) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(word);
            }
        }

        Collections.sort(ans, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        return ans.get(0);
    }

    public static void main(String[] args) {
        System.out.println("pest ?= " + shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
