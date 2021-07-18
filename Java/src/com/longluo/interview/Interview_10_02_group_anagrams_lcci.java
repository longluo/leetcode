package com.longluo.interview;

import com.longluo.datastructure.ArrayUtils;

import java.util.*;

/**
 * 面试题 10.02. 变位词组
 * <p>
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 */
public class Interview_10_02_group_anagrams_lcci {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(" ?= " + ArrayUtils.print2DListString(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})));
    }
}
