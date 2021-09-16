package com.longluo.leetcode.trie;

import java.util.*;

/**
 * 212. 单词搜索 II
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 * <p>
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class Problem212_wordSearch_ii {

    public static boolean[][] visited = new boolean[13][13];

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return ans;
        }

        for (String word : words) {
            if (searchWord(board, word)) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static boolean searchWord(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
//                    if (bfs(board, i, j, word)) {
//                        return true;
//                    }

                    for (int k = 0; k < visited.length; k++) {
                        Arrays.fill(visited[k], false);
                    }

                    if (dfs(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean bfs(char[][] board, int x, int y, String word) {
        int length = word.length();
        if (length == 1) {
            return true;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int nextX = currPos[0] + dirs[j][0];
                    int nextY = currPos[1] + dirs[j][1];
                    if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                        continue;
                    }
                    if (!visited[nextX][nextY] && board[nextX][nextY] == word.charAt(step)) {
                        if (step == length - 1) {
                            return true;
                        }

                        queue.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int x, int y, String word, int step) {
        int length = word.length();
        if (step == length) {
            return true;
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = board.length;
        int col = board[0].length;
        visited[x][y] = true;
        for (int j = 0; j < dirs.length; j++) {
            int nextX = x + dirs[j][0];
            int nextY = y + dirs[j][1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
                continue;
            }
            if (!visited[nextX][nextY] && board[nextX][nextY] == word.charAt(step)) {
                return dfs(board, nextX, nextY, word, step + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println("eat, oath ?= " + findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
//        System.out.println("[] ?= " + findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd"}));
        // bfs的坑 eaabcdgfa
//        System.out.println("[abcdefg,befa,eaabcdgfa,gfedcbaaa] ?= " + findWords(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}));
        System.out.println("[eaabcdgfa, eaafgdcba] ?= " + findWords(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"eaafgdcba", "eaabcdgfa"}));
    }
}

/**
 * abc
 * aed
 * afg
 */