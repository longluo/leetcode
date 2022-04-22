//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2429 👎 0


// 2022-04-11 22:08:23
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
    // Recursion
    ListNode *reverseList(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return head;
        }

        vector<ListNode *> nodes;
        ListNode *pNode = head;
        while (pNode != NULL) {
            nodes.push_back(pNode);
            pNode = pNode->next;
        }

        for (int i = nodes.size() - 1; i >= 1; i--) {
            ListNode *curNode = nodes[i];
            ListNode *preNode = nodes[i - 1];
            curNode->next = preNode;
        }

        head->next = NULL;

        return nodes[nodes.size() - 1];
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    Solution s;

}