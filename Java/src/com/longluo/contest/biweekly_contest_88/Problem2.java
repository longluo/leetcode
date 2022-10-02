package com.longluo.contest.biweekly_contest_88;

public class Problem2 {

    static class LUPrefix {
        boolean[] mark;
        int prefix = 0;
        int total = 0;

        public LUPrefix(int n) {
            total = n;
            prefix = 0;
            mark = new boolean[n];
        }

        public void upload(int video) {
            mark[video - 1] = true;
            while (prefix < total && mark[prefix]) {
                prefix++;
            }
        }

        public int longest() {
            return prefix;
        }
    }

    public static void main(String[] args) {
        LUPrefix tst1 = new LUPrefix(4);
        tst1.upload(3);
        tst1.longest();
        tst1.upload(1);
        tst1.longest();
        tst1.upload(2);
        tst1.longest();
    }
}
