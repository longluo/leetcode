package com.longluo.leetcode.segmenttree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 * <p>
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的日程安排不会造成 重复预订 ，则可以存储这个新的日程安排。
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生 重复预订 。
 * 日程可以用一对整数 start 和 end 表示，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end 。
 * <p>
 * 实现 MyCalendar 类：
 * MyCalendar() 初始化日历对象。
 * boolean book(int start, int end) 如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true 。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 示例：
 * 输入：
 * ["MyCalendar", "book", "book", "book"]
 * [[], [10, 20], [15, 25], [20, 30]]
 * 输出：
 * [null, true, false, true]
 * <p>
 * 解释：
 * MyCalendar myCalendar = new MyCalendar();
 * myCalendar.book(10, 20); // return True
 * myCalendar.book(15, 25); // return False ，这个日程安排不能添加到日历中，因为时间 15 已经被另一个日程安排预订了。
 * myCalendar.book(20, 30); // return True ，这个日程安排可以添加到日历中，因为第一个日程安排预订的每个时间都小于 20 ，且不包含时间 20 。
 * <p>
 * 提示：
 * 0 <= start < end <= 10^9
 * 每个测试用例，调用 book 方法的次数最多不超过 1000 次。
 * <p>
 * https://leetcode.cn/problems/my-calendar-i/
 */
public class Problem729_myCalendar_i {

    // BF time: O(nlogn) space: O(n)
    static class MyCalendar {
        List<int[]> bookList;

        public MyCalendar() {
            bookList = new ArrayList<>();
        }

        // time: O(nlogn)
        public boolean book(int start, int end) {
            if (bookList.size() == 0) {
                bookList.add(new int[]{start, end});
                return true;
            }

            Collections.sort(bookList, (book1, book2) -> {
                if (book1[0] == book2[0]) {
                    return book1[1] - book2[1];
                }
                return book1[0] - book2[0];
            });

            if (start >= bookList.get(bookList.size() - 1)[1] || end <= bookList.get(0)[0]) {
                bookList.add(new int[]{start, end});
                return true;
            }

            int len = bookList.size();
            for (int i = 0; i < len - 1; i++) {
                if (start >= bookList.get(i)[1] && end <= bookList.get(i + 1)[0]) {
                    bookList.add(new int[]{start, end});
                    return true;
                }
            }

            return false;
        }

        // time: O(n^2)
        public boolean book_opt(int start, int end) {
            for (int[] time : bookList) {
                if (start < time[1] && end >= time[0]) {
                    return false;
                }
            }

            bookList.add(new int[]{start, end});
            return true;
        }
    }

    // BinarySearch time: O(nlogn) space: O(n)
    static class MyCalendar_BS {
        List<Integer> bookList;

        public MyCalendar_BS() {
            bookList = new ArrayList<>();
        }

        // time: O(nlogn)
        public boolean book(int start, int end) {
            if (bookList.size() <= 0) {
                bookList.add(start);
                bookList.add(end);
                return true;
            }

            Collections.sort(bookList);
            int len = bookList.size();
            if (end <= bookList.get(0) || start >= bookList.get(len - 1)) {
                bookList.add(start);
                bookList.add(end);
                return true;
            }

            int loc = binarySearch(bookList, start);
            if (loc % 2 == 0) {
                if (loc + 2 < len && start >= bookList.get(loc + 1) && end <= bookList.get(loc + 2)) {
                    bookList.add(loc + 2, start);
                    bookList.add(loc + 3, end);
                    return true;
                }
            } else {
                if (loc + 1 < len && start >= bookList.get(loc) && end <= bookList.get(loc + 1)) {
                    bookList.add(loc + 1, start);
                    bookList.add(loc + 2, end);
                    return true;
                }
            }

            return false;
        }

        private int binarySearch(List<Integer> numsList, int target) {
            int len = numsList.size();
            int left = 0;
            int right = len - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (numsList.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }

    public static void main(String[] args) {
        MyCalendar_BS myCalendar = new MyCalendar_BS();
        myCalendar.book(47, 50);
        myCalendar.book(33, 41);
        myCalendar.book(39, 45);
        myCalendar.book(33, 42);
    }
}
