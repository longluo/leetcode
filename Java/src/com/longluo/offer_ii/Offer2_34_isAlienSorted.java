package com.longluo.offer_ii;

import java.util.*;

/**
 * 剑指 Offer II 034. 外星语言是否排序
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
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，
 * 其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 * <p>
 * 注意：本题与主站 953 题相同： https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * <p>
 * https://leetcode.cn/problems/lwyVBB/
 */
public class Offer2_34_isAlienSorted {

    public static boolean isAlienSorted(String[] words, String order) {
        int len = order.length();
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            orderMap.put(order.charAt(i), i);
        }

        List<String> list = new ArrayList<>();
        for (String word : words) {
            list.add(word);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                char[] xArr = x.toCharArray();
                char[] yArr = y.toCharArray();
                int i = 0;
                int j = 0;
                while (i < xArr.length && j < yArr.length) {
                    while ((i < xArr.length && j < yArr.length) && (orderMap.get(xArr[i]) == orderMap.get(yArr[j]))) {
                        i++;
                        j++;
                    }

                    if (i == xArr.length) {
                        return -1;
                    }

                    if (j == yArr.length) {
                        return 1;
                    }

                    if (orderMap.get(xArr[i]) != orderMap.get(yArr[j])) {
                        break;
                    }
                }

                return orderMap.get(xArr[i]) - orderMap.get(yArr[j]);
            }
        });

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(list.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isAlienSorted(new String[]{"hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println("false ?= " + isAlienSorted(new String[]{"apple", "app" }, "abcdefghijklmnopqrstuvwxyz"));
    }
}
