package com.longluo.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 * <p>
 * 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
 * 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
 * <p>
 * 示例 1：
 * 输入：text = "nlaebolko"
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：text = "loonbalxballpoon"
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：text = "leetcode"
 * 输出：0
 * <p>
 * 提示：
 * 1 <= text.length <= 10^4
 * text 全部由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */
public class Problem1189_maxNumberOfBalloons {

    public static int maxNumberOfBalloons(String text) {
        char[] array = {'b', 'a', 'l', 'o', 'n'};
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        while (true) {
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                if (!map.containsKey(array[i])) {
                    return ans;
                } else {
                    if (array[i] == 'l' || array[i] == 'o') {
                        int num = map.getOrDefault(array[i], 0);
                        if (num <= 1) {
                            return ans;
                        } else {
                            map.put(array[i], num - 2);
                        }
                    } else {
                        int num = map.getOrDefault(array[i], 0);
                        if (num <= 0) {
                            return ans;
                        } else {
                            map.put(array[i], num - 1);
                        }
                    }
                }
            }

            if (flag) {
                ans++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
