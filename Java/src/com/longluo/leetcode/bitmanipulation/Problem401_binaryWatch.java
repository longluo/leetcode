package com.longluo.leetcode.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 401. 二进制手表
 * <p>
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，
 * 最低位在右侧。
 * 例如，下面的二进制手表读取 "3:25" 。
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 Unported (CC BY-SA 3.0) ）
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
 * 你可以 按任意顺序返回答案。
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= turnedOn <= 10
 * <p>
 * https://leetcode-cn.com/problems/binary-watch/
 */
public class Problem401_binaryWatch {

    public static List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn >= 9) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        return res;
    }

    public static void backtrack(List<String> ans, int hours, int minutes, int total) {
        if (hours  == total) {

            return;
        }

        for (int i = 0; i < 4; i++) {

        }
    }

    public static void main(String[] args) {
        System.out.println("[0:00] ?= " + readBinaryWatch(0));
        System.out.println("[0:01,0:02,0:04,0:08,0:16,0:32,1:00,2:00,4:00,8:00] ?= " + readBinaryWatch(1));
        System.out.println("[] ?= " + readBinaryWatch(9));
    }
}
