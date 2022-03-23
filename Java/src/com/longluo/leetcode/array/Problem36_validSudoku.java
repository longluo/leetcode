package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * <p>
 * Medium
 * <p>
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Example 1:
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 * <p>
 * Example 2:
 * Input: board =
 * [['8','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * <p>
 * https://leetcode.com/problems/valid-sudoku/
 */
public class Problem36_validSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0';
                    Set<Integer> rowSet = rowMap.get(i);
                    if (!rowSet.add(num)) {
                        return false;
                    }

                    Set<Integer> colSet = colMap.get(j);
                    if (!colSet.add(num)) {
                        return false;
                    }
                }
            }
        }

        for (int subIdx = 0; subIdx < 9; subIdx++) {
            int subRow = 3 * (subIdx / 3);
            int subCol = 3 * (subIdx % 3);
            Set<Integer> grpSet = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char ch = board[subRow + i][subCol + j];
                    if (ch != '.') {
                        int num = ch - '0';
                        if (!grpSet.add(num)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValidSudoku_better(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> subMap = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            subMap.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0';
                    Set<Integer> rowSet = rowMap.get(i);
                    if (!rowSet.add(num)) {
                        return false;
                    }

                    Set<Integer> colSet = colMap.get(j);
                    if (!colSet.add(num)) {
                        return false;
                    }

                    int subIdx = 3 * (i / 3) + j / 3;
                    Set<Integer> subSet = subMap.get(subIdx);
                    if (!subSet.add(num)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean isValidSudoku_array(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] subBox = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    int num = ch - '0' - 1;
                    row[i][num]++;
                    col[j][num]++;
                    subBox[i / 3][j / 3][num]++;
                    if (row[i][num] > 1 || col[j][num] > 1 || subBox[i / 3][j / 3][num] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isValidSudoku(new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));


        System.out.println("false ?= " + isValidSudoku(new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));

        System.out.println("true ?= " + isValidSudoku_better(new char[][]
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));


        System.out.println("false ?= " + isValidSudoku_better(new char[][]{
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        }));
    }
}
