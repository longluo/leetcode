package com.longluo.contest.biweekly_contest_95;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.cn/contest/biweekly-contest-95
 */
public class Problem2 {

    class DataStream_list {
        List<Integer> list;
        int index;

        int value;
        int k;

        public DataStream_list(int value, int k) {
            list = new ArrayList<>();
            index = -1;

            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            list.add(num);
            index++;

            if (index < k - 1) {
                return false;
            }

            for (int i = index; i >= index - k + 1; i--) {
                if (list.get(i) != value) {
                    return false;
                }
            }

            return true;
        }
    }

    class DataStream {
        int value;
        int k;

        int lastNot = -1;
        int index = -1;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;

            lastNot = -1;
            index = -1;
        }

        public boolean consec(int num) {
            index++;

            if (num != value) {
                lastNot = index;
                return false;
            }

            if (index - lastNot < k) {
                return false;
            }

            return true;
        }
    }


    public static void main(String[] args) {

    }
}
