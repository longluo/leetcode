package com.longluo.contest.biweekly_contest_79;

import java.util.*;

/**
 * 6084. 最多单词数的发件人
 * <p>
 * 给你一个聊天记录，共包含 n 条信息。给你两个字符串数组 messages 和 senders ，其中 messages[i] 是 senders[i] 发出的一条 信息 。
 * <p>
 * 一条 信息 是若干用单个空格连接的 单词 ，信息开头和结尾不会有多余空格。发件人的 单词计数 是这个发件人总共发出的 单词数 。注意，一个发件人可能会发出多于一条信息。
 * <p>
 * 请你返回发出单词数 最多 的发件人名字。如果有多个发件人发出最多单词数，请你返回 字典序 最大的名字。
 * <p>
 * 注意：
 * 字典序里，大写字母小于小写字母。
 * "Alice" 和 "alice" 是不同的名字。
 * <p>
 * 示例 1：
 * 输入：messages = ["Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"], senders = ["Alice","userTwo","userThree","Alice"]
 * 输出："Alice"
 * 解释：Alice 总共发出了 2 + 3 = 5 个单词。
 * userTwo 发出了 2 个单词。
 * userThree 发出了 3 个单词。
 * 由于 Alice 发出单词数最多，所以我们返回 "Alice" 。
 * <p>
 * 示例 2：
 * 输入：messages = ["How is leetcode for everyone","Leetcode is useful for practice"], senders = ["Bob","Charlie"]
 * 输出："Charlie"
 * 解释：Bob 总共发出了 5 个单词。
 * Charlie 总共发出了 5 个单词。
 * 由于最多单词数打平，返回字典序最大的名字，也就是 Charlie 。
 * <p>
 * 提示：
 * n == messages.length == senders.length
 * 1 <= n <= 10^4
 * 1 <= messages[i].length <= 100
 * 1 <= senders[i].length <= 10
 * messages[i] 包含大写字母、小写字母和 ' ' 。
 * messages[i] 中所有单词都由 单个空格 隔开。
 * messages[i] 不包含前导和后缀空格。
 * senders[i] 只包含大写英文字母和小写英文字母。
 * <p>
 * https://leetcode.cn/problems/sender-with-largest-word-count/
 */
public class Problem2284_senderWithLargestWordCount {

    // HashMap + Sort time: O(nlogn) space: O(n)
    public static String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        int[] wordCount = new int[len];
        for (int i = 0; i < len; i++) {
            wordCount[i] = messages[i].split("\\s+").length;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String name = senders[i];
            map.put(senders[i], map.getOrDefault(name, 0) + wordCount[i]);
        }

        List<String[]> senderList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            senderList.add(new String[]{entry.getKey(), entry.getValue().toString()});
        }

        Collections.sort(senderList, (o1, o2) -> {
            if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                return o2[0].compareTo(o1[0]);
            }

            return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
        });

        return senderList.get(0)[0];
    }

    // HashMap time: O(n) space: O(n)
    public static String largestWordCount_opt(String[] messages, String[] senders) {
        int len = messages.length;
        Map<String, Integer> map = new HashMap<>();
        String ans = "";
        int max = 0;
        for (int i = 0; i < len; i++) {
            String sender = senders[i];
            String message = messages[i];
            int cnt = 0;
            for (char ch : message.toCharArray()) {
                if (ch == ' ') {
                    cnt++;
                }
            }

            int wordCount = (cnt + 1) + map.getOrDefault(sender, 0);
            if (wordCount > max) {
                ans = sender;
                max = wordCount;
            } else if (wordCount == max) {
                ans = sender.compareTo(ans) > 0 ? sender : ans;
            }

            map.put(sender, wordCount);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Charlie ?= " + largestWordCount(new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"}, new String[]{"Bob", "Charlie"}));
        System.out.println("Charlie ?= " + largestWordCount_opt(new String[]{"How is leetcode for everyone", "Leetcode is useful for practice"}, new String[]{"Bob", "Charlie"}));
        System.out.println("Alice ?= " + largestWordCount_opt(new String[]{"Hello userTwooo", "Hi userThree", "Wonderful day Alice", "Nice day userThree"}, new String[]{"Alice", "userTwo", "userThree", "Alice"}));
    }
}
