package com.longluo.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1629. 按键持续时间最长的键
 * <p>
 * LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 n 个），每次一个。
 * 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。
 * releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。字符串和数组的 下标都从 0 开始 。
 * 第 0 个键在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
 * 测试人员想要找出按键 持续时间最长 的键。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，
 * 第 0 次按键的持续时间为 releaseTimes[0] 。
 * 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
 * 请返回按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 * <p>
 * 示例 1：
 * 输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * 输出："c"
 * 解释：按键顺序和持续时间如下：
 * 按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * 按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * 按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * 按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * 按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * 'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 * <p>
 * 示例 2：
 * 输入：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * 输出："a"
 * 解释：按键顺序和持续时间如下：
 * 按下 's' ，持续时间 12
 * 按下 'p' ，持续时间 23 - 12 = 11
 * 按下 'u' ，持续时间 36 - 23 = 13
 * 按下 'd' ，持续时间 46 - 36 = 10
 * 按下 'a' ，持续时间 62 - 46 = 16
 * 按键持续时间最长的键是 'a' ，持续时间 16
 * <p>
 * 提示：
 * releaseTimes.length == n
 * keysPressed.length == n
 * 2 <= n <= 1000
 * 1 <= releaseTimes[i] <= 10^9
 * releaseTimes[i] < releaseTimes[i+1]
 * keysPressed 仅由小写英文字母组成
 * <p>
 * https://leetcode-cn.com/problems/slowest-key/
 */
public class Problem1629_slowestKey {

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        if (releaseTimes == null || releaseTimes.length <= 1) {
            return keysPressed.charAt(0);
        }

        int len = releaseTimes.length;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int time = releaseTimes[i];
            if (i >= 1) {
                time = releaseTimes[i] - releaseTimes[i - 1];
            }
            ans.add(new int[]{time, keysPressed.charAt(i)});
        }

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
            }
        });

        return (char)ans.get(0)[1];
    }

    public static void main(String[] args) {

    }
}
