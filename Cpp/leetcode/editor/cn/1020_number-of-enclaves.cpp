//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 163 👎 0


// 2022-04-10 21:53:21
// By Long Luo

#include<bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // BFS OK
    int numEnclaves(vector<vector<int>> &grid) {
        int row = grid.size();
        int col = grid[0].size();
        vector<vector<bool>> visited = vector<vector<bool>>(row, vector<bool>(col, false));
        for (int i = 0; i < row; i++) {
            if (!visited[i][0] && grid[i][0] == 1) {
                bfs(grid, visited, i, 0, true);
            }
            if (!visited[i][col - 1] && grid[i][col - 1] == 1) {
                bfs(grid, visited, i, col - 1, true);
            }
        }

        for (int i = 0; i < col; i++) {
            if (!visited[0][i] && grid[0][i] == 1) {
                bfs(grid, visited, 0, i, true);
            }
            if (!visited[row - 1][i] && grid[row - 1][i] == 1) {
                bfs(grid, visited, row - 1, i, true);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    bfs(grid, visited, i, j, false);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    ans++;
                }
            }
        }

        return ans;
    }

    void bfs(vector<vector<int>> &grid, vector<vector<bool>> &visited, int x, int y, bool isEdge) {
        int dirs[4][2] = {{-1, 0},
                          {1,  0},
                          {0,  -1},
                          {0,  1}};
        queue<pair<int, int>> queue;
        queue.push({x, y});
        visited[x][y] = true;
        if (isEdge) {
            grid[x][y] = 0;
        } else {
            grid[x][y] = 2;
        }
        while (!queue.empty()) {
            auto pos = queue.front();
            queue.pop();
            int currX = pos.first;
            int currY = pos.second;
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dirs[i][0];
                int nextY = currY + dirs[i][1];
                if (nextY >= 0 && nextX < grid.size() && nextY >= 0 && nextY < grid[0].size()
                    && !visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.push({nextX, nextY});
                    visited[nextX][nextY] = true;
                    if (isEdge) {
                        grid[nextX][nextY] = 0;
                    } else {
                        grid[nextX][nextY] = 2;
                    }
                }
            }
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
    //vector<int> ans = s.twoSum(data,11);
    //cout << ans[0]<<ans[1]<<endl;
    cout << "Hello LeetCode" << endl;
}