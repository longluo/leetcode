package com.longluo.leetcode.graph;

import java.util.*;

public class Problem210_findOrder {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null || prerequisites.length == 0) {
            return new int[0];
        }

        int[] result = new int[numCourses];

        int[] inDegres = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            inDegres[pre[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegres[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            inDegres[node]--;
            result[count] = node;
            count++;
            Set<Integer> set = adj[node];
            for (Integer child : set) {
                inDegres[child]--;
                if (inDegres[child] == 0) {
                    queue.offer(child);
                }
            }
        }

        if (count == numCourses) {
            return result;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println("[0, 1] ?= " + Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }
}
