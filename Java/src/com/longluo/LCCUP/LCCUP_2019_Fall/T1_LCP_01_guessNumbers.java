package com.longluo.LCCUP.LCCUP_2019_Fall;

/**
 * LCP 01. 猜数字
 * <p>
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。
 * 他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * 示例 1：
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 * <p>
 * 示例 2：
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 * <p>
 * 限制：
 * guess 的长度 = 3
 * answer 的长度 = 3
 * guess 的元素取值为 {1, 2, 3} 之一。
 * answer 的元素取值为 {1, 2, 3} 之一。
 * <p>
 * https://leetcode.cn/problems/guess-numbers/
 */
public class T1_LCP_01_guessNumbers {

    // Simulate time: O(C) space: O(1)
    public static int game(int[] guess, int[] answer) {
        int len = guess.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (guess[i] == answer[i]) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
}
