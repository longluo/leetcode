package com.longluo.top_interviews;

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
 * https://leetcode.cn/problems/word-search-ii/
 */
public class Problem212_wordSearch_ii {

    // Backtrack
    // TLE
    public static List<String> findWords_bf(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        int m = board.length;
        int n = board[0].length;

        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];

        StringBuilder path = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path.append(board[i][j]);
                visited[i][j] = true;
                backtrack(res, path, board, visited, i, j);
                visited[i][j] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }

        for (String s : res) {
            if (set.contains(s)) {
                ans.add(s);
            }
        }

        return ans;
    }

    private static void backtrack(Set<String> res, StringBuilder path, char[][] board, boolean[][] visited, int x, int y) {
        if (path.length() > 10) {
            return;
        }

        res.add(path.toString());

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = board.length;
        int n = board[0].length;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (!isInArea(m, n, nextX, nextY)) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            path.append(board[nextX][nextY]);
            backtrack(res, path, board, visited, nextX, nextY);
            path.deleteCharAt(path.length() - 1);
            visited[nextX][nextY] = false;
        }
    }

    private static boolean isInArea(int row, int col, int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    // DFS
    // TLE
    public static List<String> findWords_dfs(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        StringBuilder path = new StringBuilder();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path.append(board[i][j]);
                visited[i][j] = true;
                dfs(ans, set, path, board, visited, i, j);
                visited[i][j] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }

        return ans;
    }

    private static void dfs(List<String> ans, Set<String> set, StringBuilder path, char[][] board, boolean[][] visited, int x, int y) {
        if (path.length() > 10) {
            return;
        }

        if (set.contains(path.toString())) {
            ans.add(path.toString());
            set.remove(path.toString());
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int m = board.length;
        int n = board[0].length;

        for (int[] dir : dirs) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }

            if (visited[nextX][nextY]) {
                continue;
            }

            visited[nextX][nextY] = true;
            path.append(board[nextX][nextY]);
            dfs(ans, set, path, board, visited, nextX, nextY);
            path.deleteCharAt(path.length() - 1);
            visited[nextX][nextY] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("[] ?= " + findWords_bf(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd"}));
        System.out.println("[eat, oath] ?= " + findWords_bf(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println("[abcdefg, befa, eaabcdgfa, gfedcbaaa] ?= " + findWords_bf(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}));
        System.out.println("[eaabcdgfa, eaafgdcba] ?= " + findWords_bf(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"eaafgdcba", "eaabcdgfa"}));

        System.out.println("[] ?= " + findWords_dfs(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd"}));
        System.out.println("[eat, oath] ?= " + findWords_dfs(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
        System.out.println("[abcdefg, befa, eaabcdgfa, gfedcbaaa] ?= " + findWords_dfs(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"}));
        System.out.println("[eaabcdgfa, eaafgdcba] ?= " + findWords_dfs(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"eaafgdcba", "eaabcdgfa"}));
    }
}

/**
 * abc
 * aed
 * afg
 */