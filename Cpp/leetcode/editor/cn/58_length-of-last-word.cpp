//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为6的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
// Related Topics 字符串 👍 452 👎 0


// 2022-04-14 20:41:28
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    // Reverse Scan time: O(n) space: O(1)
    int lengthOfLastWord(string s) {
        if (s.size() == 0) {
            return 0;
        }

        int len = s.size();
        int right = len - 1;
        while (right >= 0 && s[right] == ' ') {
            right--;
        }

        int left = right;
        while (left >= 0 && isalpha(s[left])) {
            left--;
        }

        return right - left;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    cout << "5 ?= " << s.lengthOfLastWord("Hello World") << endl;
}