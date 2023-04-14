package com.longluo.leetcode.BitManipulation;

import java.util.*;

/**
 * 1178. 猜字谜
 * <p>
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 * <p>
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * <p>
 * 例如，如果字谜的谜面是 "abcdefg"，
 * 那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）都不能作为谜底。
 * 返回一个答案数组 answer，数组中的每个元素 nswer[i]是在给出的单词列表words中可以作为字谜迷面puzzles[i]所对应的谜底的单词数目。
 * <p>
 * 示例：
 * 输入：
 * words = ["aaaa","asas","able","ability","actt","actor","access"],
 * puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
 * 输出：[1,1,3,2,4,0]
 * 解释：
 * 1 个单词可以作为 "aboveyz" 的谜底 : "aaaa"
 * 1 个单词可以作为 "abrodyz" 的谜底 : "aaaa"
 * 3 个单词可以作为 "abslute" 的谜底 : "aaaa", "asas", "able"
 * 2 个单词可以作为 "absoryz" 的谜底 : "aaaa", "asas"
 * 4 个单词可以作为 "actresz" 的谜底 : "aaaa", "asas", "actt", "access"
 * 没有单词可以作为 "gaswxyz" 的谜底，因为列表中的单词都不含字母 'g'。
 * <p>
 * 提示：
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 * <p>
 * https://leetcode.cn/problems/number-of-valid-words-for-each-puzzle/
 */
public class Problem1178_numberOfValidWordsForEachPuzzle {

    // TLE
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        if (words == null || words.length == 0) {
            return ans;
        }

        int n = puzzles.length;
        for (int i = 0; i < n; i++) {
            String puzzle = puzzles[i];
            int count = 0;
            for (String word : words) {
                if (isValid(puzzle, word)) {
                    count++;
                }
            }
            ans.add(count);
        }

        return ans;
    }

    public static boolean isValid(String puzzle, String word) {
        Set<Character> puzzleSet = new HashSet<>();
        Set<Character> wordSet = new HashSet<>();
        for (Character ch : puzzle.toCharArray()) {
            puzzleSet.add(ch);
        }
        for (Character ch : word.toCharArray()) {
            wordSet.add(ch);
        }
        if (!wordSet.contains(puzzle.charAt(0))) {
            return false;
        }
        for (Character ch : wordSet) {
            if (!puzzleSet.contains(ch)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("[1, 1, 3, 2, 4, 0] ?= " + findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}).toString());
    }
}
