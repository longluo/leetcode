package com.longluo.contest.weekly_contest_317;

import java.util.*;

/**
 * https://leetcode.cn/problems/most-popular-video-creator/
 */
public class Problem2 {

    // HashMap time: O(n) space: O(n)
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int len = creators.length;

        Map<String, Long> countViewsMap = new HashMap<>();
        Map<String, List<Pair>> creatorIdMap = new HashMap<>();

        long maxViews = 0;

        for (int i = 0; i < len; i++) {
            String creator = creators[i];

            long cnt = countViewsMap.getOrDefault(creator, 0L);
            cnt += views[i];

            maxViews = Math.max(maxViews, cnt);

            countViewsMap.put(creator, cnt);

            creatorIdMap.putIfAbsent(creator, new ArrayList<>());
            List<Pair> idsList = creatorIdMap.get(creator);
            idsList.add(new Pair(ids[i], views[i]));

            creatorIdMap.put(creator, idsList);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, Long> entry : countViewsMap.entrySet()) {
            String creator = entry.getKey();
            long value = entry.getValue();

            if (value == maxViews) {
                List<String> item = new ArrayList<>();
                item.add(creator);

                List<Pair> idsList = creatorIdMap.get(creator);

                Collections.sort(idsList, (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

                item.add(idsList.get(0).getKey());

                ans.add(item);
            }
        }

        return ans;
    }

    static class Pair {
        String key;
        int value;

        Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println("[[alice, b]] ?= " + mostPopularCreator(new String[]{"alice", "alice", "alice"}, new String[]{"a", "b", "c"}, new int[]{1, 2, 2}));
    }
}
