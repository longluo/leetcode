package com.longluo.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 提示：
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * <p>
 * https://leetcode.cn/problems/restore-ip-addresses/
 */
public class Problem93_restoreIpAddresses {

    // BF time: O(n^3) space: O(n)
    public static List<String> restoreIpAddresses_bf(String s) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        if (len < 4) {
            return ans;
        }

        for (int i = 0; i < 3 && i < len - 3; i++) {
            String[] ips = new String[4];
            String ip1 = s.substring(0, i + 1);
            if (!checkValid(ip1)) {
                continue;
            }

            ips[0] = ip1;

            for (int j = i + 1; j <= i + 3 && j < len - 2; j++) {
                String ip2 = s.substring(i + 1, j + 1);
                if (!checkValid(ip2)) {
                    continue;
                }

                ips[1] = ip2;

                for (int k = j + 1; k <= j + 3 && k >= len - 6 && k < len - 1; k++) {
                    String ip3 = s.substring(j + 1, k + 1);
                    String ip4 = s.substring(k + 1);
                    if (!checkValid(ip3) || !checkValid(ip4)) {
                        continue;
                    }

                    ips[2] = ip3;
                    ips[3] = ip4;

                    StringBuilder sb = new StringBuilder();
                    for (int l = 0; l < 3; l++) {
                        sb.append(ips[l]).append(".");
                    }

                    sb.append(ips[3]);
                    ans.add(sb.toString());
                }
            }
        }

        return ans;
    }

    public static boolean checkValid(String str) {
        long ip = Long.parseLong(str);
        if (str.equals("0") || (ip > 0 && ip <= 255 && str.charAt(0) != '0')) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("[0,0,0,0] ?= " + restoreIpAddresses_bf("0000"));
        System.out.println("[255.255.11.135, 255.255.111.35] ?= " + restoreIpAddresses_bf("25525511135"));
    }
}
