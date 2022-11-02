package com.longluo.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 * <p>
 * 基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
 * <p>
 * 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
 * <p>
 * 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
 * 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。（变化后的基因必须位于基因库 bank 中）
 * <p>
 * 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。
 * 如果无法完成此基因变化，返回 -1 。
 * <p>
 * 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
 * <p>
 * 示例 1：
 * 输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC","AACCCCCC"]
 * 输出：3
 * <p>
 * 提示：
 * start.length == 8
 * end.length == 8
 * 0 <= bank.length <= 10
 * bank[i].length == 8
 * start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
 * <p>
 * https://leetcode.cn/problems/minimum-genetic-mutation/
 */
public class Problem433_minimumGeneticMutation {

    // BFS time: O(mL) space: O(n)
    public static int minMutation(String start, String end, String[] bank) {
        char[] dirs = {'A', 'C', 'G', 'T'};

        Set<String> bankSet = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int nodesSize = queue.size();
            for (int i = 0; i < nodesSize; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return steps;
                }

                for (char dir : dirs) {
                    for (int j = 0; j < cur.length(); j++) {
                        String nextStr = cur.substring(0, j) + dir + cur.substring(j + 1);
                        if (visited.contains(nextStr) || !bankSet.contains(nextStr)) {
                            continue;
                        }

                        visited.add(nextStr);
                        queue.offer(nextStr);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println("2 ?= " + minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println("3 ?= " + minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
