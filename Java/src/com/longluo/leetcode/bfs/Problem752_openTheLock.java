package com.longluo.leetcode.bfs;

import java.util.*;

/**
 * 752. 打开转盘锁
 * <p>
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 * <p>
 * https://leetcode-cn.com/problems/open-the-lock/
 */
public class Problem752_openTheLock {

    public static int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }

        Set<String> locks = new HashSet<>();
        for (String dead : deadends) {
            locks.add(dead);
        }
        if (locks.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                List<String> nextStrList = getLockString(str);
                for (String next : nextStrList) {
                    if (locks.contains(next)) {
                        continue;
                    }

                    if (visited.contains(next)) {
                        continue;
                    }

                    if (next.equals(target)) {
                        return step;
                    }

                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return -1;
    }

    public static List<String> getLockString(String origStr) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String firstPart = origStr.substring(0, i);
            String thirdPart = origStr.substring(i + 1);

            char chPrev = numPrev(origStr.charAt(i));
            res.add(firstPart + chPrev + thirdPart);

            char chNext = numSucc(origStr.charAt(i));
            res.add(firstPart + chNext + thirdPart);
        }

        return res;
    }

    public static char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public static char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public static List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println("1 ?= " + openLock(new String[]{"8888"}, "0009"));
        System.out.println("-1 ?= " + openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        System.out.println("-1 ?= " + openLock(new String[]{"0000"}, "8888"));
        System.out.println("0 ?= " + openLock(new String[]{"2222"}, "0000"));
    }
}
