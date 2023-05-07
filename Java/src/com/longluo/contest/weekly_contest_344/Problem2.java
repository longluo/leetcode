package com.longluo.contest.weekly_contest_344;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/contest/weekly-contest-344
 */
public class Problem2 {

    class FrequencyTracker {
        Map<Integer, Integer> countMap;
        Map<Integer, Integer> freqMap;

        public FrequencyTracker() {
            countMap = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public void add(int number) {
            int freq = countMap.getOrDefault(number, 0);
            countMap.put(number, freq + 1);
            freqMap.put(freq, freqMap.getOrDefault(freq, 0) - 1);
            freqMap.put(freq + 1, freqMap.getOrDefault(freq + 1, 0) + 1);
        }

        public void deleteOne(int number) {
            if (countMap.containsKey(number)) {
                int value = countMap.get(number);
                if (value > 1) {
                    countMap.put(number, value - 1);
                    freqMap.put(value - 1, freqMap.getOrDefault(value - 1, 0) + 1);
                    freqMap.put(value, freqMap.getOrDefault(value, 0) - 1);
                } else {
                    countMap.remove(number);
                    freqMap.put(1, freqMap.get(1) - 1);
                }
            }
        }

        public boolean hasFrequency(int frequency) {
            if (freqMap.containsKey(frequency) && freqMap.get(frequency) > 0) {
                return true;
            } else {
                return false;
            }
        }
    }


    public static void main(String[] args) {

    }
}
