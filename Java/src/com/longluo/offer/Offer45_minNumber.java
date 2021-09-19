package com.longluo.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * <p>
 * 提示:
 * 0 < nums.length <= 100
 * <p>
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导0，最后结果不需要去掉前导 0
 * <p>
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 */
public class Offer45_minNumber {

    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    private static void sort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (!compareStr(arr[i], arr[j])) {
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    private static boolean compareStr(String a, String b) {
        String aPlusB = a + b;
        String bPlusA = b + a;
        if (aPlusB.compareTo(bPlusA) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("102 ?= " + minNumber(new int[]{10, 2}));
        System.out.println("3033459 ?= " + minNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println("12 ?= " + minNumber(new int[]{2, 1}));
        System.out.println("120 ?= " + minNumber(new int[]{20, 1}));
        System.out.println("1399439856075703697382478249389609 ?= " + minNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
        System.out.println("12112 ?= " + minNumber(new int[]{121, 12}));
        System.out.println("1 ?= " + "2".compareTo("1"));
        System.out.println("-1 ?= " + "1".compareTo("2"));
        System.out.println("-1 ?= " + "1".substring(0, 1).compareTo("20".substring(0, 1)));
        System.out.println("1 ?= " + "20".substring(0, 1).compareTo("1".substring(0, 1)));
    }
}
