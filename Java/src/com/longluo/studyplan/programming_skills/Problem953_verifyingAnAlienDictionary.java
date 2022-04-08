package com.longluo.studyplan.programming_skills;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；
 * 否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>
 * 示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * <p>
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 * <p>
 * https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 */
public class Problem953_verifyingAnAlienDictionary {

    // BF time: O(2*n + nlogn) space: O(2*n)
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dictMap = new HashMap<>();
        dictMap.put(' ', 0);
        for (int i = 1; i <= order.length(); i++) {
            char ch = order.charAt(i - 1);
            dictMap.put(ch, i);
        }

        String[] sorted = new String[words.length];
        System.arraycopy(words, 0, sorted, 0, words.length);
        Arrays.sort(sorted, (o1, o2) -> {
            int idx = 0;
            while (idx < o1.length() && idx < o2.length() && dictMap.get(o1.charAt(idx)).equals(dictMap.get(o2.charAt(idx)))) {
                idx++;
            }
            int ch1 = idx < o1.length() ? dictMap.get(o1.charAt(idx)) : 0;
            int ch2 = idx < o2.length() ? dictMap.get(o2.charAt(idx)) : 0;
            return ch1 - ch2;
        });

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(sorted[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isAlienSorted(new String[]{"aa", "a"}, "abqwertyuioplkjhgfdszxcvnm"));
        System.out.println("true ?= " + isAlienSorted(new String[]{"ubg", "kwh"}, "qcipyamwvdjtesbghlorufnkzx"));
        System.out.println("true ?= " + isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("false ?= " + isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println("false ?= " + isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
