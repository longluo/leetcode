package com.longluo.leetcode.string;

/**
 * 1108. IP 地址无效化
 *
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 示例 1：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 示例 2：
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * <p>
 * 提示：
 * 给出的 address 是一个有效的 IPv4 地址
 * <p>
 * https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class Problem1108_defangingAnIPAddr {

    // StringBuilder time: O(n) space: O(n)
    public static String defaultIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.') {
                sb.append(address.charAt(i));
            } else {
                sb.append("[.]");
            }
        }

        return sb.toString();
    }

    // Regex time: O(n) space: O(1)
    public static String defaultIPaddr_regex(String address) {
        return address.replaceAll(".", "[.]");
    }

    // Replace API time: O(n) space: O(1)
    public static String defaultIPaddr_replace(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println("1[.]1[.]1[.]1 ?= " + defaultIPaddr("1.1.1.1"));
        System.out.println("1[.]1[.]1[.]1 ?= " + defaultIPaddr_regex("1.1.1.1"));

        System.out.println("255[.]100[.]50[.]0 ?= " + defaultIPaddr("255.100.50.0"));
        System.out.println("255[.]100[.]50[.]0 ?= " + defaultIPaddr_regex("255.100.50.0"));

        System.out.println("255[.]100[.]50[.]0 ?= " + defaultIPaddr_replace("255.100.50.0"));
    }
}
