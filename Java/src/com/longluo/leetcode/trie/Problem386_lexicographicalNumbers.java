package com.longluo.leetcode.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 386. 字典序排数
 * <p>
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 * 示例 1：
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * 1 <= n <= 5 * 10^4
 * <p>
 * https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class Problem386_lexicographicalNumbers {

    // BF String time: O(nlogn + 2 * n) space: O(n)
    public static List<Integer> lexicalOrder_bf(int n) {
        List<String> numStrList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numStrList.add(String.valueOf(i));
        }

        Collections.sort(numStrList);
        List<Integer> ans = new ArrayList<>();
        for (String numStr : numStrList) {
            ans.add(Integer.valueOf(numStr));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder_bf(1));
        System.out.println(lexicalOrder_bf(2));
        System.out.println(lexicalOrder_bf(10));
    }
}
