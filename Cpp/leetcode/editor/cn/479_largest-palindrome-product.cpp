//给定一个整数 n ，返回 可表示为两个 n 位整数乘积的 最大回文整数 。因为答案可能非常大，所以返回它对 1337 取余 。 
//
// 
//
// 示例 1: 
//
// 
//输入：n = 2
//输出：987
//解释：99 x 91 = 9009, 9009 % 1337 = 987
// 
//
// 示例 2: 
//
// 
//输入： n = 1
//输出： 9
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 数学 👍 69 👎 0


// 2022-04-16 11:03:19
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // Math time: O(10^(2n)) space: O(1)
    int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        int ans = 0;
        int max = std::pow(10, n) - 1;
        for (int i = max; ans == 0; i--) {
            long num = i;

            for (int j = i; j > 0; j /= 10) {
                num = 10 * num + j % 10;
            }

            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) {
                    ans = num % 1337;
                    return ans;
                }
            }
        }

        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    cout << "9 ?= " << s.largestPalindrome(1) << endl;
    cout << "987 ?= " << s.largestPalindrome(2) << endl;
    cout << "123 ?= " << s.largestPalindrome(3) << endl;
}