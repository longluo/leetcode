//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3165 👎 0


// 2022-04-11 22:17:17
// By Long Luo

#include <bits/stdc++.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        for (auto ch : s) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stk.push(ch);
            } else if (ch == ')') {
                if (stk.empty() || stk.top() != '(') {
                    return false;
                }

                stk.pop();
            } else if (ch == ']') {
                if (stk.empty() || stk.top() != '[') {
                    return false;
                }

                stk.pop();
            } else if (ch == '}') {
                if (stk.empty() || stk.top() != '{') {
                    return false;
                }

                stk.pop();
            }
        }

        if (stk.empty()) {
            return true;
        }

        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    cout << "true ?= " << s.isValid("()") << endl;
    cout << "true ?= " << s.isValid("()[]{}") << endl;
    cout << "false ?= " << s.isValid("(]") << endl;
}