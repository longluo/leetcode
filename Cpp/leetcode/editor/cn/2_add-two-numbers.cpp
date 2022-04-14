//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7889 👎 0


// 2022-04-14 09:12:01
// By Long Luo

#include <bits/stdc++.h>
#include <ListNode.h>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Cpp Iteration time: O(m + n) space: O(max(m, n))
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        if (l1 == nullptr) {
            return l2;
        } else if (l2 == nullptr) {
            return l1;
        }

        auto *dummyNode = new ListNode(0);
        ListNode *head = dummyNode;
        int carry = 0;
        while (l1 != nullptr || l2 != nullptr) {
            carry += l1 != nullptr ? l1->val : 0;
            carry += l2 != nullptr ? l2->val : 0;
            auto *node = new ListNode(carry % 10);
            carry /= 10;
            head->next = node;
            head = head->next;

            if (l1 != nullptr) {
                l1 = l1->next;
            }
            if (l2 != nullptr) {
                l2 = l2->next;
            }
        }

        if (carry > 0) {
            head->next = new ListNode(carry);
        }

        return dummyNode->next;
    }

    // Recursion time: O(m + n) space: O(max(m, n))
    ListNode *addTwoNumbers_rec(ListNode *l1, ListNode *l2) {
        if (l1 == nullptr) {
            return l2;
        } else if (l2 == nullptr) {
            return l1;
        }

        return addTwoNumbers(l1, l2, 0);
    }

    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2, int carry) {
        if (l1 == nullptr && l2 == nullptr && carry == 0) {
            return nullptr;
        }

        if (l1 != nullptr) {
            carry += l1->val;
            l1 = l1->next;
        }

        if (l2 != nullptr) {
            carry += l2->val;
            l2 = l2->next;
        }

        ListNode *node = new ListNode(carry % 10);
        node->next = addTwoNumbers(l1, l2, carry / 10);
        return node;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;
    vector<int> data{7, 1, 5, 3, 6, 4};
}