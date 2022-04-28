//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。 
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
// Related Topics 深度优先搜索 数组 矩阵 👍 207 👎 0


// 2022-04-28 18:37:46
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int countBattleships(vector<vector<char>> &board) {
        int row = board.size();
        int col = board[0].size();
        vector<vector<bool>> visited(row, vector<bool>(col, false));
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && board[i][j] == 'X') {
                    ans++;
                    search(board, visited, i, j, 0);
                    search(board, visited, i, j, 1);
                    search(board, visited, i, j, 2);
                    search(board, visited, i, j, 3);
                }
            }
        }

        return ans;
    }

    void search(vector<vector<char>> &board, vector<vector<bool>> &marked, int x, int y, int dir) {
        int dirs[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int row = board.size();
        int col = board[0].size();
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] == '.') {
            return;
        }

        marked[x][y] = true;
        int nextX = x + dirs[dir][0];
        int nextY = y + dirs[dir][1];
        search(board, marked, nextX, nextY, dir);
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<vector<char>> data1{{'X','.','.','X'}};
    cout << s.countBattleships(data1) << endl;

    vector<vector<char>> data2{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
    cout << s.countBattleships(data2) << endl;
}