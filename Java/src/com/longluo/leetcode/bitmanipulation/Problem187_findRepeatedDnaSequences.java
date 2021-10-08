package com.longluo.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * <p>
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，
 * 识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 * <p>
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * 提示：
 * 0 <= s.length <= 10^5
 * s[i] 为 'A'、'C'、'G' 或 'T'
 * <p>
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 */
public class Problem187_findRepeatedDnaSequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return ans;
        }

        int n = s.length();
        Map<String, Integer> freq = new HashMap<>();
        for (int i = 0; i <= n - 10; i++) {
            String str = s.substring(i, i + 10);
            freq.put(str, freq.getOrDefault(str, 0) + 1);
            if (freq.get(str) == 2) {
                ans.add(str);
            }
        }

        return ans;
    }

    public static List<String> findRepeatedDnaSequences_win(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return ans;
        }

        int n = s.length();
        for (int i = 0; i <= n - 10; i++) {
            char ch = s.charAt(i);
            for (int j = i + 1; j <= n - 10; j++) {
                char nextch = s.charAt(j);
                if (ch != nextch) {
                    continue;
                }

                int srcIdx = i;
                int destIdx = j;
                int count = 0;
                while (srcIdx < n - 1 && count < 10 && s.charAt(srcIdx) == s.charAt(destIdx)) {
                    srcIdx++;
                    destIdx++;
                    count++;
                    if (count == 10) {
                        ans.add(s.substring(i, i + 10));
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(" " + findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(" " + findRepeatedDnaSequences("AAAAAAAAAAAAA"));
    }
}
