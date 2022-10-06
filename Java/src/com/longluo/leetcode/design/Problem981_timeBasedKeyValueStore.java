package com.longluo.leetcode.design;

import java.util.*;

/**
 * 981. 基于时间的键值存储
 * <p>
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 * <p>
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 * <p>
 * 示例 1：
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释：
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
 * kv.get("foo", 1);  // 输出 "bar"
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // 输出 "bar2"
 * kv.get("foo", 5); // 输出 "bar2"
 * <p>
 * 示例 2：
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 * <p>
 * 提示：
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在 [1, 100] 范围内。
 * 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 * <p>
 * https://leetcode.cn/problems/time-based-key-value-store/
 */
public class Problem981_timeBasedKeyValueStore {

    static class TimeMap {

        static class Node {
            public String value;
            public int timestamp;

            Node(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

        Map<String, List<Node>> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                List<Node> list = map.get(key);
                list.add(new Node(value, timestamp));
                map.put(key, list);
            } else {
                List<Node> list = new ArrayList();
                list.add(new Node(value, timestamp));
                map.put(key, list);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            } else {
                List<Node> list = map.get(key);
                if (list.size() == 0) {
                    return "";
                }
                if (list.get(0).timestamp > timestamp) {
                    return "";
                }
                if (list.get(list.size() - 1).timestamp <= timestamp) {
                    return list.get(list.size() - 1).value;
                }

//                for (int i = 0; i < list.size(); i++) {
//                    if (list.get(i).timestamp == timestamp) {
//                        return list.get(i).value;
//                    }
//
//                    if (i + 1 < list.size() && list.get(i).timestamp < timestamp && list.get(i + 1).timestamp > timestamp) {
//                        return list.get(i).value;
//                    }
//                }

                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    int stamp = list.get(mid).timestamp;
                    if (stamp <= timestamp) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }

                return list.get(start - 1).value;
            }
        }
    }

    // HashMap time: O(n) space: O(n)
    static class TimeMap_Map {
        Map<String, Map<String, Integer>> map;

        /**
         * Initialize your data structure here.
         */
        public TimeMap_Map() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                Map<String, Integer> kv = map.get(key);
                kv.put(value, timestamp);
                map.put(key, kv);
            } else {
                Map<String, Integer> kv = new HashMap<>();
                kv.put(value, timestamp);
                map.put(key, kv);
            }
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            String ans = "";
            int maxTime = 0;

            Map<String, Integer> kv = map.get(key);
            for (Map.Entry<String, Integer> entry : kv.entrySet()) {
                int time = entry.getValue();
                if (maxTime < time && time <= timestamp) {
                    maxTime = time;
                    ans = entry.getKey();
                }
            }

            return ans;
        }
    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
    public static void main(String[] args) {
        List<TimeMap.Node> list = new ArrayList<>();
        list.add(new TimeMap.Node("high", 10));
        list.add(new TimeMap.Node("low", 20));

        Collections.sort(list, new Comparator<TimeMap.Node>() {
            @Override
            public int compare(TimeMap.Node o1, TimeMap.Node o2) {
                return o1.timestamp - o2.timestamp;
            }
        });

        int timestamp = 15;
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int stamp = list.get(mid).timestamp;
            if (stamp <= timestamp) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }


        System.out.println(start + " " + " " + end);
        System.out.println(list.get(start - 1).value);
        System.out.println(list.get(start).value);
        System.out.println(list.get(end).value);


        TimeMap_Map tst1 = new TimeMap_Map();
        tst1.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1  
        tst1.get("foo", 1);         // 返回 "bar"
        tst1.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"） 。
        tst1.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4 
        tst1.get("foo", 4);         // 返回 "bar2"
        tst1.get("foo", 5);         // 返回 "bar2"
    }
}
