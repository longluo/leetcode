package com.longluo.pinduoduo;

/**
 * 多多的魔术盒子
 * <p>
 * 多多鸡有N个魔术盒子（编号1～N），其中编号为i的盒子里有i个球。 多多鸡让皮皮虾每次选择一个数字X（1 <= X <= N），多多鸡就会把球数量大于等于X个的盒子里的球减少X个。
 * 通过观察，皮皮虾已经掌握了其中的奥秘，并且发现只要通过一定的操作顺序，可以用最少的次数将所有盒子里的球变没。
 * <p>
 * 那么请问聪明的你，是否已经知道了应该如何操作呢？
 */
public class Pinduoduo2020_magicBoxes {

    private static int leastTimes(int n) {
        return (int) (Math.log(n) / Math.log(2)) + 1;
    }

    private static int leastTimes_power(int n) {
        int ans = 1;

        for (int i = 0; i <= Math.sqrt(n); i++) {
            if (Math.pow(2, i) <= n) {
                ans = i;
            } else {
                break;
            }
        }

        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + leastTimes(1));
        System.out.println("2 ?= " + leastTimes(2));
        System.out.println("3 ?= " + leastTimes(5));

        System.out.println("1 ?= " + leastTimes_power(1));
        System.out.println("2 ?= " + leastTimes_power(2));
        System.out.println("3 ?= " + leastTimes_power(5));
    }
}
