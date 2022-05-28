package com.longluo.contest.biweekly_contest_79;

import java.util.*;

public class Problem2 {

    public static String largestWordCount(String[] messages, String[] senders) {
        int len = messages.length;
        int[] wordCount = new int[len];
        for (int i = 0; i < len; i++) {
            wordCount[i] = messages[i].split("\\s+").length;
        }

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String name = senders[i];
            map.put(senders[i], map.getOrDefault(name, 0) + wordCount[i]);
        }

        List<String[]> senderList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            senderList.add(new String[]{entry.getKey(), entry.getValue().toString()});
        }

        Collections.sort(senderList, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])) {
                    return o2[0].compareTo(o1[0]);
                }

                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        return senderList.get(0)[0];
    }

    public static void main(String[] args) {

    }
}
