//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 291 👎 0


// 2022-04-18 10:32:34
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> lexicalOrder(int n) {
        vector<int> ans(n);
        int number = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = number;
            if (10 * number <= n) {
                number = 10 * number;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }

                number++;
            }
        }

        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    s.lexicalOrder(15);
    s.lexicalOrder(103);
    s.lexicalOrder(126);
}