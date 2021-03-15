package com.longluo.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * 706. 设计哈希映射
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * 示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * 提示：
 * 0 <= key, value <= 10^6
 * 最多调用10^4次put、get和remove方法
 * <p>
 * 进阶：你能否不使用内置的 HashMap 库解决此问题？
 */
public class Problem706_designHashMap {

    class MyHashMap {

        class Pair {
            int key;
            int value;

            Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            void setKey(int key) {
                this.key = key;
            }

            void setValue(int value) {
                this.value = value;
            }

            int getKey() {
                return key;
            }

            int getValue() {
                return value;
            }
        }

        List<Pair> list;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            list = new ArrayList<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    list.get(i).value = value;
                    return;
                }
            }

            list.add(new Pair(key, value));
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    return list.get(i).value;
                }
            }

            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).key == key) {
                    list.remove(i);
                    return;
                }
            }
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
