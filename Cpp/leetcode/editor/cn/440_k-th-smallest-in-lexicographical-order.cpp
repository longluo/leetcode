//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 492 👎 0


// 2022-04-19 23:03:44
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    //
    int findKthNumber(int n, int k) {
        if (k == 1) {
            return 1;
        }

        int p = 1;
        int cnt = 0;
        while (cnt < k) {
            cnt += count(p, k);

        }

        return p;
    }

    int count(int p, int cnt) {

    }

    //  BF + String time: O(nlogn) space: O(n)
    //  timeout
    int findKthNumber_str(int n, int k) {
        vector<string> nums(n);
        for (int i = 0; i < n; i++) {
            nums[i] = to_string(i + 1);
        }

        sort(nums.begin(), nums.end());
        return atoi(nums[k - 1].c_str());
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    cout << s.findKthNumber(2, 1) << endl;
    cout << s.findKthNumber(10, 3) << endl;
    cout << s.findKthNumber(10, 3) << endl;
}