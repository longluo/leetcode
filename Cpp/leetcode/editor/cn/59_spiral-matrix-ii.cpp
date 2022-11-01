//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 671 👎 0


// 2022-04-13 08:07:22
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // BF
    vector<vector<int>> generateMatrix(int n) {

        vector<vector<int>> mat(n, vector<int>(n));

        vector<vector<int>> dirs = {{0,  1},
                                    {1,  0},
                                    {0,  -1},
                                    {-1, 0}};

        int dirIdx = 0;

        int x = 0;
        int y = 0;

        for (int i = 1; i <= n * n; i++) {
            mat[x][y] = i;

            int nextX = x + dirs[dirIdx][0];
            int nextY = y + dirs[dirIdx][1];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || mat[nextX][nextY] != 0) {
                dirIdx = (dirIdx + 1) % 4;
            }

            x += dirs[dirIdx][0];
            y += dirs[dirIdx][1];
        }

        return mat;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
    s.generateMatrix(3);
    s.generateMatrix(5);
    cout << "Hello LeetCode" << endl;
}