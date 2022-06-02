package com.longluo.contest.cmb;

/**
 *
 *
 * https://leetcode.cn/contest/cmbchina-2022spring/problems/fWcPGC/
 */
public class Problem1_deleteText {

    public static String deleteText(String article, int index) {
        int len = article.length();
        if (index >= len || article.charAt(index) == ' ') {
            return article;
        }

        int left = index;
        int right = index;
        while (left >= 0 && article.charAt(left) != ' ') {
            left--;
        }

        while (right < len && article.charAt(right) != ' ') {
            right++;
        }

        if (left <= 0) {
            left = 0;
            right++;
        }

        if (right >= len) {
            right = len;
        }

        return article.substring(0, left) + article.substring(right, len);
    }

    public static void main(String[] args) {
        System.out.println(deleteText("Singing dancing in the rain", 10));
        System.out.println(deleteText("Hello World", 2));
        System.out.println(deleteText("Hello World", 5));
    }
}
