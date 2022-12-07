//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2364 👎 0


// 2022-04-13 11:18:08
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // XOR time: O(n) space: O(1)
    int singleNumber_xor(vector<int> &nums) {
        int ans = 0;
        for (auto x : nums) {
            ans = ans ^ x;
        }

        return ans;
    }

    // HashMap time: O(n) space: O(1)
    int singleNumber_hash(vector<int> &nums) {
        int ans = 0;
        unordered_map<int, int> freqMap;
        for (auto x : nums) {
            freqMap[x]++;
        }

        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{2, 2, 1};
    cout << "1 ?= " << s.singleNumber_xor(data) << endl;
    cout << "1 ?= " << s.singleNumber_hash(data) << endl;
}