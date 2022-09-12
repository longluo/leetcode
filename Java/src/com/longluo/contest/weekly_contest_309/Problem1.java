package com.longluo.contest.weekly_contest_309;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public boolean checkDistances(String s, int[] distance) {
        Map<Character, int[]> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int[] pos = map.get(ch);
                pos[1] = i;
                map.put(ch, pos);
            } else {
                map.put(ch, new int[]{i, -1});
            }
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            char ch = entry.getKey();
            int[] pos = entry.getValue();
            int dist = pos[1] - pos[0] - 1;
            if (dist != distance[ch - 'a']) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
