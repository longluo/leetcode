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
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> mat(n, vector<int>(n));
        int cycle = (n + 1) / 2;
        int idx = 1;
        for (int c = 0; c < cycle; c++) {
            for (int i = c; i < n - c; i++) {
                mat[c][i] = idx++;
                if (idx > n * n) {
                    return mat;
                }
            }

            for (int j = c + 1; j < n - c; j++) {
                mat[j][n - 1 - c] = idx++;
                if (idx > n * n) {
                    return mat;
                }
            }

            for (int k = n - 2 - c; k >= c; k--) {
                mat[n - 1 - c][k] = idx++;
                if (idx > n * n) {
                    return mat;
                }
            }

            for (int l = n - 2 - c; l > c; l--) {
                mat[l][c] = idx++;
                if (idx > n * n) {
                    return mat;
                }
            }
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