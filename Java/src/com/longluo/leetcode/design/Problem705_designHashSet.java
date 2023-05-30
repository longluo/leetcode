package com.longluo.leetcode.design;

import java.util.*;

/**
 * 705. 设计哈希集合
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * <p>
 * 提示：
 * 0 <= key <= 10^6
 * 最多调用 10^4 次 add、remove 和 contains 。
 * <p>
 * 进阶：你可以不使用内建的哈希集合库解决此问题吗？
 */
public class Problem705_designHashSet {

    static class MyHashSet {
        private static final int BASE = 593;
        private LinkedList[] data;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int loc = hash(key);

            Iterator<Integer> iterator = data[loc].iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                if (number == key) {
                    return;
                }
            }

            data[loc].offerLast(key);
        }

        public void remove(int key) {
            int loc = hash(key);
            Iterator<Integer> iterator = data[loc].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    data[loc].remove(element);
                    return;
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int loc = hash(key);
            Iterator<Integer> iterator = data[loc].iterator();
            while (iterator.hasNext()) {
                Integer element = iterator.next();
                if (element == key) {
                    return true;
                }
            }

            return false;
        }

        private int hash(int key) {
            return key % BASE;
        }
    }

    static class MyHashSet_list {
        List<Integer> dataList;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet_list() {
            dataList = new ArrayList<>();
        }

        public void add(int key) {
            for (int x : dataList) {
                if (x == key) {
                    return;
                }
            }

            dataList.add(key);
        }

        public void remove(int key) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i) == key) {
                    dataList.remove(i);
                    break;
                }
            }
        }

        public boolean contains(int key) {
            for (int x : dataList) {
                if (x == key) {
                    return true;
                }
            }

            return false;
        }
    }

    /**
     * Your MyHashSet object will be instantiated and called as such:
     * MyHashSet obj = new MyHashSet();
     * obj.add(key);
     * obj.remove(key);
     * boolean param_3 = obj.contains(key);
     */
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println("true ?= " + myHashSet.contains(1));
        System.out.println("false ?= " + myHashSet.contains(3));
        myHashSet.add(2);      // set = [1, 2]
        System.out.println("true ?= " + myHashSet.contains(2));
        myHashSet.remove(2);   // set = [1]
        System.out.println("false ?= " + myHashSet.contains(2));
    }
}
