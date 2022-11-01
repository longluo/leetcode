package com.longluo.contest.weekly_contest_301;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/smallest-number-in-infinite-set/
 */
public class Problem2 {

    static class SmallestInfiniteSet {
        List<Integer> numsList;

        public SmallestInfiniteSet() {
            numsList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                numsList.add(i + 1);
            }
        }

        public int popSmallest() {
            int smallest = numsList.get(0);
            numsList.remove(0);
            return smallest;
        }

        public void addBack(int num) {
            for (int i = 0; i < numsList.size(); i++) {
                if (num == numsList.get(i)) {
                    break;
                }

                if (num < numsList.get(i)) {
                    numsList.add(i, num);
                    break;
                }
            }
        }
    }

    /**
     * Your SmallestInfiniteSet object will be instantiated and called as such:
     * SmallestInfiniteSet obj = new SmallestInfiniteSet();
     * int param_1 = obj.popSmallest();
     * obj.addBack(num);
     */
    public static void main(String[] args) {
        SmallestInfiniteSet tst1 = new SmallestInfiniteSet();
        tst1.addBack(2);
        System.out.println(tst1.popSmallest());
        System.out.println(tst1.popSmallest());
        System.out.println(tst1.popSmallest());
        tst1.addBack(1);
        System.out.println(tst1.popSmallest());
        System.out.println(tst1.popSmallest());
        System.out.println(tst1.popSmallest());
    }
}
