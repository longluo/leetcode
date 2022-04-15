//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1262 👎 0


// 2022-04-15 22:46:04
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // Backtrack time: O(m * n * 3^L) space: O(m * n)
    bool exist(vector<vector<char>> &board, string word) {
        int row = board.size();
        int col = board[0].size();
        vector<vector<bool>> visited(row, vector<bool>(col, false));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (backtrack(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    bool backtrack(vector<vector<char>> &board, vector<vector<bool>> &visited, int x, int y, int idx, string word) {
        if (board[x][y] != word.at(idx)) {
            return false;
        }

        if (board[x][y] == word.at(idx) && idx == word.length() - 1) {
            return true;
        }

        int dirs[4][2] = {{-1, 0},
                          {1,  0},
                          {0,  -1},
                          {0,  1}};

        visited[x][y] = true;
        bool result = false;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX >= 0 && nextX < board.size() && nextY >= 0 && nextY < board[0].size()) {
                if (!visited[nextX][nextY]) {
                    if (backtrack(board, visited, nextX, nextY, idx + 1, word)) {
                        result = true;
                        break;
                    }
                }
            }
        }

        visited[x][y] = false;
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
    vector<vector<char>> mat(3, vector<char>(3, 'A'));
    s.exist(mat, "aab");
}