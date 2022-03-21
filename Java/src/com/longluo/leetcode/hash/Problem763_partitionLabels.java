package com.longluo.leetcode.hash;

import java.util.*;

/**
 * 763. 划分字母区间
 * <p>
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * <p>
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class Problem763_partitionLabels {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() <= 1) {
            ans.add(s.length());
            return ans;
        }

        int len = s.length();
        Map<Character, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (idxMap.containsKey(ch)) {
                idxMap.put(ch, i);
            } else {
                idxMap.put(ch, i);
            }
        }

        int index = 0;
        int[] partSection = new int[2];

        while (index < len) {
            while (index >= partSection[0] && index <= partSection[1]) {
                char ch = s.charAt(index);
                index++;
                int lastIdx = idxMap.get(ch);
                if (lastIdx > partSection[1]) {
                    partSection[1] = lastIdx;
                }
            }

            ans.add(partSection[1] - partSection[0] + 1);
            partSection[0] = partSection[1] = index;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[10] ?= " + partitionLabels("eccbbbbdec"));
        System.out.println("[9, 7, 8] ?= " + partitionLabels("ababcbacadefegdehijhklij"));
    }
}
