package com.longluo.contest.weekly_contest_294;

/**
 *
 */
public class Problem2278_percentageOfLetterInString {

    // BF time: O(n) space: O(1)
    public static int percentageLetter(String s, char letter) {
        int len = s.length();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == letter) {
                ans++;
            }
        }

        return ans * 100 / len;
    }

    public static void main(String[] args) {
        percentageLetter("foobar", 'o');
    }
}
