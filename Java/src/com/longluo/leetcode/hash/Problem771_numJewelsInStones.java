package com.longluo.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 * <p>
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * <p>
 * 注意:
 * S和J最多含有50个字母。
 * J中的字符不重复。
 * <p>
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class Problem771_numJewelsInStones {

    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewSets = new HashSet<>();
        for (Character ch : jewels.toCharArray()) {
            jewSets.add(ch);
        }

        int ans = 0;
        for (Character ch : stones.toCharArray()) {
            if (jewSets.contains(ch)) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + numJewelsInStones("aA", "aAAbbbb"));
        System.out.println("0 ?= " + numJewelsInStones("z", "ZZ"));
    }
}
