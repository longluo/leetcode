//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
// Related Topics 队列 哈希表 字符串 计数 👍 537 👎 0


// 2022-04-11 21:02:23
// By Long Luo

#include<bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> map;
        for (auto ch : s) {
            map[ch]++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.at(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
    cout << "0 ?= " << s.firstUniqChar("leetcode") << endl;
    cout << "2 ?= " << s.firstUniqChar("loveleetcode") << endl;
}