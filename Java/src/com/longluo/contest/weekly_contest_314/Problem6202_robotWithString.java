package com.longluo.contest.weekly_contest_314;

/**
 * 6202. 使用机器人打印字典序最小的字符串
 * <p>
 * 给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串：
 * <p>
 * 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。
 * 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。
 * 请你返回纸上能写出的字典序最小的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "zza"
 * 输出："azz"
 * 解释：用 p 表示写出来的字符串。
 * 一开始，p="" ，s="zza" ，t="" 。
 * 执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
 * 执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
 * <p>
 * 示例 2：
 * 输入：s = "bac"
 * 输出："abc"
 * 解释：用 p 表示写出来的字符串。
 * 执行第一个操作两次，得到 p="" ，s="c" ，t="ba" 。
 * 执行第二个操作两次，得到 p="ab" ，s="c" ，t="" 。
 * 执行第一个操作，得到 p="ab" ，s="" ，t="c" 。
 * 执行第二个操作，得到 p="abc" ，s="" ，t="" 。
 * <p>
 * 示例 3：
 * 输入：s = "bdda"
 * 输出："addb"
 * 解释：用 p 表示写出来的字符串。
 * 一开始，p="" ，s="bdda" ，t="" 。
 * 执行第一个操作四次，得到 p="" ，s="" ，t="bdda" 。
 * 执行第二个操作四次，得到 p="addb" ，s="" ，t="" 。
 * <p>
 * 提示：
 * 1 <= s.length <= 10^5
 * s 只包含小写英文字母。
 * <p>
 * https://leetcode.cn/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
 */
public class Problem6202_robotWithString {

    public static String robotWithString(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        char lowest = 'z';
        int maxPos = -1;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] < lowest) {
                lowest = array[i];
                maxPos = i;
                cnt = 1;
            } else if (array[i] == lowest) {
                maxPos = i;
                cnt++;
            }
        }

        if (maxPos == 0) {
            return s;
        }

        int left = maxPos - 1;
        int right = maxPos + 1;

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < cnt; i++) {
            sb.append(lowest);
        }

        while (left >= 0 && right <= len) {
            if (left >= 0 && array[left] == lowest) {
                left--;
            }

            if (right < len && array[right] == lowest) {
                right++;
            }

            if (left >= 0 && right < len && array[left] <= array[right]) {
                sb.append(array[left]);
                left--;
            } else if (left >= 0 && right < len && array[left] > array[right]) {
                sb.append(array[right]);
                right++;
            } else if (left >= 0 && right == len) {
                sb.append(array[left]);
                left--;
            } else if (left == -1 && right < len) {
                sb.append(array[right]);
                right++;
            }
        }

        while (left >= 0) {
            sb.append(array[left]);
            left--;
        }

        while (right < len) {
            sb.append(array[right]);
            right++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("abc ?= " + robotWithString("bac"));
        System.out.println("azz ?= " + robotWithString("zza"));
        System.out.println("addb ?= " + robotWithString("bdda"));
    }
}
